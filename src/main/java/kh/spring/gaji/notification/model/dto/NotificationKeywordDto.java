package kh.spring.gaji.notification.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class NotificationKeywordDto {
    private String keyword;
    private String userId;
    private String createdAt;
}
