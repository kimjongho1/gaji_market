package kh.spring.gaji.file.controller;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


public class test {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
		cloudinary.config.secure = true;
		System.out.println(cloudinary.config.cloudName); // API cloud name 불러오기

		try {
			// 해당 파일 업로드 설정 use_filename == 파일 이름을 그대로 쓴다. unique_filename true : 중복허용 false : 중복불가 overwirte : 덮어쓰기 허용
			Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true);
			System.out.println(cloudinary.uploader()
					.upload("https://cloudinary-devs.github.io/cld-docs-assets/assets/images/coffee_cup.jpg", params1));
			// 위에 해당 cloudinary.uploader().upload("", params1); 을 통해 첫번째 매개인자는 들어오는파일 , 두번째는 해당 파일의 설정 값을 의미한다.
			
			Map params2 = ObjectUtils.asMap("quality_analysis", true);
			//String imageUrl = cloudinary.url().generate("coffee_cup");  해당하는 부분은 해당 이미지의 url값만 가져오는 method

			System.out.println(cloudinary.api().resource("coffee_cup", params2));

			// Create the image tag with the transformed image and log it to the console
			System.out.println(cloudinary.url()
					.transformation(
							new Transformation().crop("pad").width(300).height(400).background("auto:predominant"))
					.imageTag("coffee_cup"));
			// The code above generates anÏ HTML image tag similar to the following:
			// <img
			// src='https://res.cloudinary.com/demo/image/upload/b_auto:predominant,c_pad,h_400,w_300/coffee_cup'
			// height='400' width='300'/>

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
