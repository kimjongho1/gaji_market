package kh.spring.gaji.notification.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.notification.model.Service.NotificationService;

@Controller
@RequestMapping("/notice")
public class NotificationController {
	@Autowired
	NotificationService notificationServiceImpl;
	
	@GetMapping("")
	public String notice(Principal principal,Model model,RedirectAttributes reatt) {
		String userId=null;
		if(principal!=null) {
		userId= principal.getName();
		int type=2;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId",userId);
		map.put("type",type);
		model.addAttribute("notiCount",notificationServiceImpl.countNotification(map));
		model.addAttribute("safeTradingNotice",notificationServiceImpl.getNotiList(map));
		return "notification/notice";
		}
		else {
			reatt.addFlashAttribute("msg","로그인이 필요한 페이지입니다.");
			return "redirect:/";
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
			return "redirect:/";
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
}
