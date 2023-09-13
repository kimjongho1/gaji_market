package kh.spring.gaji.notification.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class NotificationKeywordDto {
    private String keyword;
    private String userId;
    private LocalDateTime createdAt;
}
