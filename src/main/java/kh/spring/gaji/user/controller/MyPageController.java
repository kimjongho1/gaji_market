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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.mypage.model.service.MypageService;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
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
	
	@Autowired
	private MypageService myPageService;
	
	@GetMapping("")
	public ModelAndView mypage(@RequestParam(name = "userId", required = false, defaultValue = "asdf") String userId, ModelAndView mv) {	// 마이페이지
		mv.setViewName("mypage/mypage");
		mv.addObject("userMypage",myPageService.userMypage(userId));
		return mv;
	}
	
	@PostMapping("/updatename")
	@ResponseBody
	public Map<String, Object> updateName(@RequestParam Map<String, String> map) {
	    Map<String, Object> response = new HashMap<>();
	        int updateResult = myPageService.updateName(map);
	        if (updateResult == 1) {
	            response.put("status", "1"); // 성공
	            response.put("message", "이름이 변경되었습니다.");
	        } else {
	            response.put("status", "0"); // 업데이트 오류
	            response.put("message", "이름 업데이트 중 오류가 발생했습니다.");
	        }
	    return response;
	}
	
	@PostMapping("/updatenickname")
	@ResponseBody
	public Map<String, Object> updateNickname(@RequestParam Map<String, String> map,String nickname) {
		 Map<String, Object> response = new HashMap<>();
		    String result = myPageService.checkNickname(nickname);
		    
		    if (result != null) {
		        response.put("status", -1); // 중복 닉네임 오류
		        response.put("message", "중복된 닉네임입니다.");
		    } else {
		        int updateResult = myPageService.updateNickname(map);
		        if (updateResult == 1) {
		            response.put("status", 1); // 성공
		            response.put("message", "닉네임이 변경되었습니다.");
		        } else {
		            response.put("status", 0); // 업데이트 오류
		            response.put("message", "닉네임 변경 중 오류가 발생했습니다.");
		        }
		    }
		    return response;
		}
	
	@PostMapping("/updateemail")
	@ResponseBody
	public Map<String, Object> updateEmail(@RequestParam Map<String, String> map, String email) {
		 Map<String, Object> response = new HashMap<>();
		    String result = myPageService.checkEmail(email);
		    
		    if (result != null) {
		        response.put("status", -1); // 중복 이메일 오류
		        response.put("message", "중복된 이메일입니다.");
		    } else {
		        int updateResult = myPageService.updateEmail(map);
		        if (updateResult == 1) {
		            response.put("status", 1); // 성공
		            response.put("message", "이메일이 업데이트되었습니다.");
		        } else {
		            response.put("status", 0); // 업데이트 오류
		            response.put("message", "이메일 변경 중 오류가 발생했습니다.");
		        }
		    }
		    return response;
		}
	
	@PostMapping("/updatemobilenumber")
	@ResponseBody
	public Map<String, Object> updateMobileNumber(@RequestParam Map<String, String> map,String mobileNumber) {
		 Map<String, Object> response = new HashMap<>();
		    String result = myPageService.checkMobilNumber(mobileNumber);
		    
		    if (result != null) {
		        response.put("status", -1); // 중복 핸드폰번호 오류
		        response.put("message", "중복된 핸드폰 번호입니다.");
		    } else {
		        int updateResult = myPageService.updateMobileNumber(map);
		        if (updateResult == 1) {
		            response.put("status", 1); // 성공
		            response.put("message", "이름이 업데이트되었습니다.");
		        } else {
		            response.put("status", 0); // 업데이트 오류
		            response.put("message", "이름 업데이트 중 오류가 발생했습니다.");
		        }
		    }
		    return response;
		}
	
	
	

	
	@GetMapping("/dealreview")
	public String dealreview(Model model,String transactionId,RedirectAttributes rattr,HttpSession session) {	//리뷰작성
//		String userId=(String)session.getAttribute("userId");
		if(userService.checkTradingStatus(transactionId,"qordmlgjs")==0) {	//거래번호에 해당하는 안전거래가 거래완료이면서,  해당상품번호의 해당유저 리뷰가 아직 존재하지 않으면
			model.addAttribute("transactionId", transactionId);	//	거래번호를 가지고
			return "mypage/dealreview";							// 리뷰작성 페이지로 이동
		}
			rattr.addFlashAttribute("msg", "잘못된 접근입니다.");
		return "redirect:/main/main";
	}
	
	@PostMapping("/dealreview.do")
	public String doDealreview(Model model,DealReviewDto dealReviewDto,String transactionId,RedirectAttributes rattr,HttpSession session) {

		if(1<=dealReviewDto.getMannerPoint() && dealReviewDto.getMannerPoint()<=5&&		//들어온 평점이 정상 범주에 있는지를 체크함.
		   1<=dealReviewDto.getTimePoint() && dealReviewDto.getTimePoint()<=5&&
		   1<=dealReviewDto.getGoodsPoint() && dealReviewDto.getGoodsPoint()<=5
		) {
//			String userId=(String)session.getAttribute("userId");
			dealReviewDto.setUserId("qordmlgjs");//추후 userId
			if(userService.doDealreview(dealReviewDto,transactionId)==1) {
				rattr.addFlashAttribute("msg","리뷰가 정상적으로 등록되었습니다.");
				return "redirect:/mypage";
			}
			rattr.addFlashAttribute("msg","잘못된 접근입니다1.");
			return "redirect:/mypage";
		}
		rattr.addFlashAttribute("msg","잘못된 접근입니다2.");
		return "redirect:/mypage";
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
