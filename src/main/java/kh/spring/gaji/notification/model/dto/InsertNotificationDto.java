package kh.spring.gaji.notification.model.dto;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Data
public class InsertNotificationDto {
    private String userId;
    private String message;
    private int type;
    private String referenceId;
}