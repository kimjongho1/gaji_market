package kh.spring.gaji.trade.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SafePurchaseInfoDomain {
    private int goodsId;
    private String goodsTitle;
    private String sellerId;
    private String buyerId;
    private String mobileNumber;
    private String name;
    private String shippingAddress;
    private double price;
    private String tradingDate;
    private String tradingStatus;
    private String trackingNumber;
}