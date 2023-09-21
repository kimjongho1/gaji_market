package kh.spring.gaji.user.model.service;
import java.util.List;
import java.util.Map;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;

public interface UserService {

    List<GoodsDto> getKeepList(String userId);

    int updateViewCount();

    List<GoodsDto> getFavoriteList(String userId);

    List<SafeTradingDto> getSafePurchaseList(String buyerId);

    List<InFaceTradingDto> getInfacePurchaseList(String buyerId);

    List<GoodsDto> getOnSaleList(String userId);

    List<GoodsDto> getSoldOutList(String userId);

    List<GoodsDto> getHideList(String userId);

    int insertWishList(Map<String, String> map);

    List<UserDto> getProfile(String userId);

    List<UserAddressDto> getAddress(String userId);

    int updateMainAddressNo(String userId);

    int updateMainAddress(Map<String, String> map);

    int insertAddress(UserInsertAddressDto addressDto);

    int deleteAddress1(int postCode);

    int checkNickname(String nickname);

    int checkEmail(String email);

    String checkPass(String userId);

    int updateInviteCount(String userId);

    int updatePass(Map<String, Object> map);

    int checkId(String userId);

    int checkMobileNumber(String mobileNumber);

    int signup(UserDto userDto);

    SafePurchaseInfoDto getSafePurchaseInfo(int transactionId);

    int acceptSafeTrading(int transactionId);

    int updateTrackingNumber(Map<String, Object> map);

    String findId(Map<String, String> map);

    int findPass(Map<String, String> map);

    int addAccount(Map<String, String> map);

    int addFavoriteUser(Map<String, String> map);

    int addDealReview(DealReviewDto dealReviewDto);

    int updateRatingScore(Map<String, String> map);
}
