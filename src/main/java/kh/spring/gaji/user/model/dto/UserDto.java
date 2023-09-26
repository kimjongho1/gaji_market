package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserDto {
    private String userId;
    private int role;
    private String name;
    private String password;
    private String mobileNumber;
    private double ratingScore;
    private String nickname;
    private String createdAt;
    private String email;
    private int keywordCount;
    private int dongId;
}