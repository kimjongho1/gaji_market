package kh.spring.gaji.pay.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PayUserInfoDto {
	private String name;
	private String mobileNumber; 
}
