package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class InFaceTradingInfoDto {
    private int inFaceTradingId;
    private int goodsId;
    private String sellerId;
    private String buyerId;
    private double price;
    private String tradingDate; 
    private String tradingStatus;

}