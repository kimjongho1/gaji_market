package kh.spring.gaji.report.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class GoodsReportInfoDto{
    private String reporterId;
    private int refId;
    private String title;
    private String createdAt;
    private String userId;
    private String reportCategory;
    private String approvalStatus;
    private String content;
}