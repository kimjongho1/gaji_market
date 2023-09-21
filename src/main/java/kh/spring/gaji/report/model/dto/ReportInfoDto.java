package kh.spring.gaji.report.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ReportInfoDto {
    private String reporterId;
    private int refId;
    private String title;
    private String createdAt;
    private String approvalStatus;
    private String writer;
    private String reportCategory;
    private String content;
}

