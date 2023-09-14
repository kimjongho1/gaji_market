package kh.spring.gaji.goods.model.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsDto {
	private int goodsId;
	private String userId;
	private int categoryId;
	private String title;
	private String status;
	private BigDecimal price;
	private long viewCount;
	private String description;
	private String refreshedAt;
	private LocalDateTime createdAt;
	private char safeTradingYN;
	private char activeStatus;
	private int lat;
	private int Lng;
	private int dongId;
	
	private String url;
}
