package kh.spring.gaji.user.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {		//  로그인페이지 -- 관리자 로그인 페이지도 따로 만들 예정 추후 논의
		return "user/login";
	}
	
	@PostMapping("/logout")		//  로그아웃 -> 메인페이지로 이동
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/main";
	}
}
