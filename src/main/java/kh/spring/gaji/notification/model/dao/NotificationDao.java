package kh.spring.gaji.notification.model.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.notification.model.dto.NotificationDto;

@Repository
public class NotificationDao {
    @Autowired
    private SqlSession sqlSession;

    public List<NotificationDto> getNotiList(String userId) { //해당계정의 알림 불러오기.
        return sqlSession.selectList("notification.getNotiList", userId);
    }
    
    // 알림 클릭시 알림 읽음상태로 전환
    public int updateNotiYN(int notiId) {
        return sqlSession.update("notification.updateNotiYN", notiId);
    }

    // 2P 알림갯수
    public int countNotification(String userId) {
        return sqlSession.selectOne("notification.countNotification", userId);
    }

    // 알림생성
    public int insertNoti(NotificationDto notificationDto) {
    	return sqlSession.insert("notification.insertNoti", notificationDto);
    }
    
    // 18P 해당계정의 거래알림
    public List<NotificationDto> getTradeNotice(String userId) {
        return sqlSession.selectList("notification.getTradeNotice", userId);
    }
}