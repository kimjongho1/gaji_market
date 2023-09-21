package kh.spring.gaji.user.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dao.UserDao;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<GoodsDto> getKeepList(String userId) {
        return userDao.getKeepList(userId);
    }

    @Override
    public int updateViewCount() {
        return userDao.updateViewCount();
    }

    @Override
    public List<GoodsDto> getFavoriteList(String userId) {
        return userDao.getFavoriteList(userId);
    }

    @Override
    public List<SafeTradingDto> getSafePurchaseList(String buyerId) {
        return userDao.getSafePurchaseList(buyerId);
    }

    @Override
    public List<InFaceTradingDto> getInfacePurchaseList(String buyerId) {
        return userDao.getInfacePurchaseList(buyerId);
    }

    @Override
    public List<GoodsDto> getOnSaleList(String userId) {
        return userDao.getOnSaleList(userId);
    }

    @Override
    public List<GoodsDto> getSoldOutList(String userId) {
        return userDao.getSoldOutList(userId);
    }

    @Override
    public List<GoodsDto> getHideList(String userId) {
        return userDao.getHideList(userId);
    }

    @Override
    public int insertWishList(Map<String, String> map) {
        return userDao.insertWishList(map);
    }

    @Override
    public List<UserDto> getProfile(String userId) {
        return userDao.getProfile(userId);
    }

    @Override
    public List<UserAddressDto> getAddress(String userId) {
        return userDao.getAddress(userId);
    }

    @Override
    public int updateMainAddressNo(String userId) {
        return userDao.updateMainAddressNo(userId);
    }

    @Override
    public int updateMainAddress(Map<String, String> map) {
        return userDao.updateMainAddress(map);
    }

    @Override
    public int insertAddress(UserInsertAddressDto addressDto) {
        return userDao.insertAddress(addressDto);
    }

    @Override
    public int deleteAddress1(int postCode) {
        return userDao.deleteAddress1(postCode);
    }

    @Override
    public int checkNickname(String nickname) {
        return userDao.checkNickname(nickname);
    }

    @Override
    public int checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    @Override
    public String checkPass(String userId) {
        return userDao.checkPass(userId);
    }

    @Override
    public int updateInviteCount(String userId) {
        return userDao.updateInviteCount(userId);
    }

    @Override
    public int updatePass(Map<String, Object> map) {
        return userDao.updatePass(map);
    }

    @Override
    public int checkId(String userId) {
        return userDao.checkId(userId);
    }

    @Override
    public int checkMobileNumber(String mobileNumber) {
        return userDao.checkMobileNumber(mobileNumber);
    }

    @Override
    public int signup(UserDto userDto) {
        return userDao.signup(userDto);
    }

    @Override
    public SafePurchaseInfoDto getSafePurchaseInfo(int transactionId) {
        return userDao.getSafePurchaseInfo(transactionId);
    }

    @Override
    public int acceptSafeTrading(int transactionId) {
        return userDao.acceptSafeTrading(transactionId);
    }

    @Override
    public int updateTrackingNumber(Map<String, Object> map) {
        return userDao.updateTrackingNumber(map);
    }

    @Override
    public String findId(Map<String, String> map) {
        return userDao.findId(map);
    }

    @Override
    public int findPass(Map<String, String> map) {
        return userDao.findPass(map);
    }

    @Override
    public int addAccount(Map<String, String> map) {
        return userDao.addAccount(map);
    }

    @Override
    public int addFavoriteUser(Map<String, String> map) {
        return userDao.addFavoriteUser(map);
    }

    @Override
    public int addDealReview(DealReviewDto dealReviewDto) {
        return userDao.addDealReview(dealReviewDto);
    }
    @Override
    public int updateRatingScore(Map<String, String> map) {
        return userDao.updateRatingScore(map);
    }
}
