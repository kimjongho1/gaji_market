package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SafePurchaseInfoDto {
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