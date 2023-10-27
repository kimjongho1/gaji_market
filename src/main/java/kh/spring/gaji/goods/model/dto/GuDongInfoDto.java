package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GuDongInfoDto {
	private int guId;
	private int dongId;
	private String guName;
	private String dongName;
}
