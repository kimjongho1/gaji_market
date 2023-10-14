package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsListInfoDto {
	private int totalCnt;
	private int bottomPrice;
	private int averagePrice;
	private int topPrice;
}
