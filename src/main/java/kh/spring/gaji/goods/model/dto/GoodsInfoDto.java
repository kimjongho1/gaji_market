package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsInfoDto{
    private int goodsId;
    private String userId;
    private int categoryId;
    private String title;
    private String status;
    private int price;
    private int viewCount;
    private String description;
    private String createdAt;
    private String safeTradingYn;
    private String dongId;
    private double lat;
    private double lng;
    private String nickname;
    private double ratingScore;
}
