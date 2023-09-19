package kh.spring.gaji.notification.model.Service;

import java.util.List;

import kh.spring.gaji.notification.model.dto.NotificationDto;

public interface NotificationService {
    List<NotificationDto> getNotiList(String userId);

    int updateNotiYN(int notiId); // 알림 클릭시 알림 읽음상태로 전환

    int countNotification(String userId); // 2P 알림갯수

    int insertNoti(NotificationDto notificationDto); // 알림생성

    List<NotificationDto> getTradeNotice(String userId);  // 18P 해당계정의 거래알림
}
