package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class InsertSafeTradingDto {
	private String impUid;
	private String buyerId;
	private String purchaseMethod;
	private int price;
	private String shippingAddress;
}
