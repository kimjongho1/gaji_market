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
		System.out.println(cloudinary.config.cloudName);

		try {
			Map params1 = ObjectUtils.asMap("use_filename", true, "unique_filename", false, "overwrite", true);

			System.out.println(cloudinary.uploader()
					.upload("https://cloudinary-devs.github.io/cld-docs-assets/assets/images/coffee_cup.jpg", params1));
			Map params2 = ObjectUtils.asMap("quality_analysis", true);
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
