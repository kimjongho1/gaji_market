package kh.spring.gaji.trade.model.domain;

import org.springframework.stereotype.Component;
import lombok.Data;
import java.time.LocalDateTime;

@Component
@Data
public class SafeTradingInfoDomain {
	private int transactionId;
	private String sellerId;
	private String perchaseMethod;
	private String buyerId;
	private String title;
	private double price;
	private String shippingAddress;
	private LocalDateTime tradingDate;
	private String trackingNumber;
}
