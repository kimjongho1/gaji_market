package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFacePurchaseDto {
	private int inFaceTradingId;
    private int goodsId;
    private String goodsTitle;
    private String sellerId;
    private String buyerId;
    private String tradingDate;
}
