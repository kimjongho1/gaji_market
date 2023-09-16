package kh.spring.gaji.user.model.domain;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserInfoDomain {
    private String name;
    private String nickname;
    private String address;
    private String mobileNumber;
    private LocalDateTime createdAt;
    private String activateStatus;
    private int safeTradingCount;
    private int inFaceTradingCount;
    private int commentReportCount;
    private int communityReportCount;
    private int goodsReportCount;
}