package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportCountDomain  {
    private int commentId;
    private String writerId;
    private int reportCount;
}
