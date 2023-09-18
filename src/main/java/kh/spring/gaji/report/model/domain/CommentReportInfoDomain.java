package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentReportInfoDomain {
    private String reporterId;
    private int boardId;
    private int refId;
    private String createdAt;
    private String approvalStatus;
    private String writerId;
    private String reportCategory;
    private String reportContent;
    private String commentContent;

    // 생성자, getter 및 setter 메서드는 필요에 따라 추가할 수 있습니다.
}
