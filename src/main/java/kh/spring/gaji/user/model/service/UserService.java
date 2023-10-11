package kh.spring.gaji.user.model.service;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kh.spring.gaji.goods.model.dto.GoodsListDto;
import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;
import kh.spring.gaji.user.model.dto.UserProfileDto;


public interface UserService {

    public List<GoodsListDto> getKeepList(String userId);

    public int updateViewCount();

    public List<GoodsListDto> getFavoriteList(String userId);

    public String checkIdForSafe(String transactionId);
    
    public String checkIdForSafeSeller(String transactionId);
    
    public int checkTradingStatus(String transactionId,String userId);
    
    public int doDealreview(DealReviewDto dealReviewDto,String trasactionId);
    
    public Map<String,Object> getSafePurchaseList(String buyerId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchSafePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getSellerSafePurchaseList(String buyerId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchSellerSafePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord);

    public Map<String,Object> getInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getSellerInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchSellerInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord);


    public Map<String,Object> getOnSaleList(String userId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchOnSaleList(String userId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getKeepUsedList(String userId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchKeepUsedList(String userId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getKeepUsersList(String userId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchKeepUsersList(String userId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getClosedList(String userId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchClosedList(String userId,int currentPage,int PAGESIZE,String searchWord);
    
    public Map<String,Object> getHideList(String userId,int currentPage,int PAGESIZE);
    
    public Map<String,Object> getSearchHideList(String userId,int currentPage,int PAGESIZE,String searchWord);

    public List<MyGoodsListDto> getSoldOutList(String userId);

    public List<MyGoodsListDto> getHideList(String userId);

    public int insertWishList(Map<String, String> map);

    public UserProfileDto getProfile(String userId);

    public List<UserAddressDto> getAddress(String userId);

    public int updateMainAddressNo(String userId);

    public int updateMainAddress(Map<String, Object> map);

    public int insertAddress(UserInsertAddressDto addressDto);

    public int deleteAddress1(Map<String,Object> map);

    public String checkNickname(String nickname);

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
}
