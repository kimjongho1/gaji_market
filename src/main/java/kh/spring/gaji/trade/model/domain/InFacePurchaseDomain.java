package kh.spring.gaji.trade.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFacePurchaseDomain {
    private int goodsId;
    private String sellerId;
    private String goodsTitle;
    private String buyerId;
    private String tradingDate;
}
