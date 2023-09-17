package kh.spring.gaji.community.model.domain;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityInfoDomain {
    private int boardId;
    private String nickname;
    private String writer;
    private String dongId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int viewCount;
    private double lat;
    private double lng;
    private int likeCount;
}