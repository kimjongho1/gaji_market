package kh.spring.gaji.chat.contoller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	private SimpMessagingTemplate template; // *****

	@GetMapping("/chat")
	public ModelAndView selectChatHome(ModelAndView mv, Principal principal) {
		// userId 값으로 조회하기 때문에 변수 선언
		String userId = principal.getName();
		// 채팅방 리스트 출력
		List<ChatRoomDto> result1 = chatServiceImpl.getChatRoom(userId);
		for (int i = 0; i < result1.size(); i++) {
			result1.get(i).setChatInfo(chatServiceImpl.getChatInfo(result1.get(i).getChatId()));
		}
		mv.addObject("username", userId);
		mv.addObject("chatRoomList", result1);
		mv.setViewName("chat/chatroom");
		log.info("getChatRoom 실행");
		return mv;
	}

	
	
//	@PostMapping(value = "/member/room")
//	public String create(@RequestParam String roomName, @RequestParam String member, Principal principal,
//	RedirectAttributes rttr) {
//	     log.info("# Create Chat Room, roomName: " + roomName + ", userId: " + userId);
//	String userId = principal.getName();
//	service.AddChatRoom(roomName, userId);
//	service.memberInsert(member);
//	rttr.addFlashAttribute("roomName1", roomName);
//	rttr.addFlashAttribute("member", member);
//	return "redirect:/member/rooms";
//	}
	
	// 채팅방 개설
	@GetMapping("/chat/insertRoom")
	public String createRoom (@RequestParam String sellerId) {
	    System.out.println("createRoom " + sellerId);
	    return "redirect:/chat";
	}
	// 채팅 선택
	@GetMapping("/chat/selectRoom")
	@ResponseBody
	public String selectRoom(Principal principal, int chatId) {
		String userId = principal.getName();
		List<ChatMessageDto> result1 = chatServiceImpl.getChatMessage(chatId);
		System.out.println(result1);
//		mv.addObject("chatMessage",result1);
//		mv.setViewName("chat/chatroom");
//		return result1;
		return new Gson().toJson(result1);
	}

//	@GetMapping("/insultChat")
//	@ResponseBody
//	public String insertMessage(String senderId, String chatNo, String msg) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("senderId", senderId);
//		map.put("chatNo", Integer.parseInt(chatNo));
//		map.put("message", msg);
//		int result1 = chatServiceImpl.insertChatMessage(map);
//		String result2 = null;
//		if(result1 != 1) {
//			result2 ="메시지 DB 저장 실패";
//		} else {
//			result2 ="메시지 DB 저장 성공";
//		}
//		return new Gson().toJson(result2);
//	}

	// JSP로 메시지 출력
	@MessageMapping("/chat/room")
	public void receiveMessage(ChatMessageDto message) {
		template.convertAndSend("/sub/chat/room/" + message.getChatNo(), message);
	}
	
	// DB 저장
	@MessageMapping("/chat/message")
	public void message(ChatMessageDto message){
		//insert 명령어
		template.convertAndSend("/sub/chat/room/" + message.getChatNo(), message);
	}
	
}