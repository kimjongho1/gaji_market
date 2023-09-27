package kh.spring.gaji.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.user.model.dto.UserSafeTradingDto;
import kh.spring.gaji.user.model.service.UserService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String mypage() {	// 마이페이지
		return "mypage/mypage";
	}
	
	@GetMapping("/orderstatus")
	public String orderStatus(Model model) {	// 나의 구매내역 안전거래.
		List<UserSafeTradingDto> safePurchaseList= userService.getSafePurchaseList("qordmlgjs");	//추후 userId들어가야함
		model.addAttribute("safePurchaseList",safePurchaseList);
		return "mypage/orderstatus";
	}
	
	@GetMapping("/salesstatus")
	public String salesStatus(Model model) {	// 나의 판매내역
		List<MyGoodsListDto> myGoodsList = userService.getOnSaleList("cjsdudwns"); //추후 userId들어가야함
		model.addAttribute("myGoodsList",myGoodsList);
		return "mypage/salesstatus";
	}
	
	@PostMapping("/getInFaceView")	// 직거래 구매내역을 가져오는 ajax url
	@ResponseBody
	public List<InFaceTradingDto> getInfaceView(){
		System.out.println("MyPageController 직거래내역 url");
		return userService.getInfacePurchaseList("qordmlgjs"); //이후 userId로 대체.
	}
	
	@PostMapping("/getonsale")	// 판매내역(판매중) ajax 응답url
	@ResponseBody
	public List<MyGoodsListDto> getOnSale(Model model){
		return userService.getOnSaleList("cjsdudwns");
	}
	
	@PostMapping("/getclosed")
	@ResponseBody
	public List<MyGoodsListDto> getClosed(Model model){
		return userService.getSoldOutList("cjsdudwns");
	}
	
	@PostMapping("/gethide")
	@ResponseBody
	public List<MyGoodsListDto> getHide(Model model){
		return userService.getHideList("cjsdudwns");
	}
	
	@PostMapping("/getSafeTradingView")	// 안전거래 구매내역을 가져오는 ajax url
	@ResponseBody
	public List<UserSafeTradingDto> getSafeTradingView(){
		System.out.println("MyPageController 안전거래내역 url");
		return userService.getSafePurchaseList("qordmlgjs"); //이후 userId로 대체.
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
	public String seller(Model model,String transactionId) {		// 안전 거래 상세조회 판매자 페이지
		SafePurchaseInfoDto safePurchaseInfoDto = userService.getSafePurchaseInfo(transactionId);
		model.addAttribute("safePurchaseInfoDto",safePurchaseInfoDto);
		return "mypage/seller";
	}
	
	@PostMapping("/deal/safe/seller/insert/trackingnumber")
	public String insertTrackingNumber(Model model,int shippingCompany,String trackingNumber,String transactionId,RedirectAttributes redirectattr) {
		Map<String,Object> map= new HashMap<String,Object>();
		String msg=null;
		map.put("shippingCompany",shippingCompany);
		map.put("trackingNumber", trackingNumber);
		map.put("transactionId", transactionId);
		if(userService.updateTrackingNumber(map)==1)
			redirectattr.addFlashAttribute("msg","운송장이 등록되었습니다");
		else
			redirectattr.addFlashAttribute("msg","운송장 등록에 실패했습니다");
		return "redirect:/mypage/deal/safe/seller?transactionId="+transactionId;
	}
	
	@GetMapping("/deal/safe/buyer")
	public String buyer(Model model,String transactionId) {			// 안전 거래 상세조회 구매자 페이지
		SafePurchaseInfoDto safePurchaseInfoDto = userService.getSafePurchaseInfo(transactionId);	//추후 transactionId를 받아와서 처리하게될것.
		model.addAttribute("safePurchaseInfoDto",safePurchaseInfoDto);
		return "mypage/buyer";
	}
}
