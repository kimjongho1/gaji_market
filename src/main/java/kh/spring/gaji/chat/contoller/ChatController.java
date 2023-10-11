package kh.spring.gaji.chat.contoller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.gaji.chat.model.dto.ChatRoomDto;
import kh.spring.gaji.chat.model.service.ChatService;
import kh.spring.gaji.user.model.dto.UserDto;
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
			Principal principal) {
		// userId 값으로 조회하기 때문에 변수 선언
		String userId = principal.getName();
		// 채팅방 리스트 출력
		List<ChatRoomDto> result = chatServiceImpl.getChatRoom(userId);
		mv.addObject("chatRoomList",result);
		mv.setViewName("chat/chatroom");
		log.info("getChatRoom 실행");
		return mv;
	}
}
