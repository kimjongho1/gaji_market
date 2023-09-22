package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class UserProfileDto {
	private String name;
	private String ratingScore;
	private String nickName;
	private String mobileNumber;
	private String role;
}
