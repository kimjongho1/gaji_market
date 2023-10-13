package kh.spring.gaji.chat.contoller;

import java.io.Console;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/chat")
	public ModelAndView selectChatHome(
			ModelAndView mv,
			Principal principal
			) {
		// userId 값으로 조회하기 때문에 변수 선언
		String userId = principal.getName();
		// 채팅방 리스트 출력
		List<ChatRoomDto> result1 = chatServiceImpl.getChatRoom(userId);
		for(int i=0; i<result1.size(); i++) {
			result1.get(i).setChatInfo(chatServiceImpl.getChatInfo(result1.get(i).getChatId()));
		}
		mv.addObject("chatRoomList",result1);
		mv.setViewName("chat/chatroom");
		log.info("getChatRoom 실행");
		return mv;
	}

	//채팅 선택
	@GetMapping("/selectRoom")
	@ResponseBody
	public String
//	List<ChatMessageDto>
	selectRoom(
//			ModelAndView mv,
			Principal principal,
//			@RequestParam(name = "chatId") 
			String chatId
			) {
		String userId = principal.getName();
		List<ChatMessageDto> result1 = chatServiceImpl.getChatMessage(Integer.parseInt(chatId));
		System.out.println(result1);
//		mv.addObject("chatMessage",result1);
//		mv.setViewName("chat/chatroom");
//		return result1;
		return new Gson().toJson(result1);
	}

}