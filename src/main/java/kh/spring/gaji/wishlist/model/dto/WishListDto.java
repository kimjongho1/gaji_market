package kh.spring.gaji.wishlist.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class WishListDto {
    private int goodsId;
    private String userId;
    private String createdAt;
}
