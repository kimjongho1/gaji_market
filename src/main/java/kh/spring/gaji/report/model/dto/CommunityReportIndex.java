package kh.spring.gaji.report.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityReportIndex {
	private String refId;
    private String writer;
    private String title;
    private String reporterId;
    private LocalDateTime createdAt;
}