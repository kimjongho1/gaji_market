package kh.spring.gaji.mypage.model.service;
import java.util.Map;

import kh.spring.gaji.mypage.model.dto.MypageDto;

public interface MypageService {
	
	public MypageDto userMypage(String userId);
	
	public int changePassword(Map<String, String> map);
	
	public String searchPassword(String userId);
	
	public int updateName(Map<String, String> map);
	
	public int updateNickname(Map<String, String> map);
	
	public int updateEmail(Map<String, String> map);
	
	public int updateMobileNumber(Map<String, String> map);
	
	public String checkName(String name);
	
	public String checkNickname(String nickname);
	
	public String checkEmail(String email);
	
	public String checkMobilNumber(String mobileNumber);
}
