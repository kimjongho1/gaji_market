package kh.spring.gaji.user.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv, Principal principal, RedirectAttributes ra) {		//  로그인페이지 -- 관리자 로그인 페이지도 따로 만들 예정 추후 논의
		if(principal != null) {
			ra.addFlashAttribute("msg","로그아웃 후 진행해주세요.");
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("user/login");
		return mv;
	}
	
	@PostMapping("/logout")		//  로그아웃 -> 메인페이지로 이동
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("redirect:/main");
		request.getSession().invalidate();
		return mv;
	}
}
