package kh.spring.gaji.goods.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;
import kh.spring.gaji.category.model.service.CategoryService;
import kh.spring.gaji.file.controller.UploadController;
import kh.spring.gaji.file.model.dto.FileDto;
import kh.spring.gaji.file.model.service.FileService;
import kh.spring.gaji.goods.model.Service.GoodsService;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.region.model.service.RegionService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	Dotenv dotenv = Dotenv.load();
	Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
	
	@Autowired 
	private GoodsService goodsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/board")
	public String board() {		// 중고거래 게시판
		return "goods/goodsboard";
	}
	
	
	@GetMapping("/write")
	public ModelAndView write(ModelAndView mv) {		// 중고거래 게시판 글 작성
		mv.setViewName("goods/goodswrite");
		mv.addObject("categoryList",categoryService.categoryList());
		mv.addObject("dongList",regionService.dongList());
		mv.addObject("guList",regionService.guList());
		return mv;
	}
	
	@PostMapping("/wirte.do")
	public String wirteDo(GoodsDto goodsDto, RedirectAttributes ra, @RequestParam("files") MultipartFile[] files, FileDto fileDto) throws IOException {
		if (goodsService.insertGoods(goodsDto) > 0) {
			if(files != null) {
				 Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true);
				 for (MultipartFile file : files) {
				        File imageFile = new UploadController().convertMultipartFileToFile(file);
				        Map imageUrl2 = cloudinary.uploader().upload(imageFile, params1);
				        String imageUrl = cloudinary.url().generate((String) imageUrl2.get("secure_url"));
				        fileService.insertFile(fileDto);
				    }
			}
            ra.addFlashAttribute("msg", "상품 등록이 성공하였습니다.");
            return "redirect:/board"; // 성공 시 게시판으로 리다이렉트
        } else {
            ra.addFlashAttribute("msg", "상품 등록이 실패하였습니다. 다시 시도해주십시오.");
            return "goods/goodswrite"; // 실패 시 다시 글 작성 페이지로 이동
        }
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
