package kh.spring.gaji.chat.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.chat.model.dto.ChatMessageDto;
import kh.spring.gaji.chat.model.dto.ChatRoomDto;

@Repository
public class ChatDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<ChatRoomDto> getChatRoomList(String userId) {
		System.out.println(userId);
		return sqlSession.selectList("chat.selectChatListByUserId", userId);
	}
	
	public List<ChatMessageDto> getChatInfo(int chatNo) {
		return sqlSession.selectList("chat.selectChatInfoByChatNo", chatNo);
	}
	
	public List<ChatMessageDto> getChatMessage(int chatNo) {
		return sqlSession.selectList("chat.selectChatMessageByChatNo", chatNo);
	}
}
