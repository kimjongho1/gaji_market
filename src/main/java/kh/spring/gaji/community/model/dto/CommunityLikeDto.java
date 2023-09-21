package kh.spring.gaji.community.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityLikeDto {
    private int boardId;
    private String title;
    private String writer;
    private String createdAt; 
    private int viewCount;
    private int likeCount;
}