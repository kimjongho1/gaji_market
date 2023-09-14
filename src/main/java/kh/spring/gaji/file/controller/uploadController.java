package kh.spring.gaji.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class uploadController {

	Dotenv dotenv = Dotenv.load();
	Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

	@GetMapping("/upload")
	public String showUploadForm() {
		return "filetest"; // 이미지 업로드 폼을 표시할 JSP 페이지로 이동
	}

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		File imageFile = convertMultipartFileToFile(file); // 해당하는 file형식으로 변환
		Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true); // 업로드할 파일의 형식을 정해줌
		Map imageUrl2 = cloudinary.uploader().upload(imageFile, params1);// (imageFile);// 해당 하는 params1의 설정으로 imageFile을 업로드함.
		System.out.println(imageUrl2);
//		String imageUrl = cloudinary.url().generate((String)imageUrl2.get("secure_url")); // 해당파일이 
//		System.out.println(imageUrl);
		model.addAttribute("imageUrl", imageUrl2);
		return "image-display"; // 업로드된 이미지와 URL을 표시할 JSP 페이지로 이동
	
	}

	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		file.transferTo(convertedFile);
		return convertedFile;
	}
}