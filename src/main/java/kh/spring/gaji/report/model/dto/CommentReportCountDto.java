package kh.spring.gaji.report.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportCountDto  {
	private String wdate;
    private int commentId;
    private String writerId;
    private int reportCount;
}
