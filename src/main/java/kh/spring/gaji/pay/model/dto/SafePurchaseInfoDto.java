package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SafePurchaseInfoDto {
	private String buyerId;
	private String sellerId;
	private String transactionId;
    private int goodsId;
    private String goodsTitle;
    private String sellerName;
    private String buyerName;
    private String mobileNumber;
    private String name;
    private int price;
    private String tradingDate;
    private String tradingStatus;
    private String shippingCompany;
    private String trackingNumber;
    private String detailAddress;
    private String roadAddress;
}