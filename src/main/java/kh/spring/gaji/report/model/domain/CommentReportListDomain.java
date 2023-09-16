package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.time.LocalDateTime;

@Component
@Data
public class CommentReportListDomain {
    private int refId;
    private String reporterId;
    private String reportCategory;
    private LocalDateTime createdAt;

    // 생성자, getter 및 setter 메서드는 필요에 따라 추가할 수 있습니다.
}