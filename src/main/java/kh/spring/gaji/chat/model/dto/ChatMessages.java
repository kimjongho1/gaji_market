package kh.spring.gaji.chat.model.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChatMessages {
	private int chattingId;			//채팅메세지 번호
	private int chatId;				//채팅방 iD
	private String senderId;		//회원 아이디 10자이내 영어로만
	private String message;			//채팅메세지
	private String readYn;			//읽기 여부
	private LocalDateTime createAt;	//채팅 생성일자
}
