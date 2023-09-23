package kh.spring.gaji.pay.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class GoodsPayInfoDto {
	private int goodsId;
	private String title;
	private int price;
}
