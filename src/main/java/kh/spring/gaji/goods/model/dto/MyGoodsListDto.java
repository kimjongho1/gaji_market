package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class MyGoodsListDto {
    private int goodsId;
    private String title;
    private int price;
    private int status;
    private int wishCount;
    private int viewCount;
    private String dongName;
    private String nickname;
    private String refreshedAt;
    private String createdAt;
    private String url;
}
