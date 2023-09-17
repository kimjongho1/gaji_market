package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.time.LocalDateTime;

@Component
@Data
public class CommentReportListDomain {
	private LocalDateTime created_at;
    private int refId;
    private String reporterId;
    private String reportCategory;
    private LocalDateTime createdAt;
}