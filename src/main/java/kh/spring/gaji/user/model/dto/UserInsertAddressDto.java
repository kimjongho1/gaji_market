package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserInsertAddressDto {
    private String detailAddress;
    private String postCode;
    private String userId;
    private String roadAddress;
    private String address;
    private String addressNickname;
    private String addressNo;
}