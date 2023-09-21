package kh.spring.gaji.report.model.dto;
import lombok.Data;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReportDto {
    private int refId;
    private String reporterId;
    private int reportCategory;
    private String content;
    private String createdAt;
    private char approvalStatus;	
}