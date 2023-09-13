package kh.spring.gaji.pay.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFaceTradingDto {
    private int goodsId; 	
    private String sellerId;
    private String buyerId;
    private String goodsTitle;
    private LocalDateTime tradingDate; 
    private int price;
    private int tradingLocation; 
    private int tradingStatus; 
}
