package kh.spring.gaji.admin.model.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserBlockingDto {
	private String bannedId; // 회원아이디 10자이내 영어로
	private String administerId; // 관리자ID
	private String refId;		//신고 참조 상품번호
	private String reasonForBlocking; // 정지사유
	private String createdAt; // 생성일자
}
