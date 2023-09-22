package kh.spring.gaji.user.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;
import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;
import kh.spring.gaji.user.model.dto.UserProfileDto;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public List<GoodsListDto> getKeepList(String userId) {	// 5P 사진을 포함한 찜목록을 가져옴
        return sqlSession.selectList("goods.getKeepList", userId);
    }

    public int updateViewCount() {	//상품글 조회수 +1
        return sqlSession.update("goods.updateViewCount");
    }

    public List<GoodsListDto> getFavoriteList(String userId) {	//6P 사진을 포함한 모아보기목록 가져옴
        return sqlSession.selectList("goods.getFavoriteList", userId);
    }

    public List<SafeTradingDto> getSafePurchaseList(String buyerId) {	//9P 안전거래 구매내역(회원) 불러오기
        return sqlSession.selectList("goods.getSafePurchaseList", buyerId);
    }

    public List<InFaceTradingDto> getInfacePurchaseList(String buyerId) {	//9P 직거래 구매내역(회원) 불러오기
        return sqlSession.selectList("goods.getInfacePurchaseList", buyerId);
    }

    public List<MyGoodsListDto> getOnSaleList(String userId) {	//10P 판매중 + 예약중 불러오기
        return sqlSession.selectList("goods.getOnSaleList", userId);
    }

    public List<MyGoodsListDto> getSoldOutList(String userId) {	//10P 거래완료 판매내역 가지고오기
        return sqlSession.selectList("goods.getSoldOutList", userId);
    }

    public List<MyGoodsListDto> getHideList(String userId) {	//10P 숨김중인 판매내역 가져오기
        return sqlSession.selectList("goods.getHideList", userId);
    }

    public int insertWishList(Map<String,String> map) {	//23P 찜하기
    	return sqlSession.insert("goods.insertWishList",map);
    }

    public UserProfileDto getProfile(String userId) {	//프로필을 가져올때 유저주소 전부를 가져옴
        return sqlSession.selectOne("goods.getProfile", userId);
    }

    public List<UserAddressDto> getAddress(String userId) {	//사용자 주소를 가져
        return sqlSession.selectList("goods.getAddress", userId);
    }

    public int updateMainAddressNo(String userId) {	//대표주소를 변경하기위해 주소순서를 하나씩 뒤로 민다
    	return sqlSession.update("goods.updateMainAddressNo", userId);
    }

    public int updateMainAddress(Map<String, String> map) {	//주소순서를 1로 바꿈으로써 대표주소 변경
    	return sqlSession.update("goods.updateMainAddress", map);
    }

    public int insertAddress(UserInsertAddressDto addressDto) {	//새로입력된 주소를 count+1 주소순서에 추가한다
    	return sqlSession.insert("goods.insertAddress", addressDto);
    }

    public int deleteAddress1(int postCode) {	//주소삭제 1단계 작업
    	return sqlSession.delete("goods.deleteAddress1", postCode);
    }
    
    //2단계 추후 추가예정 mapper파일에서 오류나서 주석처리해놓음.

    public int checkNickname(String nickname) {	// 7P 닉네임 중복검사
        return sqlSession.selectOne("goods.checkNickname", nickname);
    }

    public int checkEmail(String email) {	//7P 이메일 중복검사
        return sqlSession.selectOne("goods.checkEmail", email);
    }

    public String checkPass(String userId) {	//8P 패스워드를 가져온다 (패스워드 변경또는 로그인시 사용)
        return sqlSession.selectOne("goods.checkPass", userId);
    }

    public int updateInviteCount(String userId) {	//8P 로그인시 방문횟수 + 1
    	return sqlSession.update("goods.updateInviteCount", userId);
    }

    public int updatePass(Map<String, Object> map) {	//8P 패스워드를 변경한다
    	return sqlSession.update("goods.updatePass", map);
    }

    public int checkId(String userId) {	//아이디 중복검사
        return sqlSession.selectOne("goods.checkId", userId);
    }

    public int checkMobileNumber(String mobileNumber) {	//7P 전화번호 중복검사
        return sqlSession.selectOne("goods.checkMobileNumber", mobileNumber);
    }

    public int signup(UserDto userDto) {	//회원가입
    	int result = 0;
    	result = sqlSession.insert("user.signup", userDto);
    	result = sqlSession.insert("user.insertAddress", userDto);
    	return result;
    }

    public SafePurchaseInfoDto getSafePurchaseInfo(int transactionId) {	//11P 안전거래 상세정보 가져오기
        return sqlSession.selectOne("goods.getSafePurchaseInfo", transactionId);
    }

    public int acceptSafeTrading(int transactionId) {	//12P 안전거래 수락, 상품준비중으로 거래상태 업데이트
    	return sqlSession.update("goods.acceptSafeTrading", transactionId);
    }

    public int updateTrackingNumber(Map<String, Object> map) {	//12P 안전거래번호와 운송장번호를 인자로하여, 운송장번호와 거래상태 업데이트
    	return sqlSession.update("goods.updateTrackingNumber", map);
    }

    public String findId(Map<String, String> map) {	//15P 아이디 찾기
        return sqlSession.selectOne("goods.findId", map);
    }

    public int findPass(Map<String, String> map) {	//16P 비밀번호변경
    	return sqlSession.update("goods.findPass", map);
    }

    public int addAccount(Map<String, String> map) {	//계좌등록
    	return sqlSession.insert("goods.addAccount", map);
    }
    
    public int updateRole(String userId) {
    	return sqlSession.update("user.addFavoriteUser",userId);	// 유저 안전거래 가능여부 가능변경
    }

    public int addFavoriteUser(Map<String, String> map) {	//유저 즐겨찾기(모아보기) 23P
    	return sqlSession.insert("goods.addFavoriteUser", map);
    }

    public int addDealReview(DealReviewDto dealReviewDto) {	//거래후기넣기 아직 화면설계없음.
    	return sqlSession.insert("goods.addDealReview", dealReviewDto);
    }

    public int updateRatingScore(Map<String, String> map) {	// trade-mapper의 거래후기에따른 매너온도 업데이트
    	return sqlSession.update("goods.updateRatingScore", map);
    }
}
