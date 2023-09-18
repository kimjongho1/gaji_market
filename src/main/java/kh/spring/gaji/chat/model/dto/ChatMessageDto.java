package kh.spring.gaji.chat.model.dto;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class ChatMessageDto {
    private int chattingId;			//채팅메세지ID
    private int chatId;				//채팅방 ID
    private String senderId;		//발신 ID
    private String message;			//채팅메세지
    private String readYn;			//읽기 여부
    private String createAt; 		//타입으로 변경
  }
