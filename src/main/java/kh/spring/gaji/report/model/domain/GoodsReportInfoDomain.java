package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsReportInfoDomain{
    private String reporterId;
    private int refId;
    private String title;
    private String createdAt;
    private String userId;
    private String reportCategory;
    private String approvalStatus;
    private String content;
}