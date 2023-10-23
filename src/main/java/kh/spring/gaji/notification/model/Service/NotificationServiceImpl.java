package kh.spring.gaji.notification.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.notification.model.dao.NotificationDao;
import kh.spring.gaji.notification.model.dto.NotificationDto;

import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;

    @Override //해당계정의 알림 불러오기.
    public List<NotificationDto> getNotiList(Map<String,Object> map) {
        return notificationDao.getNotiList(map);
    }

    @Override // 알림 클릭시 알림 읽음상태로 전환
    public int updateNotiYN(Map<String,Object> map) {
        return notificationDao.updateNotiYN(map);
    }

    @Override // 2P 알림갯수
    public int countNotification(Map<String,Object> map) {
        return notificationDao.countNotification(map);
    }

    @Override // 알림생성
    public int insertNoti(NotificationDto notificationDto) {
        return notificationDao.insertNoti(notificationDto);
    }

	@Override
	public String getIdFromTransactionId(String refId) {
		return notificationDao.getIdFromTransactionId(refId);
	}
	
	@Override
	public int getTotalCnt(String userId) {
		return notificationDao.getTotalCnt(userId);
	}
}
