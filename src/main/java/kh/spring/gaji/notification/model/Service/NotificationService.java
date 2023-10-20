package kh.spring.gaji.notification.model.Service;

import java.util.List;
import java.util.Map;

import kh.spring.gaji.notification.model.dto.NotificationDto;

public interface NotificationService {
    List<NotificationDto> getNotiList(Map<String,Object> map);

    int updateNotiYN(Map<String,Object> map); // 알림 클릭시 알림 읽음상태로 전환

    int countNotification(Map<String,Object> map); // 2P 알림갯수

    int insertNoti(NotificationDto notificationDto); // 알림생성
    
    String getIdFromTransactionId(String refId);
}
