package kh.spring.gaji;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.gaji.goods.model.Service.GoodsService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {	
	@Autowired
	GoodsService GoodsServiceImpl;
	@GetMapping("/")
	public String main(Model model,Principal principal) { //메인 페이지
		String userId=null;
		try {
			userId=principal.getName();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		model.addAttribute("userId",userId);
		model.addAttribute("cateGoods1",GoodsServiceImpl.getMainGoods(1));
		model.addAttribute("cateGoods2",GoodsServiceImpl.getMainGoods(2));
		model.addAttribute("cateGoods3",GoodsServiceImpl.getMainGoods(3));
		model.addAttribute("cateGoods4",GoodsServiceImpl.getMainGoods(4));
		model.addAttribute("cateGoods5",GoodsServiceImpl.getMainGoods(5));
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
