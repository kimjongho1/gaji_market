package kh.spring.gaji.goods.model.dto;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsDto {
	private String userId;
	private int categoryId;
	private String title;
	private int price;
	private String description;
	private char safeTradingYN;
	private int lat;
	private int lng;
	private int dongId;
}
