package kh.spring.gaji.administer.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class AdministerDto {
    private String administerId;
    private String password;
    private String emailAddress;
    private String mobileNumber;
    private int enabled;
    private int authority;
}
