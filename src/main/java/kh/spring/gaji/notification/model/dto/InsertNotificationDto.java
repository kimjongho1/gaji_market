package kh.spring.gaji.notification.model.dto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InsertNotificationDto {
    private String buyerId;
    private String sellerId;
    private String message;
    private int type;
    private String referenceId;
}