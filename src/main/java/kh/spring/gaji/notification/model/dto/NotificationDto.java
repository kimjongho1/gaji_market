package kh.spring.gaji.notification.model.dto;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Data
public class NotificationDto {
    private int notiId;
    private String userId;
    private String message;
    private int readYn;
	/* private int type; */
    private String referenceId;
    private String createdAt;
}