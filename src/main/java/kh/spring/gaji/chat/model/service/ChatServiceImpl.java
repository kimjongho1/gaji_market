package kh.spring.gaji.chat.model.service;

import java.util.List;

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
	public List<ChatRoomDto> getChatRoom(String userId) {
		return chatDao.getChatRoomList(userId);
	}

	@Override
	public List<ChatMessageDto> getChatInfo(int chatNo) {
		return chatDao.getChatInfo(chatNo);
	}

	@Override
	public List<ChatMessageDto> getChatMessage(int chatId) {
		return chatDao.getChatMessage(chatId);
	}
	
}
