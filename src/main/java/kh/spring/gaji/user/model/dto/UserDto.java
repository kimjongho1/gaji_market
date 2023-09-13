package kh.spring.gaji.user.model.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserDto {
    private String userId;
    private int role;
    private String password;
    private String mobileNumber;
    private double ratingScore;
    private String nickname;
    private LocalDateTime createdAt;
    private int enabled;
    private int authority;
    private int keywordCount;
    private int inviteCount;
}