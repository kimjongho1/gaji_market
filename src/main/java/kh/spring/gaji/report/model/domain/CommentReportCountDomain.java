package kh.spring.gaji.report.model.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportCountDomain  {
	private String wdate;
    private int commentId;
    private String writerId;
    private int reportCount;
}
