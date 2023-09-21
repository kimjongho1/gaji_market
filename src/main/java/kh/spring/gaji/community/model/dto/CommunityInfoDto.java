package kh.spring.gaji.community.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommunityInfoDto {
    private int boardId;
    private String nickname;
    private String writer;
    private String dongId;
    private String title;
    private String content;
    private String createdAt;
    private int viewCount;
    private double lat;
    private double lng;
    private int likeCount;
}