package kh.spring.gaji.user.model.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.user.model.dao.UserDao;
import kh.spring.gaji.user.model.domain.UserAddressDomain;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getProfile(String userId) {
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
    public int updateMainAddress(String userId, int addressNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("addressNo", addressNo);
        return userDao.updateMainAddress(map);
    }

    @Override
    public int insertAddress(UserAddressDomain userAddressDomain) {
    	return userDao.insertAddress(userAddressDomain);
    }

    @Override
    public int deleteAddress1(int postCode) {
    	return userDao.deleteAddress1(postCode);
    }
    public int deleteAddress2(int postCode) {
        return userDao.deleteAddress2(postCode);
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
    public int updatePass(String userId, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
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
    public String findId(String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
        return userDao.findId(map);
    }

    @Override
    public int findPass(String userId, String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("name", name);
        map.put("email", email);
        return userDao.findPass(map);
    }

    @Override
    public int addAccount(String userAccount, String userId) {
    	return userDao.addAccount(userAccount, userId);
    }

    @Override
    public int addFavoriteUser(String userId, String targetId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("targetId", targetId);
        return userDao.addFavoriteUser(map);
    }

    @Override
    public int addDealReview(DealReviewDto dealReviewDto) {
    	return userDao.addDealReview(dealReviewDto);
    }

    @Override
    public int updateRatingScore(String userId, int mannerPoint, int timePoint, int goodsPoint) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("mannerPoint", mannerPoint);
        map.put("timePoint", timePoint);
        map.put("goodsPoint", goodsPoint);
        return userDao.updateRatingScore(map);
    }
}
