package kh.spring.gaji.administer.model.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserBlockingDto {
	private String bannedId; // 회원아이디 10자이내 영어로
	private String administerId; // 관리자ID
	private String reasonForBlocking; // 정지사유
	private LocalDateTime createdAt; // 생성일자
	private int reportId; // 신고대상ID
	private int reportClass; // (1:상품,2:커뮤니티,3:댓글)
	
	
}
