package kh.spring.gaji.paycontroller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("payment/paytest")
	public String paytest() {
		return "payment/paytest";
	}
	@GetMapping("payment/paytest1")
	public String paytest1() {
		return "payment/paytest1";
	}
	@PostMapping("payment/callback")
	@ResponseBody
	public String callback() {
		return "1";
	}
}
