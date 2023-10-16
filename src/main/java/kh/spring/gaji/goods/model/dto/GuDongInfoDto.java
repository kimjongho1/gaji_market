package kh.spring.gaji.goods.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GuDongInfoDto {
	int guId;
	int dongId;
	String guName;
	String dongName;
}
