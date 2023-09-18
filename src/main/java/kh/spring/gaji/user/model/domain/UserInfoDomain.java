package kh.spring.gaji.user.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserInfoDomain {
    private String name;
    private String nickname;
    private String address;
    private String mobileNumber;
    private String createdAt;
    private String activateStatus;
    private int safeTradingCount;
    private int inFaceTradingCount;
    private int commentReportCount;
    private int communityReportCount;
    private int goodsReportCount;
}