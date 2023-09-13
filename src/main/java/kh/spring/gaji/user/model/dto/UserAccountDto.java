package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserAccountDto {
    private String userAccount;
    private String userId;
    private int accountBalance;
}
