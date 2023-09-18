package kh.spring.gaji.goods.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsInfoDomain{
    private int goodsId;
    private String userId;
    private int categoryId;
    private String title;
    private String status;
    private double price;
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
