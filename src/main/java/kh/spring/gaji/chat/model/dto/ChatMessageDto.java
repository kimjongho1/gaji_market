package kh.spring.gaji.chat.model.dto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ChatMessageDto {
    private long chattingId;
    private long chatId;
    private String senderId;
    private String message;
    private String readYn;
    private LocalDateTime createAt; // LocalDateTime 타입으로 변경
  }
