package kh.spring.gaji.goods.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MainGoodsDto {
	private int price;
	private String title;
	private String goodsId;
	private String url;
}
