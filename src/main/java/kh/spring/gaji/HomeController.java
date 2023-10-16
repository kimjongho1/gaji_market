package kh.spring.gaji;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String main() { //메인 페이지
		return "/home";
	}
	@GetMapping("/test")
	public String test() { //메인 페이지
		return "/mypage/side";
	}
	
	@GetMapping("/testg")
	public String testg() { //메인 페이지
		return "/test";
	}
	
}
