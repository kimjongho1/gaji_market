package kh.spring.gaji.chat.model.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChatRoomDto {
	private int chatId;					//채팅방 ID
	private int goodsId;				//상품 ID
	private String sellerId;			//회원 아이디 10자이내 영어로만
	private String buyerId;				//회원 아이디 10자이내 영어로만
	private LocalDateTime createdAt;	//채팅방 생성일자
}
