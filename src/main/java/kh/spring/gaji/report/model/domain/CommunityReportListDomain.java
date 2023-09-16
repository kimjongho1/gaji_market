package kh.spring.gaji.report.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityReportListDomain {
    private int boardId;
    private String title;
    private String writer;
    private int reportCount;
}
