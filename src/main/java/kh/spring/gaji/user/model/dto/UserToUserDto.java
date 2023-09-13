package kh.spring.gaji.user.model.dto;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserToUserDto {
    private String userId;
    private String bannedId;
    private LocalDateTime createdDate;  
}
