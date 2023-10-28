package kh.spring.gaji.notification.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.notification.model.Service.NotificationService;
import kh.spring.gaji.notification.model.dto.DeleteNotiDto;

@Controller
@RequestMapping("/notice")
public class NotificationController {
	@Autowired
	NotificationService notificationServiceImpl;
	
	int pageBlockSize=5;
	
	@GetMapping("")
	public String notice(Principal principal,Integer currentPage,Model model,RedirectAttributes reatt) {
		int totalCnt=0;
		int pageSize1=6;
		List<MyGoodsListDto> myGoodsList=null;
		model.addAttribute("myGoodsList",myGoodsList);
		if(currentPage==null)	//현재 페이지가 들어온게 없다면 1페이지.
			currentPage=1;
		
		String userId=null;
		if(principal!=null) {
		userId= principal.getName();
		int type=2;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId",userId);
		map.put("type",type);
		map.put("currentPage", currentPage);
		map.put("PAGESIZE", pageSize1); 
		totalCnt=notificationServiceImpl.getTotalCnt(userId);
		map.put("totalCnt", totalCnt);
		model.addAttribute("notiCount",notificationServiceImpl.countNotification(map));	//읽지 않은 알림갯수
		model.addAttribute("safeTradingNotice",notificationServiceImpl.getNotiList(map));
		
		
		int totalPageNum = totalCnt/pageSize1 + (totalCnt%pageSize1 == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		
		return "notification/notice";
		}
		else {
			reatt.addFlashAttribute("msg","로그인이 필요한 페이지입니다.");
			return "redirect:/login";
		}
	}
	
	@PostMapping("/read")
	public String read(Principal principal,String readYn,String refId,Integer notiId,RedirectAttributes reatt) {
		Map<String,Object> map=new HashMap<String,Object>();
		String userId=null;
		if(principal!=null) {
		userId= principal.getName();
		if(readYn.equals("N")) {
			map.put("notiId", notiId);
			map.put("userId", userId);
			notificationServiceImpl.updateNotiYN(map);
		}
		if(notificationServiceImpl.getIdFromTransactionId(refId).equals(userId))
			return "redirect:/mypage/deal/safe/buyer?transactionId="+refId;
		else
			return "redirect:/mypage/deal/safe/seller?transactionId="+refId;
		}
		else {
			reatt.addFlashAttribute("msg","로그인이 필요한 페이지입니다.");
			return "redirect:/login";
		}
	}
	
	@PostMapping("/getNotiCount")
	@ResponseBody
	public int getNotiCount(Principal principal) {
		Map<String,Object> map=new HashMap<String,Object>();
		String userId=null;
		if(principal!=null) {
		map.put("type", 2);
		userId=principal.getName();
		map.put("userId",userId);
		return notificationServiceImpl.countNotification(map);
		}
		return 0;
		}
	
	@PostMapping("/deletenotice")
	@ResponseBody
	public int getNotiCount(Principal principal,DeleteNotiDto deleteNotiDto) {
		int result=0;
		if(principal==null)
			return -1;	
		deleteNotiDto.setUserId(principal.getName());
		result=notificationServiceImpl.deleteNotice(deleteNotiDto);
		return result;
	}
}
