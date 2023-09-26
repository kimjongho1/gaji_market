package kh.spring.gaji.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service; 
	
	@GetMapping("/signup")
	public String signup() {	// 개인회원가입
		
		
		
		return "user/signup";
	}
	@PostMapping("signup")
	public String singupUser(UserDto dto , RedirectAttributes ra) {
		
		if(service.signup(dto) == 0) {
			ra.addFlashAttribute("msg","계정 생성이 실패하였습니다. 다시 시도해주십시오.");
			return "user/singup";
		} else {
			ra.addFlashAttribute("msg", "계정 생성이 성공하였습니다.");
	        return "redirect:/main"; // 성공 시 메인 페이지로 리다이렉트
		}
		
		
		
		
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
