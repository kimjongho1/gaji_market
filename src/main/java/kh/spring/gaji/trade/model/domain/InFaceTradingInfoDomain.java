package kh.spring.gaji.trade.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.time.LocalDateTime;

@Component
@Data
public class InFaceTradingInfoDomain {
    private int inFaceTradingId;
    private int goodsId;
    private String sellerId;
    private String buyerId;
    private double price;
    private LocalDateTime tradingDate; 
    private String tradingStatus;

}