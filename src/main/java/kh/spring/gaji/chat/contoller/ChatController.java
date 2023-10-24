package kh.spring.gaji.chat.contoller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;
import kh.spring.gaji.chat.model.dto.ChatMessageDto;
import kh.spring.gaji.chat.model.dto.ChatRoomDto;
import kh.spring.gaji.chat.model.service.ChatService;
import lombok.extern.slf4j.Slf4j;

//chat controller : 김종호 추가(230922)
@Slf4j
@Controller
public class ChatController {
	
	Dotenv dotenv = Dotenv.load();
	Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

	@Autowired
	private ChatService chatServiceImpl;
	@Autowired
	private SimpMessagingTemplate template;

	@GetMapping("/chat")
	public ModelAndView selectChatHome(ModelAndView mv, Principal principal) {
		// userId 값으로 조회하기 때문에 변수 선언
		String userId = principal.getName();
		// 현재 채팅방 리스트 출력
		List<ChatRoomDto> result1 = chatServiceImpl.getChatRoomList(userId);
		for (int i = 0; i < result1.size(); i++) {
			result1.get(i).setChatInfo(chatServiceImpl.getChatInfo(result1.get(i).getChatId()));
		}
		mv.addObject("username", userId);
		mv.addObject("chatRoomList", result1);
		mv.setViewName("chat/chatroom");
		return mv;
	}

	
	// 채팅방 개설
	@GetMapping("/chat/insertRoom")
	public String createRoom (Principal principal, RedirectAttributes attribute,@RequestParam String sellerId, int goodsId) {
		String buyerId;
		String redirectGood = "redirect:/goods/get?goodsId=" + goodsId;
		// nullPointerException을 유도하여 로그인이 되지 않았다면, null값 부여
		try {
			buyerId = principal.getName();
		} catch (NullPointerException e) {
			buyerId = null;
		}
	    if(buyerId != null) {
	    	if(!buyerId.equals(sellerId)) {
	    		// 채팅방을 만들지의 여부

	    		// 현재 채팅방 리스트 출력 (리스트를 확인하고 방이 없다면, 채팅방을 새로 만듦)
	    		List<ChatRoomDto> result1 = chatServiceImpl.getChatRoomList(buyerId);
	    		boolean createRoom = true;
	    		for (int i = 0; i < result1.size(); i++) {
	    			// goodsId는 고유값 이므로 채팅방 중복 조회
	    			int resultGoodsId = result1.get(i).getGoodsId();
	    			if(resultGoodsId == goodsId) {
	    				createRoom = false;
	    			}
	    		}
    			if(createRoom) {
	    			Map<String, Object> map = new HashMap<String, Object>();
    				map.put("goodsId", goodsId);
    				map.put("sellerId", sellerId);
    				map.put("buyerId", buyerId);
    				chatServiceImpl.insertChatRoom(map);
	    		}
	    		return "redirect:/chat";
	    	} else {
	    		attribute.addFlashAttribute("msg", "잘못된 접근입니다.");
	    		return redirectGood;
	    	}
	    } else {
	    	attribute.addFlashAttribute("msg", "로그인이 필요합니다.");
	    	return "redirect:/login";
	    }
	}
	// 채팅 선택
	@GetMapping("/chat/selectRoom")
	@ResponseBody
	public String selectRoom(Principal principal, int chatId) {
		List<ChatMessageDto> result1 = chatServiceImpl.getChatMessage(chatId);
		return new Gson().toJson(result1);
	}

	// JSP로 메시지 출력
	@MessageMapping("/chat/room")
	public void receiveMessage(ChatMessageDto message) {
		template.convertAndSend("/sub/chat/room/" + message.getChatId(), message);
	}
	
	// DB 저장
	@MessageMapping("/chat/message")
	public void message(ChatMessageDto message){
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(message, Map.class);
		chatServiceImpl.insertChatMessage(map);
		//insert 명령어
		template.convertAndSend("/sub/chat/room/" + message.getChatId(), message);
	}
	// DB 저장
	@MessageMapping("/chat/file")
	public void file(ChatMessageDto message){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String imgCode = message.getImgCode();
			String[] strings = message.getImgCode().split(","); // ","을 기준으로 바이트 코드를 나눠준다
			String base64Image = strings[1];
			String extension = ""; // if 문을 통해 확장자명을 정해줌
			if (strings[0].equals("data:image/jpeg;base64")) {
	            extension = "jpeg";
	        } else if (strings[0].equals("data:image/png;base64")){
	            extension = "png";
	        } else {
	            extension = "jpg";
	        }
			byte[] imageBytes = Base64.decodeBase64(base64Image);
			File tempFile = File.createTempFile("image", "." + extension);
			
			try (OutputStream outputStream = new FileOutputStream(tempFile)) {
				outputStream.write(imageBytes); // OutputStream outputStream = new FileOutputStream(tempFile)을 통해 생성한 outputStream 객체에 imageBytes를 작성해준다.
			}
			Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true); // 업로드할 파일의 형식을 정해줌
			Map map = cloudinary.uploader().upload(tempFile, params1);
			String imageUrl = cloudinary.url().generate((String)map.get("secure_url"));
			message.setMessage(imageUrl);
			message.setImgCode(null);
			// url을 chatMessage에 저장
			result.put("chatId", message.getChatId());
			result.put("senderId", message.getSenderId());
			result.put("message", imageUrl);
			chatServiceImpl.insertChatMessage(result);
		} catch (IOException e) {
			e.printStackTrace();
		} // createTempFile을 통해 임시 파일을 생성해준다. (임시파일은 지워줘야함)
		
		template.convertAndSend("/sub/chat/room/" + message.getChatId(), message);
	}
}