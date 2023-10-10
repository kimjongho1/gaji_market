package kh.spring.gaji.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;
import kh.spring.gaji.user.model.dto.UserSafeTradingDto;
import kh.spring.gaji.user.model.service.UserService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	static final int PAGESIZE=8;
	static final int PAGEBLOCKSIZE=5;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String mypage() {	// 마이페이지
		return "mypage/mypage";
	}
	
	@GetMapping("/dealreview")
	public String dealreview(Model model,String transactionId,RedirectAttributes rattr,HttpSession session) {	//리뷰작성
//		String userId=(String)session.getAttribute("userId");
		if(userService.checkTradingStatus(transactionId,"qordmlgjs")==0) {	//거래에 해당하는 상품의 해당유저 리뷰가 아직 존재하지 않으면
			model.addAttribute("transactionId", transactionId);
			return "mypage/dealreview";
		}
			rattr.addAttribute("msg", "잘못된 접근입니다.");
		return "redirect:/main/main";
	}
	
	@PostMapping("/address/regist/do")
	@ResponseBody
	public List<UserAddressDto> addressRegist(UserInsertAddressDto address){
		address.setUserId("qordmlgjs");
		userService.insertAddress(address);
		return userService.getAddress("qordmlgjs");
	}
	@Transactional
	@PostMapping("/address/delete")
	@ResponseBody
	public int addressdelete(int addressNo,HttpSession session){
//		String userId=session.getAttribute("qordmlgjs");
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userId","qordmlgjs");	//이후 userId대체
		map.put("addressNo", addressNo);
		return userService.deleteAddress1(map);
	}
	
	@PostMapping("/address/alterPrimaryAddress")
	@ResponseBody
	public int alterPrimaryAddress(int addressNo,HttpSession session){
//		String userId=session.getAttribute("qordmlgjs");
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userId","qordmlgjs");	//이후 userId대체
		map.put("addressNo", addressNo);
		return userService.updateMainAddress(map);
	}
	
	@GetMapping("/orderstatus/safe")
	public String safeorderList(Model model,Integer currentPage,String searchWord) {	// 나의 안전거래 구매내역 페이지.
		//String userId=(String)session.getAttribute("userId"); 
		int totalCnt=0;
		List<UserSafeTradingDto> safePurchaseList=null;
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSafePurchaseList("qordmlgjs",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			safePurchaseList = (List<UserSafeTradingDto>)map.get("safePurchaseList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchSafePurchaseList("qordmlgjs",(int)currentPage,PAGESIZE,searchWord);
			safePurchaseList = (List<UserSafeTradingDto>)map.get("safePurchaseList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		
		//구해온 목록으로 페이징번호들 구하고 JSP로 전송하기
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("safePurchaseList",safePurchaseList);
		return "mypage/safeorderstatus";
	}
	
	@GetMapping("/orderstatus/inface")
	public String infaceOrderList(Model model,Integer currentPage,String searchWord,HttpSession session) {	// 나의 직거래 구매내역 페이지.
		//String userId=(String)session.getAttribute("userId"); 
		int totalCnt=0;
		List<InFaceTradingDto> infacePurchaseList=null;
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getInfacePurchaseList("qordmlgjs",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			infacePurchaseList = (List<InFaceTradingDto>)map.get("inFacePurchaseList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchInfacePurchaseList("qordmlgjs",(int)currentPage,PAGESIZE,searchWord);
			infacePurchaseList = (List<InFaceTradingDto>)map.get("inFacePurchaseList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("infacePurchaseList",infacePurchaseList);
		return "mypage/infaceorderstatus";
	}
	
	@GetMapping("/salestatus/inface")
	public String infaceSellerOrderList(Model model,Integer currentPage,String searchWord,HttpSession session) {	// 나의 직거래 구매내역 페이지.
		//String userId=(String)session.getAttribute("userId"); 
		int totalCnt=0;
		List<InFaceTradingDto> infacePurchaseList=null;
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSellerInfacePurchaseList("cjsdudwns",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			infacePurchaseList = (List<InFaceTradingDto>)map.get("inFacePurchaseList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchSellerInfacePurchaseList("cjsdudwns",(int)currentPage,PAGESIZE,searchWord);
			infacePurchaseList = (List<InFaceTradingDto>)map.get("inFacePurchaseList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("infacePurchaseList",infacePurchaseList);
		return "mypage/infacesalestatus";
	}
	
	@GetMapping("/salestatus/safe")
	public String safeSaleList(Model model,Integer currentPage,String searchWord) {	// 나의 안전거래 판매내역 페이지.
		//String userId=(String)session.getAttribute("userId"); 
		int totalCnt=0;
		List<UserSafeTradingDto> safePurchaseList=null;
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSellerSafePurchaseList("cjsdudwns",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			safePurchaseList = (List<UserSafeTradingDto>)map.get("safePurchaseList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchSellerSafePurchaseList("cjsdudwns",(int)currentPage,PAGESIZE,searchWord);
			safePurchaseList = (List<UserSafeTradingDto>)map.get("safePurchaseList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		
		//구해온 목록으로 페이징번호들 구하고 JSP로 전송하기
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("safePurchaseList",safePurchaseList);
		return "mypage/safesalestatus";
	}
	
	@GetMapping("/goods/onsale")	// 판매중 상품
	public String onsaleGoods(Model model,Integer currentPage,String searchWord,HttpSession session) {	
		int totalCnt=0;
		List<MyGoodsListDto> myGoodsList=null;
		//String userId=(String)session.getAttribute("userId"); 
		model.addAttribute("myGoodsList",myGoodsList);
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getOnSaleList("cjsdudwns",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchOnSaleList("cjsdudwns",(int)currentPage,PAGESIZE,searchWord);//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("myGoodsList",myGoodsList);
		return "mypage/onsalegoods";
	}
	
	@GetMapping("/goods/closed")	// 판매완료 상품
	public String closedGoods(Model model,Integer currentPage,String searchWord,HttpSession session) {	
		int totalCnt=0;
		List<MyGoodsListDto> myGoodsList=null;
		//String userId=(String)session.getAttribute("userId"); 
		model.addAttribute("myGoodsList",myGoodsList);
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getClosedList("cjsdudwns",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchClosedList("cjsdudwns",(int)currentPage,PAGESIZE,searchWord);//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("myGoodsList",myGoodsList);
		return "mypage/closedgoods";
	}
	
	@GetMapping("/goods/hide")	// 숨김중 상품
	public String hideGoods(Model model,Integer currentPage,String searchWord,HttpSession session) {	
		int totalCnt=0;
		List<MyGoodsListDto> myGoodsList=null;
		//String userId=(String)session.getAttribute("userId"); 
		model.addAttribute("myGoodsList",myGoodsList);
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		if(searchWord==null) {	// 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String,Object> map= userService.getHideList("cjsdudwns",(int)currentPage,PAGESIZE);	//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
		}
		else {					//검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String,Object> map= userService.getSearchHideList("cjsdudwns",(int)currentPage,PAGESIZE,searchWord);//추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>)map.get("myGoodsList");
			totalCnt= (int)map.get("totalCnt");
			model.addAttribute("searchWord",searchWord);
		}
		int totalPageNum = totalCnt/PAGESIZE + (totalCnt%PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage/PAGEBLOCKSIZE)-1)*PAGEBLOCKSIZE +1;
		} else {
			startPageNum = ((currentPage/PAGEBLOCKSIZE))*PAGEBLOCKSIZE +1;
		}
		int endPageNum = (startPageNum+PAGEBLOCKSIZE > totalPageNum) ? totalPageNum : startPageNum+PAGEBLOCKSIZE-1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("myGoodsList",myGoodsList);
		return "mypage/closedgoods";
	}
	

	@GetMapping("/myinfo")
	public String myInfo() {	// 회원정보
			return "mypage/myinfo";
		}
	
	@GetMapping("/keepuseds")
	public String keepuseds(Model model, Integer currentPage, String searchWord, HttpSession session) {
		int totalCnt = 0;
		List<MyGoodsListDto> myGoodsList = null;
		// String userId=(String)session.getAttribute("userId");
		model.addAttribute("myGoodsList", myGoodsList);
		if (currentPage == null) // 현재 페이지가 들어온게 없다면 1페이지.
			currentPage = 1;
		if (searchWord == null) { // 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String, Object> map = userService.getKeepUsedList("qordmlgjs", (int) currentPage, PAGESIZE); // 추후																								// userId들어가야함
			myGoodsList = (List<MyGoodsListDto>) map.get("myGoodsList");
			totalCnt = (int) map.get("totalCnt");
		} else { // 검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String, Object> map = userService.getSearchKeepUsedList("qordmlgjs", (int) currentPage, PAGESIZE,
					searchWord);// 추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>) map.get("myGoodsList");
			totalCnt = (int) map.get("totalCnt");
			model.addAttribute("searchWord", searchWord);
		}
		int totalPageNum = totalCnt / PAGESIZE + (totalCnt % PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if ((currentPage % PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage / PAGEBLOCKSIZE) - 1) * PAGEBLOCKSIZE + 1;
		} else {
			startPageNum = ((currentPage / PAGEBLOCKSIZE)) * PAGEBLOCKSIZE + 1;
		}
		int endPageNum = (startPageNum + PAGEBLOCKSIZE > totalPageNum) ? totalPageNum
				: startPageNum + PAGEBLOCKSIZE - 1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("myGoodsList", myGoodsList);
		return "mypage/keepuseds";
	}
	
	@GetMapping("/keepusers")
// 모아보기 - 즐겨찾기한 유저들의 상품들을 모아서 볼 수 있음 
	public String keepusers(Model model, Integer currentPage, String searchWord, HttpSession session) {
		int totalCnt = 0;
		List<MyGoodsListDto> myGoodsList = null;
		// String userId=(String)session.getAttribute("userId");
		model.addAttribute("myGoodsList", myGoodsList);
		if (currentPage == null) // 현재 페이지가 들어온게 없다면 1페이지.
			currentPage = 1;
		if (searchWord == null) { // 검색어가 들어온게 없다면 검색어없는 mapper로 목록 가져오기
			Map<String, Object> map = userService.getKeepUsersList("qordmlgjs", (int) currentPage, PAGESIZE); // 추후 userId들어가야함																								
			myGoodsList = (List<MyGoodsListDto>) map.get("myGoodsList");
			totalCnt = (int) map.get("totalCnt");
		} else { // 검색어가 있다면 그에따른 mapper로 목록 가져오기
			Map<String, Object> map = userService.getSearchKeepUsersList("qordmlgjs", (int) currentPage, PAGESIZE,
					searchWord);// 추후 userId들어가야함
			myGoodsList = (List<MyGoodsListDto>) map.get("myGoodsList");
			totalCnt = (int) map.get("totalCnt");
			model.addAttribute("searchWord", searchWord);
		}
		int totalPageNum = totalCnt / PAGESIZE + (totalCnt % PAGESIZE == 0 ? 0 : 1);
		int startPageNum = 1;
		if ((currentPage % PAGEBLOCKSIZE) == 0) {
			startPageNum = ((currentPage / PAGEBLOCKSIZE) - 1) * PAGEBLOCKSIZE + 1;
		} else {
			startPageNum = ((currentPage / PAGEBLOCKSIZE)) * PAGEBLOCKSIZE + 1;
		}
		int endPageNum = (startPageNum + PAGEBLOCKSIZE > totalPageNum) ? totalPageNum
				: startPageNum + PAGEBLOCKSIZE - 1;
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("myGoodsList", myGoodsList);
		return "mypage/keepusers";
	}
	
	@GetMapping("/deal/safe/seller")
	public String seller(Model model,String transactionId,RedirectAttributes redirectattr) { // 안전 거래 상세조회 판매자 페이지
		if(!userService.checkIdForSafeSeller(transactionId).equals("cjsdudwns")) //session.getAttribute("userId")로 변경해야함.
		{
			redirectattr.addFlashAttribute("msg","잘못된 접근입니다.");
			return "redirect:/main/main";
		}
		SafePurchaseInfoDto safePurchaseInfoDto = userService.getSafePurchaseInfo(transactionId);
		model.addAttribute("safePurchaseInfoDto",safePurchaseInfoDto);
		return "mypage/seller";
	}
	
	@PostMapping("/deal/safe/seller/insert/trackingnumber")
	public String insertTrackingNumber(Model model,int shippingCompany,String trackingNumber,String transactionId,RedirectAttributes redirectattr) {
		if(!userService.checkIdForSafeSeller(transactionId).equals("cjsdudwns")) //session.getAttribute("userId")로 변경해야함.
		{
			redirectattr.addFlashAttribute("msg","잘못된 접근입니다.");
			return "redirect:/main/main";
		}
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
	public String buyer(Model model,String transactionId,RedirectAttributes redirectattr,HttpSession session) {			// 안전 거래 상세조회 구매자 페이지
		if(!userService.checkIdForSafe(transactionId).equals("qordmlgjs")) //session.getAttribute("userId")로 변경해야함.
		{
			redirectattr.addFlashAttribute("msg","잘못된 접근입니다.");
			return "redirect:/main/main";
		}
		
		SafePurchaseInfoDto safePurchaseInfoDto = userService.getSafePurchaseInfo(transactionId);
		model.addAttribute("safePurchaseInfoDto",safePurchaseInfoDto);
		return "mypage/buyer";
	}
}
