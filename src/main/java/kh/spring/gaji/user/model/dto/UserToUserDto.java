package kh.spring.gaji.user.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserToUserDto {
    private String userId;
    private String bannedId;
    private String createdDate;  
}
