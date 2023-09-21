package kh.spring.gaji.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	@GetMapping("/idInquiry")
	public String idInquiry() {
		return "user/idInquiry";
	}
	@GetMapping("/pwInquiry")
	public String pwInquiry() {
		return "user/pwInquiry";
	}
}
