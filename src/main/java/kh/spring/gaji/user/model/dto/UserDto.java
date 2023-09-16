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
    private String name;
    private String password;
    private String mobileNumber;
    private double ratingScore;
    private String nickname;
    private LocalDateTime createdAt;
    private String email;
    private int enabled;
    private int authority;
    private int keywordCount;
    private int inviteCount;
    private int dongId;
    
    //추가로 필요한 변수 37P
    private int reportCount;
    private int commentReportCount;
    private int communityReportCount;
    private int goodsCount;
    private int tradeCount;
}