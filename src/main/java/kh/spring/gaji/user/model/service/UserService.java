package kh.spring.gaji.user.model.service;

import java.util.List;

import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;

public interface UserService {
    UserDto getProfile(String userId);

    List<UserAddressDto> getAddress(String userId);

    int updateMainAddressNo(String userId);

    int updateMainAddress(String userId, int addressNo);

    int insertAddress(UserInsertAddressDto userAddressDomain);

    int deleteAddress1(int postCode);
    
    public int deleteAddress2(int postCode);

    int checkNickname(String nickname);

    int checkEmail(String email);

    String checkPass(String userId);

    int updateInviteCount(String userId);

    int updatePass(String userId, String password);

    int checkId(String userId);

    int checkMobileNumber(String mobileNumber);

    int signup(UserDto userDto);

    String findId(String name, String email);

    int findPass(String userId, String name, String email);

    int addAccount(String userAccount, String userId);

    int addFavoriteUser(String userId, String targetId);

    int addDealReview(DealReviewDto dealReviewDto);

    int updateRatingScore(String userId, int mannerPoint, int timePoint, int goodsPoint);
}
