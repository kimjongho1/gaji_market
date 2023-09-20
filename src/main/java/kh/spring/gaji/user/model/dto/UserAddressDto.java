package kh.spring.gaji.user.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserAddressDto {
    private String detailAddress;
    private String postCode;
    private String roadAddress;
    private String address;
    private String nickname;
    private int addressNo;
}
