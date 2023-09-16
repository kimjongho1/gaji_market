package kh.spring.gaji.report.model.domain;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ReportInfoDomain {
    private String reporterId;
    private int refId;
    private String title;
    private LocalDateTime createdAt;
    private String approvalStatus;
    private String writer;
    private String reportCategory;
    private String content;
}


