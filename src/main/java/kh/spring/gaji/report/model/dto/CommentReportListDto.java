package kh.spring.gaji.report.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportListDto {
	private String created_at;
    private int refId;
    private String reporterId;
    private String reportCategory;
    private String createdAt;
}