package kh.spring.gaji.report.model.dto;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReportDto {
    private int refId;
    private String reporterId;
    private String content;
    private int reportCategory;
    private LocalDateTime createdAt;
    private char approvalStatus;	
}