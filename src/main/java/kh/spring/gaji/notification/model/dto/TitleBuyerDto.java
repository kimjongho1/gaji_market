package kh.spring.gaji.notification.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TitleBuyerDto {
	private String sellerId;
	private String buyerId;	
	private String goodsTitle;
}
