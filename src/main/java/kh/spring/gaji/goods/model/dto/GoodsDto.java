package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsDto {
	private String userId;
	private int goodsId;
	private int categoryId;
	private String title;
	private int status;
	private int price;
	private int viewCount;
	private String description;
	private String refreshedAt;
	private String createdAt;
	private char safeTradingYn;
	private double lat;
	private double lng;
	private int dongId;
	private String activeStatus;
	private int wishlist;
	
	
}
