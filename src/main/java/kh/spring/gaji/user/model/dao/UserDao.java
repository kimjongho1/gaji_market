package kh.spring.gaji.user.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.user.model.domain.UserAddressDomain;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;

@Repository
public class UserDao {
    @Autowired
    private SqlSession sqlSession;

    // 주소를 제외한 프로필들을 가져옴.
    public UserDto getProfile(String userId) {
        return sqlSession.selectOne("user.getProfile", userId);
    }
    //해당 아이디의 주소를 모두가져옴.
    public List<UserAddressDto> getAddress(String userId) {	
        return sqlSession.selectList("user.getAddress", userId);
    }
    
    // 대표 주소를 변경하기 위해 주소 순서를 하나씩 뒤로 민다
    public int updateMainAddressNo(String userId) {
    	return sqlSession.update("user.updateMainAddressNo", userId);
    }

    // 주소 순서를 1로 바꿈으로써 대표 주소 변경
    public int updateMainAddress(Map<String, Object> map) {
    	return sqlSession.update("user.updateMainAddress", map);
    }

    // 새로 입력된 주소를 count+1 주소 순서에 추가한다
    public int insertAddress(UserAddressDomain userAddressDomain) {
    	return sqlSession.insert("user.insertAddress", userAddressDomain);
    }

    // 주소 삭제 1단계 작업
    public int deleteAddress1(int postCode) {
    	return sqlSession.delete("user.deleteAddress1", postCode);
    }
    public int deleteAddress2(int postCode) {
        return sqlSession.update("user.deleteAddress2", postCode);
    }
    // 닉네임 중복 검사
    public int checkNickname(String nickname) {
        return sqlSession.selectOne("user.checkNickname", nickname);
    }

    // 이메일 중복 검사
    public int checkEmail(String email) {
        return sqlSession.selectOne("user.checkEmail", email);
    }

    // 패스워드를 가져온다 (패스워드 변경 또는 로그인 시 사용)
    public String checkPass(String userId) {
        return sqlSession.selectOne("user.checkPass", userId);
    }

    // 로그인 시 방문 횟수 + 1
    public int updateInviteCount(String userId) {
    	return sqlSession.update("user.updateInviteCount", userId);
    }

    // 패스워드를 변경한다
    public int updatePass(Map<String, Object> map) {
    	return sqlSession.update("user.updatePass", map);
    }

    // 아이디 중복 검사
    public int checkId(String userId) {
        return sqlSession.selectOne("user.checkId", userId);
    }

    // 전화번호 중복 검사
    public int checkMobileNumber(String mobileNumber) {
        return sqlSession.selectOne("user.checkMobileNumber", mobileNumber);
    }

    // 회원 가입
    public int signup(UserDto userDto) {
    	return sqlSession.insert("user.signup", userDto);
    }

    // 아이디 찾기
    public String findId(Map<String, Object> map) {
        return sqlSession.selectOne("user.findId", map);
    }

    // 비밀번호 변경
    public int findPass(Map<String, Object> map) {
    	return sqlSession.update("user.findPass", map);
    }

    // 계좌 등록
    public int addAccount(String userAccount, String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userAccount", userAccount);
        map.put("userId", userId);
        return sqlSession.insert("user.addAccount", map);
    }

    // 유저 즐겨찾기(모아보기) 23P
    public int addFavoriteUser(Map<String, Object> map) {
        return sqlSession.insert("user.addFavoriteUser", map);
    }

    // 거래 후기 넣기 (아직 화면 설계 없음)
    public int addDealReview(DealReviewDto dealReviewDto) {
    	return sqlSession.insert("user.addDealReview", dealReviewDto);
    }

    // trade-mapper의 거래 후기에 따른 매너 온도 업데이트
    public int updateRatingScore(Map<String, Object> map) {
    	return sqlSession.update("user.updateRatingScore", map);
    }
}
