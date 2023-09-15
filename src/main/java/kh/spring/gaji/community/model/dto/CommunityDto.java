package kh.spring.gaji.community.model.dto;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Data
public class CommunityDto {
    private int boardId;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private int viewCount;
    private String location;
    private char activeStatus;
    private int lng;
    private int lat;
    private int dongId;
    private int likeCount;
}