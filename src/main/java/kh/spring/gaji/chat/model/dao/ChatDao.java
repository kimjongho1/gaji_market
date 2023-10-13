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
	
	/**
	  * @Method Name : getChatRoomList
	  * @작성일 : 2023. 10. 12.
	  * @작성자 : 1313k
	  * @변경이력 : 
	  * @Method 설명 : userId를 가져와서 chat_id, nickname, seller_id, created_at return
	  * @param userId
	  * @return
	  */
	public List<ChatRoomDto> getChatRoomList(String userId) {
		System.out.println(userId);
		return sqlSession.selectList("chat.selectChatListByUserId", userId);
	}
	
	public List<ChatMessageDto> getChatInfo(int chatNo) {
		return sqlSession.selectList("chat.selectChatMessageByChatNo", chatNo);
	}
}
