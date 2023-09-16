package kh.spring.gaji.community.model.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommentDto {
    private int commentId;
    private int boardId;
    private String writerId;
    private String content;
    private LocalDateTime wdate;
    private int ccidx;
    private int step;
    private char activeStatus;
    private int depth;
    
    //인덱스 생성해야함
    private String nickname;
}