package kh.spring.gaji.user.model.service;
import java.util.List;
import java.util.Map;

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

public interface UserService {

    List<GoodsListDto> getKeepList(String userId);

    int updateViewCount();

    List<GoodsListDto> getFavoriteList(String userId);

    List<SafeTradingDto> getSafePurchaseList(String buyerId);

    List<InFaceTradingDto> getInfacePurchaseList(String buyerId);

    List<MyGoodsListDto> getOnSaleList(String userId);

    List<MyGoodsListDto> getSoldOutList(String userId);

    List<MyGoodsListDto> getHideList(String userId);

    int insertWishList(Map<String, String> map);

    UserProfileDto getProfile(String userId);

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
