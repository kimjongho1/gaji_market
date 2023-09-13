package kh.spring.gaji.pay.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SafeTradingDto {
    private int transactionId;
    private String sellerId;
    private String buyerId;
    private int price;
    private int goodsId; 
    private int purchaseMethod; 
    private String goodsTitle;
    private LocalDateTime tradingDate; 
    private int tradingStatus; 
    private String shippingAddress;
    private String trackingNumber;
}
