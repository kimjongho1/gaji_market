package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class GoodsListDto {
	private int goodsId;
	private String userId;
	private String title;
	private int price;
	private char status;
	private String created_at;
}
