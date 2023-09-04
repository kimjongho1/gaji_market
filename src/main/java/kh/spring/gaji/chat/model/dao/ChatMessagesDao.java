package kh.spring.gaji.chat.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMessagesDao {

	@Autowired
	private SqlSession sqlSession;
	
	
}
