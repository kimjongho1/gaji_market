package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class GoodsListDto {
	private int avgPrice;
	private int topPrice;
	private int bottomPrice;
	private String title;
	private int price;
	private String created_at;
	private int goodsId;
	private String userId;
	private String nickname;
	private char status;
	private int likeCount;
	private char SafeTradingYn;
	private String dongName;
	private int guId;
	private int dongId;
}
