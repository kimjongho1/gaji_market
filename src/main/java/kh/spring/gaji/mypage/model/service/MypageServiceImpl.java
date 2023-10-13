package kh.spring.gaji.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.mypage.model.dao.MypageDao;
import kh.spring.gaji.mypage.model.dto.MypageDto;

@Service
@Transactional
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	private MypageDao mypageDao;
	
	@Override
	public List<MypageDto> userMypage(String userId) {
		return mypageDao.userMypage(userId);
	}

	@Override
	public int updateName(Map<String, String> map) {
		return mypageDao.updateName(map);
	}

	@Override
	public int updateNickname(Map<String, String> map) {
		return mypageDao.updateNickname(map);
	}

	@Override
	public int updateEmail(Map<String, String> map) {
		return mypageDao.updateEmail(map);
	}

	@Override
	public int updateMobileNumber(Map<String, String> map) {
		return mypageDao.updateMobileNumber(map);
	}

	@Override
	public String checkName(String name) {
		return mypageDao.checkName(name);
	}

	@Override
	public String checkNickname(String nickname) {
		return mypageDao.checkNickname(nickname);
	}

	@Override
	public String checkEmail(String email) {
		return mypageDao.checkEmail(email);
	}

	@Override
	public String checkMobilNumber(String mobileNumber) {
		return mypageDao.checkMobilNumber(mobileNumber);
	}
	
	
}
