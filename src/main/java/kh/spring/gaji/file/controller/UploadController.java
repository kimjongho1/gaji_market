package kh.spring.gaji.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

	Dotenv dotenv = Dotenv.load();
	Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

	@GetMapping("/upload")
	public String showUploadForm() {
		return "filetest"; // 이미지 업로드 폼을 표시할 JSP 페이지로 이동
	}
	@GetMapping("/superce")
	public String showUploadForm1() {
		return "superce"; // 이미지 업로드 폼을 표시할 JSP 페이지로 이동
	}
	@GetMapping("/address")
	public String address() {
		return "address/addresstest"; // 이미지 업로드 폼을 표시할 JSP 페이지로 이동
	}
	

	@PostMapping("/upload")
	@ResponseBody
	public String uploadImage(@RequestParam(value="upload", required = false) MultipartFile file, Model model) throws IOException {
		File imageFile = convertMultipartFileToFile(file); // 해당하는 file형식으로 변환
		Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true); // 업로드할 파일의 형식을 정해줌
		Map imageUrl2 = cloudinary.uploader().upload(imageFile, params1);// (imageFile);// 해당 하는 params1의 설정으로 imageFile을 업로드함.
		System.out.println(imageUrl2);
		String imageUrl = cloudinary.url().generate((String)imageUrl2.get("secure_url")); // 업로드된 파일의 url을 가져옴
		System.out.println(imageUrl);
//		model.addAttribute("imageUrl", imageUrl2);
//		String jsonResponse = "{ \"uploaded\" : true, \"url\" : \"" + imageUrl + "\" }"; // String 값으로 JSON형식 만듬
//		System.out.println(jsonResponse);
		Map<String, Object> uploaded = new HashMap<String, Object>(); // 위에 String 값으로 해도되나 더러워보여 HashMap형식으로 넣고 Gson으로 json형식 변환
		uploaded.put("uploaded", true);
		uploaded.put("uploaded", imageUrl);
		return new Gson().toJson(uploaded);
		
//		return jsonResponse; // 업로드된 이미지와 URL을 표시할 JSP 페이지로 이동
	
	}

	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		file.transferTo(convertedFile);
		return convertedFile;
	}
}