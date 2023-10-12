package kh.spring.gaji.chat.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChatRoomDto {
	private int chatId;					//채팅방 ID
	private int goodsId;				//상품 ID
	private String sellerId;			//회원 아이디 10자이내 영어로만
	private String buyerId;				//회원 아이디 10자이내 영어로만
	private String createdAt;			//채팅방 생성일자
	private String nickname;			//상대방 닉네임 표시
	
	private List<ChatMessageDto> chatInfo;
}
