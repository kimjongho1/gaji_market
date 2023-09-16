package kh.spring.gaji.community.model.domain;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.time.LocalDateTime;

@Component
@Data
public class CommunityLikeDomain {
    private int boardId;
    private String title;
    private String writer;
    private LocalDateTime createdAt; 
    private int viewCount;
    private int likeCount;
}