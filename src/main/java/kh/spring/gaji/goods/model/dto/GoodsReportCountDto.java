package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsReportCountDto {
    private int goodsId;
    private String title;
    private String userId;
    private int reportCount;
    private String createdAt;
}
