package kh.spring.gaji.trade.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFaceTradingDto {
	private int inFaceTadingId;
    private int goodsId; 	
    private String buyerId;
    private String tradingDate; 
    private int tradingStatus; 
    
    //JOIN시 필요할 변수
    private String goodsTitle;
    private int price;
    private String sellerId;
    private String name;
}