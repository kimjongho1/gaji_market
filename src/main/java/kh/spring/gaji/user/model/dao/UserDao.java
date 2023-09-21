package kh.spring.gaji.user.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public List<GoodsDto> getKeepList(String userId) {
        return sqlSession.selectList("goods.getKeepList", userId);
    }

    public int updateViewCount() {
        return sqlSession.update("goods.updateViewCount");
    }

    public List<GoodsDto> getFavoriteList(String userId) {
        return sqlSession.selectList("goods.getFavoriteList", userId);
    }

    public List<SafeTradingDto> getSafePurchaseList(String buyerId) {
        return sqlSession.selectList("goods.getSafePurchaseList", buyerId);
    }

    public List<InFaceTradingDto> getInfacePurchaseList(String buyerId) {
        return sqlSession.selectList("goods.getInfacePurchaseList", buyerId);
    }

    public List<GoodsDto> getOnSaleList(String userId) {
        return sqlSession.selectList("goods.getOnSaleList", userId);
    }

    public List<GoodsDto> getSoldOutList(String userId) {
        return sqlSession.selectList("goods.getSoldOutList", userId);
    }

    public List<GoodsDto> getHideList(String userId) {
        return sqlSession.selectList("goods.getHideList", userId);
    }

    public int insertWishList(Map<String, String> map) {
    	return sqlSession.insert("goods.insertWishList",map);
    }

    public List<UserDto> getProfile(String userId) {
        return sqlSession.selectList("goods.getProfile", userId);
    }

    public List<UserAddressDto> getAddress(String userId) {
        return sqlSession.selectList("goods.getAddress", userId);
    }

    public int updateMainAddressNo(String userId) {
    	return sqlSession.update("goods.updateMainAddressNo", userId);
    }

    public int updateMainAddress(Map<String, String> map) {
    	return sqlSession.update("goods.updateMainAddress", map);
    }

    public int insertAddress(UserInsertAddressDto addressDto) {
    	return sqlSession.insert("goods.insertAddress", addressDto);
    }

    public int deleteAddress1(int postCode) {
    	return sqlSession.delete("goods.deleteAddress1", postCode);
    }

    public int checkNickname(String nickname) {
        return sqlSession.selectOne("goods.checkNickname", nickname);
    }

    public int checkEmail(String email) {
        return sqlSession.selectOne("goods.checkEmail", email);
    }

    public String checkPass(String userId) {
        return sqlSession.selectOne("goods.checkPass", userId);
    }

    public int updateInviteCount(String userId) {
    	return sqlSession.update("goods.updateInviteCount", userId);
    }

    public int updatePass(Map<String, Object> map) {
    	return sqlSession.update("goods.updatePass", map);
    }

    public int checkId(String userId) {
        return sqlSession.selectOne("goods.checkId", userId);
    }

    public int checkMobileNumber(String mobileNumber) {
        return sqlSession.selectOne("goods.checkMobileNumber", mobileNumber);
    }

    public int signup(UserDto userDto) {
    	return sqlSession.insert("goods.signup", userDto);
    }

    public SafePurchaseInfoDto getSafePurchaseInfo(int transactionId) {
        return sqlSession.selectOne("goods.getSafePurchaseInfo", transactionId);
    }

    public int acceptSafeTrading(int transactionId) {
    	return sqlSession.update("goods.acceptSafeTrading", transactionId);
    }

    public int updateTrackingNumber(Map<String, Object> map) {
    	return sqlSession.update("goods.updateTrackingNumber", map);
    }

    public String findId(Map<String, String> map) {
        return sqlSession.selectOne("goods.findId", map);
    }

    public int findPass(Map<String, String> map) {
    	return sqlSession.update("goods.findPass", map);
    }

    public int addAccount(Map<String, String> map) {
    	return sqlSession.insert("goods.addAccount", map);
    }

    public int addFavoriteUser(Map<String, String> map) {
    	return sqlSession.insert("goods.addFavoriteUser", map);
    }

    public int addDealReview(DealReviewDto dealReviewDto) {
    	return sqlSession.insert("goods.addDealReview", dealReviewDto);
    }

    public int updateRatingScore(Map<String, String> map) {
    	return sqlSession.update("goods.updateRatingScore", map);
    }
}
