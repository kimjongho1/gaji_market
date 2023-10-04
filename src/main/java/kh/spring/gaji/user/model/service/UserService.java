package kh.spring.gaji.user.model.service;
import java.io.IOException;
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
import kh.spring.gaji.user.model.dto.UserSafeTradingDto;


public interface UserService {

    public List<GoodsListDto> getKeepList(String userId);

    public int updateViewCount();

    public List<GoodsListDto> getFavoriteList(String userId);

    public Map<String,Object> getSafePurchaseList(String buyerId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchSafePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord);

    public Map<String,Object> getInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE);

    public List<MyGoodsListDto> getOnSaleList(String userId);

    public List<MyGoodsListDto> getSoldOutList(String userId);

    public List<MyGoodsListDto> getHideList(String userId);

    public int insertWishList(Map<String, String> map);

    public UserProfileDto getProfile(String userId);

    public List<UserAddressDto> getAddress(String userId);

    public int updateMainAddressNo(String userId);

    public int updateMainAddress(Map<String, String> map);

    public int insertAddress(UserInsertAddressDto addressDto);

    public int deleteAddress1(int postCode);

    public int checkNickname(String nickname);

    public int checkEmail(String email);

    public String checkPass(String userId);

    public int updateInviteCount(String userId);

    public int updatePass(Map<String, Object> map);

    public String checkId(String userId);

    public int checkMobileNumber(String mobileNumber);

    public int signup(UserDto userDto,UserInsertAddressDto addressDto) throws IOException;

    public SafePurchaseInfoDto getSafePurchaseInfo(String transactionId);

    public int acceptSafeTrading(String transactionId);

    public int updateTrackingNumber(Map<String, Object> map);

    public String findId(Map<String, String> map);

    public int findPass(Map<String, String> map);

    public int addAccount(Map<String, String> map);

    public int addFavoriteUser(Map<String, String> map);

    public int addDealReview(DealReviewDto dealReviewDto);

    public int updateRatingScore(Map<String, String> map);
}
