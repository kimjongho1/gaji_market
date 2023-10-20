package kh.spring.gaji.notification.model.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.notification.model.dto.NotificationDto;

@Repository
public class NotificationDao {
    @Autowired
    private SqlSession sqlSession;

    // 알림 클릭시 알림 읽음상태로 전환
    public int updateNotiYN(Map<String,Object> map) {
        return sqlSession.update("notification.updateNotiYN", map);
    }

    // 알림갯수
    public int countNotification(Map<String,Object> map) {
        return sqlSession.selectOne("notification.countNotification", map);
    }
    
    //해당계정의 거래알림 불러오기.
    public List<NotificationDto> getNotiList(Map<String,Object> map) { 
        return sqlSession.selectList("notification.getNoticeList", map);
    }
    // 알림생성
    public int insertNoti(NotificationDto notificationDto) {
    	return sqlSession.insert("notification.insertNoti", notificationDto);
    }
    
    public String getIdFromTransactionId(String refId) {
    	return sqlSession.selectOne("notification.getIdFromTransactionId",refId);
    }
}