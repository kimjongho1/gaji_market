package kh.spring.gaji.notification.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.notification.model.dao.NotificationDao;
import kh.spring.gaji.notification.model.dto.NotificationDto;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;

    @Override //해당계정의 알림 불러오기.
    public List<NotificationDto> getNotiList(String userId) {
        return notificationDao.getNotiList(userId);
    }

    @Override // 알림 클릭시 알림 읽음상태로 전환
    public int updateNotiYN(int notiId) {
        return notificationDao.updateNotiYN(notiId);
    }

    @Override // 2P 알림갯수
    public int countNotification(String userId) {
        return notificationDao.countNotification(userId);
    }

    @Override // 알림생성
    public int insertNoti(NotificationDto notificationDto) {
        return notificationDao.insertNoti(notificationDto);
    }

    @Override // 18P 해당계정의 거래알림
    public List<NotificationDto> getTradeNotice(String userId) {
        return notificationDao.getTradeNotice(userId);
    }
}
