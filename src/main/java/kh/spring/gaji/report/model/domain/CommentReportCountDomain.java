package kh.spring.gaji.report.model.domain;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportCountDomain  {
	private LocalDateTime wdate;
    private int commentId;
    private String writerId;
    private int reportCount;
}
