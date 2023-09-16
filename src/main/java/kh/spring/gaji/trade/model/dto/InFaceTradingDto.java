package kh.spring.gaji.trade.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFaceTradingDto {
	private int inFaceTadingId;
    private int goodsId; 	
    private String buyerId;
    private LocalDateTime tradingDate; 
    private int tradingStatus; 
    
    //JOIN시 필요할 변수
    private String goodsTitle;
    private int price;
    private String sellerId;
    private String name;
}
