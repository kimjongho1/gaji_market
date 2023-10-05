package kh.spring.gaji.goods.model.dto;
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
	private char safeTradingYn;
	private double lat;
	private double lng;
	private int dongId;
}
