		package kh.spring.gaji.trade.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class SafeTradingDto {
    private int transactionId;
    private String buyerId;
    private int goodsId; 
    private int purchaseMethod; 
    private int tradingStatus; 
    private String shippingAddress; //이후 int형으로 배송지테이블을 참조하는 번호로 사용해야할듯.
    private String trackingNumber;
    private LocalDateTime tradingDate;
}
