package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFaceTradingDto {
	private int inFaceTadingId;
    private int goodsId; 	
    private String goodsTitle;
    private int price;
    private String buyerId;
    private String tradingDate; 
    private int tradingStatus; 
}