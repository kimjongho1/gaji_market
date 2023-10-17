package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsInfoDto{
    private int goodsId;
    private String userId;
    private int categoryId;
    private String categoryName;
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
    private int wishcount;
    private String url;
    private int reviewcount;
    private int sellgoods;
    private int safetradecount;
}
