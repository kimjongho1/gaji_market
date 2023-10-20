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

import kh.spring.gaji.notification.model.Service.NotificationService;

@Controller
@RequestMapping("/notice")
public class NotificationController {
	@Autowired
	NotificationService notificationServiceImpl;
	
	@GetMapping("")
	public String notice(Principal principal,Model model) {
		String userId= principal.getName();
		int type=2;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId",userId);
		map.put("type",type);
		model.addAttribute("notiCount",notificationServiceImpl.countNotification(map));
		model.addAttribute("safeTradingNotice",notificationServiceImpl.getNotiList(map));
		return "notification/notice";
	}
	
	@PostMapping("/read")
	public String read(Principal principal,String readYn,String refId,Integer notiId) {
		Map<String,Object> map=new HashMap<String,Object>();
		String userId= principal.getName();
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
}
