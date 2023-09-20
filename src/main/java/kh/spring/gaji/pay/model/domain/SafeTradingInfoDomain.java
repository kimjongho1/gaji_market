package kh.spring.gaji.pay.model.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

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
	private String tradingDate;
	private String trackingNumber;
}
