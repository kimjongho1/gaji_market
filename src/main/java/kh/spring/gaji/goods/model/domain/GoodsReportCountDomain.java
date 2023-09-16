package kh.spring.gaji.goods.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsReportCountDomain {
    private int goodsId;
    private String title;
    private String userId;
    private int reportCount;
}
