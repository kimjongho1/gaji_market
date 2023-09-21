package kh.spring.gaji.user.controller;

public class LoginController {

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
