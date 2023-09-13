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
}