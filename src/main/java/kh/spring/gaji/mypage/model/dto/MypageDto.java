package kh.spring.gaji.mypage.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MypageDto {
	
	private String userId;
	private int role;
	private int dongId;
	private String name;
	private String password;
	private String mobileNumber;
	private double ratingScore;
	private String nickname;
	private String createdAt;
	private int enabled;
	private String athority;
	private int keywordCount;
	private int inviteCount;
	private String email;
	private String detailAddress;
	private String postCode;
	private String roadAddress;
	private String address;
	private String addressNickname;
	private String addressNo;
	
	
	
	
	
	
}
