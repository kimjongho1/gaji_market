package kh.spring.gaji.user.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv) {		//  로그인페이지 -- 관리자 로그인 페이지도 따로 만들 예정 추후 논의
		mv.setViewName("user/login");
		return mv;
	}
	
	@PostMapping("/logout")		//  로그아웃 -> 메인페이지로 이동
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("redirect:/main");
		request.getSession().invalidate();
		return mv;
	}
	
	@GetMapping("/login/error")
	public ModelAndView viewLoginError(ModelAndView mv) {
		mv.setViewName("user/login/error");
		return mv;
	}
}
