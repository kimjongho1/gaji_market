package kh.spring.gaji.report.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityReportListDto {
    private int boardId;
    private String title;
    private String writer;
    private int reportCount;
}
