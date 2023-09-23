package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class InsertSafeTradingDto {
	private String transactionId;
	private String buyerId;
	private String purchaseMethod;
	private int price;
	private String detailAddress;
	private String roadAddress;
}
