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
    private int dongId;
    private String content;
    private String title;
    private LocalDateTime createdAt;
    private int viewCount;
    private char activeStatus;
    private int lng;
    private int lat;
}