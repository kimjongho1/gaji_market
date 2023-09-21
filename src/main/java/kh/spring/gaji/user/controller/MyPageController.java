package kh.spring.gaji.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@GetMapping("/")
	public String mypage() {	// 마이페이지
		return "mypage/mypage";
	}
	
	@GetMapping("/orderstatus")
	public String orderStatus() {	// 나의 구매내역
		return "mypage/orderstatus";
	}
	
	@GetMapping("/salesstatus")
	public String salesStatus() {	// 나의 판매내역
		return "mypage/salesstatus";
	}
	
	@GetMapping("/myinfo")
	public String myInfo() {	// 회원정보
			return "mypage/myinfo";
		}
	
	@GetMapping("/keepuseds")
	public String keepUseds() {		// 찜목록
		return "mypage/keepuseds";
	}
	
	@GetMapping("/keepusers")
	public String keepUsers() {		// 모아보기 - 즐겨찾기한 유저들의 상품들을 모아서 볼 수 있음 
		return "mypage/keepusers";
	}
	
	@GetMapping("/deal/safe/seller")
	public String seller() {		// 안전 거래 상세조회 판매자 페이지
		return "mypage/seller";
	}
	
	@GetMapping("/deal/safe/buyer")
	public String buyer() {			// 안전 거래 상세조회 구매자 페이지
		return "mypage/buyer";
	}
}
