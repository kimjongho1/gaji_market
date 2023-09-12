package kh.spring.gaji.file.controller;

import java.io.File;
import java.util.Map;

import com.cloudinary.*;
import org.springframework.stereotype.Controller;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;

@Controller
public class uploadController {

	Dotenv dotenv = Dotenv.load();
    Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
    result = cloudinary.uploader()
    		.text(String text);

    File file = new File("my_image.jpg");
    Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

}
