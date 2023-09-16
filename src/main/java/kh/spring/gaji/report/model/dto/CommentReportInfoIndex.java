package kh.spring.gaji.report.model.dto;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportInfoIndex {
    private String reporterId;
    private int refId;
    private String title;
    private LocalDate createdAt;
    private String approvalStatus;
    private String writer;
    private String reportCategory;
    private String content;
}
