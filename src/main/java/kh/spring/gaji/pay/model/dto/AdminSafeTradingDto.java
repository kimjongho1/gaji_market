package kh.spring.gaji.pay.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class AdminSafeTradingDto {
    private int transactionId;
    private String goodsTitle;
    private String sellerId;
    private String tradingStatus;
    private String tradingData;
}