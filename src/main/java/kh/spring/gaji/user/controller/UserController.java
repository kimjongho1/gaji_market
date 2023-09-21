package kh.spring.gaji.user.controller;


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
