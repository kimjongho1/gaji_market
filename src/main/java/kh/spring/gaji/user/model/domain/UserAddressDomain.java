package kh.spring.gaji.user.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserAddressDomain {
    private String address;
    private String detailAddress;
    private String userId;
    private String postCode;
    private String nickname;
    private String addressNo;
}