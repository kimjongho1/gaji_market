package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class GoodsListDto {
	private String url;
	private String title;
	private int price;
	private String createdAt;
	private int goodsId;
	private String userId;
	private String nickname;
	private int status;
	private int likeCount;
	private String safeTradingYn;
	private String dongName;
	private int guId;
	private int dongId;
	private int viewCount;
}
