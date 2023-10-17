package kh.spring.gaji.main.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	
	@GetMapping("")
	public String main(Model model) {		// 메인페이지
		return "main/main";
	}
}
