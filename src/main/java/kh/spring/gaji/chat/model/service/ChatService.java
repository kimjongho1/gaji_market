package kh.spring.gaji.chat.model.service;

import java.util.List;

import kh.spring.gaji.chat.model.dto.ChatRoomDto;

public interface ChatService {
	
	//현재 진행중인 채팅 리스트
	List<ChatRoomDto> getChatRoom(String userId);
}
