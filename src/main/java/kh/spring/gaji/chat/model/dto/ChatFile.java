package kh.spring.gaji.chat.model.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChatFile {
	private int number;				//파일ID
	private int chatId;				//채팅방ID
	private String type;			//파일 타입
	private String fileName;		//파일 이름
	private LocalDateTime createAt;	//파일 생성일자
}
