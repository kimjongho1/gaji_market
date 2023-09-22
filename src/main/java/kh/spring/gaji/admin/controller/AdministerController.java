package kh.spring.gaji.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdministerController {
	
	@GetMapping("/")
	public String admin() {		// 관리자페이지
		return "/admin/admin";
	}
	
	@GetMapping("/deal/safe/list")
	public String safeList() {		// 안전 거래 리스트 조회
		return "/admin/safelist";
	}
	
	@GetMapping("/deal/safe/get")
	public String safeGet() {		// 안전 거래 리스트 상세 조회
		return "/admin/safeget";
	}
	
	@GetMapping("/deal/direct/list")
	public String directList() { 	// 직접 거래 리스트 조회
		return "/admin/directlist";
	}
	
	@GetMapping("/deal/direct/get")
	public String directGet() {		// 직접 거래 리스트 상세 조회
		return "/admin/directget";
	}
	
	@GetMapping("/manage/users/list")
	public String userList() {		// 회원정보 조회
		return "/admin/userlist";
	}
	
	@GetMapping("/manage/users/get")
	public String userGet() {		// 회원정보 상세 조회
		return "/admin/userget";
	}
	
	@GetMapping("/report/useds/list")
	public String reportUsedsList() {		// 신고된 중고 거래 글 리스트
		return "/admin/reportusedslist";
	}
	
	@GetMapping("/report/useds/get")
	public String reportUsedsGet() {		// 중고 거래 글 신고내역 상세보기
		return "/admin/reportusedsget";
	}
	
	@GetMapping("/report/users/list")
	public String reportUsersList() {		// 신고된 유저 리스트
		return "/admin/reportuserslist";
	}
	
	@GetMapping("/report/users/get")
	public String reportUsersGet() {		// 유저 신고내역 상세보기
		return "/adming/reportusersget";
	}
	
	
	
	
	
}
