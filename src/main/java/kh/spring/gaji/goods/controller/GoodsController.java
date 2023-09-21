package kh.spring.gaji.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@GetMapping("/board")
	public String board() {		// 중고거래 게시판
		return "goods/goodsboard";
	}
	@GetMapping("/write")
	public String write() {		// 중고거래 게시판 글 작성
		return "goods/goodswrite";
	}
	@GetMapping("/update")
	public String update() {	// 중고거래 게시판 글 수정
		return "goods/goodsupdate";
	}
	@GetMapping("/get")
	public String get() {		// 중고거래 게시판 글 상세보기
		return "goods/goodsget";
	}
	
	@GetMapping("/get/map")
	public String map() {		// 중고거래 게시판에서 위치 설정 기능 -- 모달을 사용할 예정이라 페이지를 만들지 글 작성 페이지에 넣을지 고민 -천
		return "goods/goodsmap";
	}
}
