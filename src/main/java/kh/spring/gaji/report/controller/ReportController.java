package kh.spring.gaji.report.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.gaji.report.model.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	ReportService reportServiceImpl;
	
	@PostMapping("/report")
	public String report(RedirectAttributes redirectAttr,int reportCategory,int refId,String content,String url,Principal principal) {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			String userId=principal.getName();
			map.put("reporterId",userId); //이후 session을 통해 얻어온 아이디 작성
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttr.addFlashAttribute("msg","로그인이 필요한 기능입니다."); 
			return "redirect:/"+url; 
		}
		map.put("reportCategory",reportCategory);
		map.put("refId", refId);
		map.put("content", content);
		if(reportServiceImpl.reportGoods(map)==1) {
			redirectAttr.addFlashAttribute("msg","신고가 완료되었습니다"); 
		}
		else {
			redirectAttr.addFlashAttribute("msg","이미 신고된 상품글입니다.");
		}
		return "redirect:/"+url; 
	}
	
	@PostMapping("/reportGoods")
	public String reportGoods(RedirectAttributes reatt,int reportCategory,int refId,String content,Principal principal) {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			String userId=principal.getName();
			map.put("reporterId",userId); //이후 session을 통해 얻어온 아이디 작성
		}catch(Exception e) {
			e.printStackTrace();
			reatt.addFlashAttribute("msg","로그인이 필요한 기능입니다."); 
			return "redirect:/goods/get?goodsId="+refId;
		}
		map.put("reportCategory",reportCategory);
		map.put("refId", refId);
		map.put("content", content);
		if(reportServiceImpl.reportGoods(map)==1) {
			reatt.addFlashAttribute("msg","신고가 완료되었습니다"); 
		}
		else {
			reatt.addFlashAttribute("msg","이미 신고된 상품글입니다.");
		}
		return "redirect:/goods/get?goodsId="+refId;
	}
}
