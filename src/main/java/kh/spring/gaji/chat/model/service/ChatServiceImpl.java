package kh.spring.gaji.chat.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.chat.model.dao.ChatDao;
import kh.spring.gaji.chat.model.dto.ChatMessageDto;
import kh.spring.gaji.chat.model.dto.ChatRoomDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDao chatDao;
	
	@Override
	public List<ChatRoomDto> getChatRoomList(String userId) {
		return chatDao.getChatRoomList(userId);
	}

	@Override
	public List<ChatMessageDto> getChatInfo(int chatId) {
		return chatDao.getChatInfo(chatId);
	}

	@Override
	public List<ChatMessageDto> getChatMessage(int chatId) {
		return chatDao.getChatMessage(chatId);
	}

	@Override
	public int insertChatMessage(Map<String, Object> map) {
		return chatDao.insertChatMessage(map);
	}

	@Override
	public int insertChatRoom(int goodId, String sellerId, String buyerId) {
		return chatDao.insertChatRoom(goodId, sellerId, buyerId);;
	}
	
}
