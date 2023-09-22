package kh.spring.gaji.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/signup")
	public String signup() {	// 개인회원가입
		return "user/signup";
	}
	
	
	@GetMapping("/idInquiry")
	public String idInquiry() {		// 아이디찾기
		return "user/idInquiry";
	}
	
	
	@GetMapping("/pwInquiry")
	public String pwInquiry() {		// 비밀번호찾기
		return "user/pwInquiry";
	}
}
