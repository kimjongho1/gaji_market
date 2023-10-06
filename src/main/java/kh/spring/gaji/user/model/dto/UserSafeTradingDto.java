package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class UserSafeTradingDto {
	private String transactionId;
	private String goodsTitle;
	private int tradingStatus; 
	private int price;
	private int wishCount;
	private int goodsId;
	private String tradingDate;
}
