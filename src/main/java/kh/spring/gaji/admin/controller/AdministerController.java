package kh.spring.gaji.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.gaji.admin.model.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdministerController {
	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public ModelAndView admin(ModelAndView mv) { // 관리자페이지
		mv.addObject("userList", adminService.userList());
		mv.setViewName("admin/admin");
		return mv;
	}

	@GetMapping("/reportlist")
	public ModelAndView reportList(ModelAndView mv, String userId) {
		mv.addObject("userReportList", adminService.userReportList(userId));
		mv.setViewName("admin/reportuserslist");
		return mv;
	}

	@GetMapping("/report/get")
	public ModelAndView reportGet(ModelAndView mv, int refId) {
		mv.addObject("userReportInfo", adminService.userReportInfo(refId));
		mv.setViewName("admin/reportusersget");
		return mv;
	}

	@PostMapping("/report/review")
	@ResponseBody
	public String reportReview(int refId) {
		int result = adminService.reportReview(refId);
		String check = adminService.checkReview(refId);
		if (check.equals("N")) {
			if (result == 1) {
				return "success";
			} else {
				return "error";
			}
		} else {
			return "rvComplete";
		}
	}

	@PostMapping("/report/ban")
	@ResponseBody
	public String banUser(String userId) {
		int result = adminService.banUser(userId);
		int check = adminService.checkBan(userId);
		if (check == 1) {
			if (result == 1) {
				return "banSuccess";
			} else {
				return "banError";
			}
		} else {
			return "banExist";
		}
	}

	@PostMapping("/report/unban")
	@ResponseBody
	public String unBanUser(String userId) {
		int result = adminService.unBanUser(userId);
		int check = adminService.checkBan(userId);
		if (check == 0) {
			if (result == 1) {
				return "unBanSuccess";
			} else {
				return "unBanError";
			}
		} else {
			return "unBanExist";
		}
	}

//	@GetMapping("/deal/safe/list")
//	public String safeList() {		// 안전 거래 리스트 조회
//		return "/admin/safelist";
//	}
//	
//	@GetMapping("/deal/safe/get")
//	public String safeGet() {		// 안전 거래 리스트 상세 조회
//		return "/admin/safeget";
//	}
//	
//	@GetMapping("/deal/direct/list")
//	public String directList() { 	// 직접 거래 리스트 조회
//		return "/admin/directlist";
//	}
//	
//	@GetMapping("/deal/direct/get")
//	public String directGet() {		// 직접 거래 리스트 상세 조회
//		return "/admin/directget";
//	}
//	
//	@GetMapping("/manage/users/list")
//	public String userList() {		// 회원정보 조회
//		return "/admin/userlist";
//	}
//	
//	@GetMapping("/manage/users/get")
//	public String userGet() {		// 회원정보 상세 조회
//		return "/admin/userget";
//	}
//	
//	@GetMapping("/report/useds/list")
//	public String reportUsedsList() {		// 신고된 중고 거래 글 리스트
//		return "/admin/reportusedslist";
//	}
//	
//	@GetMapping("/report/useds/get")
//	public String reportUsedsGet() {		// 중고 거래 글 신고내역 상세보기
//		return "/admin/reportusedsget";
//	}
//	
//	@GetMapping("/report/users/list")
//	public String reportUsersList() {		// 신고된 유저 리스트
//		return "/admin/reportuserslist";
//	}
//	
//	@GetMapping("/report/users/get")
//	public String reportUsersGet() {		// 유저 신고내역 상세보기
//		return "/admin/reportusersget";
//	}

}
