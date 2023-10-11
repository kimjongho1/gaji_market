package kh.spring.gaji.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.chat.model.dao.ChatDao;
import kh.spring.gaji.chat.model.dto.ChatRoomDto;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDao chatDao;

	@Override
	public List<ChatRoomDto> getChatRoom(String userId) {
		System.out.println(userId);
		return chatDao.getChatRoomList(userId);
	}
	
}
