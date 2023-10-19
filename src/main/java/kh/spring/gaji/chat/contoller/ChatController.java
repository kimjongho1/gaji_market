package kh.spring.gaji.chat.contoller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import kh.spring.gaji.chat.model.dto.ChatMessageDto;
import kh.spring.gaji.chat.model.dto.ChatRoomDto;
import kh.spring.gaji.chat.model.service.ChatService;
import lombok.extern.slf4j.Slf4j;

//chat controller : 김종호 추가(230922)
@Slf4j
@Controller
public class ChatController {

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
	
}