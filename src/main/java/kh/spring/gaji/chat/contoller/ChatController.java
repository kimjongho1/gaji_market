package kh.spring.gaji.chat.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

//chat controller : 김종호 추가(230922)
@Slf4j
@Controller
public class ChatController {
	@GetMapping("/chat")
	public String chatGET() {

		log.info("@ChatController, chat GET()");
		
		// chat 패키지 아래 chatroom.jsp로 이동
		return "chat/chatroom";
	}
}
