package kh.spring.gaji.user.model.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;
import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dao.UserDao;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;
import kh.spring.gaji.user.model.dto.UserProfileDto;
import kh.spring.gaji.user.model.dto.UserSafeTradingDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<GoodsListDto> getKeepList(String userId) {
        return userDao.getKeepList(userId);
    }

    @Override
    public int updateViewCount() {
        return userDao.updateViewCount();
    }

    @Override
    public List<GoodsListDto> getFavoriteList(String userId) {
        return userDao.getFavoriteList(userId);
    }

    @Override
    public Map<String,Object> getSafePurchaseList(String buyerId,int currentPage,int PAGESIZE) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt=userDao.getSafeTotalCnt(buyerId);
    	result.put("totalCnt",totalCnt);
    	result.put("safePurchaseList",userDao.getSafePurchaseList(buyerId,currentPage,PAGESIZE,totalCnt));
        return result;
    }

    @Override
    public Map<String,Object> getSearchSafePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt=userDao.getSearchSafeTotalCnt(buyerId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("safePurchaseList",userDao.getSafePurchaseList(buyerId,currentPage,PAGESIZE,totalCnt));
        return result;
    }
    
    @Override
    public Map<String,Object> getSellerSafePurchaseList(String userId,int currentPage,int PAGESIZE) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt=userDao.getSellerSafeTotalCnt(userId);
    	result.put("totalCnt",totalCnt);
    	result.put("safePurchaseList",userDao.getSellerSafePurchaseList(userId,currentPage,PAGESIZE,totalCnt));
        return result;
    }

    @Override
    public Map<String,Object> getSearchSellerSafePurchaseList(String userId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt=userDao.getSearchSellerSafeTotalCnt(userId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("safePurchaseList",userDao.getSearchSellerSafePurchaseList(userId,currentPage,PAGESIZE,searchWord,totalCnt));
        return result;
    }
    
    @Override
    public Map<String,Object> getInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getInfaceTotalCnt(buyerId);
    	result.put("totalCnt",totalCnt);
    	result.put("inFacePurchaseList",userDao.getInfacePurchaseList(buyerId,currentPage,PAGESIZE,totalCnt));
        return result;
    }
    @Override
    public Map<String,Object> getSearchInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSearchInfaceTotalCnt(buyerId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("inFacePurchaseList",userDao.getSearchInfacePurchaseList(buyerId,currentPage,PAGESIZE,totalCnt,searchWord));
    	return result;
    }
    
    @Override
    public Map<String,Object> getSellerInfacePurchaseList(String userId,int currentPage,int PAGESIZE) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSellerInfaceTotalCnt(userId);
    	result.put("totalCnt",totalCnt);
    	result.put("inFacePurchaseList",userDao.getSellerInfacePurchaseList(userId,currentPage,PAGESIZE,totalCnt));
        return result;
    }
    
    @Override
    public Map<String,Object> getSearchSellerInfacePurchaseList(String userId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSearchSellerInfaceTotalCnt(userId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("inFacePurchaseList",userDao.getSearchSellerInfacePurchaseList(userId,currentPage,PAGESIZE,totalCnt,searchWord));
    	return result;
    }
    @Override
    public Map<String,Object> getOnSaleList(String userId,int currentPage,int PAGESIZE){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getOnsaleTotalCnt(userId);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getOnsaleList(userId,currentPage,PAGESIZE,totalCnt));
    	return result;
    }
    @Override
    public Map<String,Object> getSearchOnSaleList(String userId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSearchOnsaleTotalCnt(userId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getSearchOnsaleList(userId,currentPage,PAGESIZE,totalCnt,searchWord));
    	return result;
    }
    
    @Override
    public Map<String,Object> getClosedList(String userId,int currentPage,int PAGESIZE){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getClosedTotalCnt(userId);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getClosedList(userId,currentPage,PAGESIZE,totalCnt));
    	return result;
    }
    @Override
    public Map<String,Object> getSearchClosedList(String userId,int currentPage,int PAGESIZE,String searchWord){
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSearchClosedTotalCnt(userId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getSearchClosedList(userId,currentPage,PAGESIZE,totalCnt,searchWord));
    	return result;
    }
    
	@Override
	public Map<String, Object> getHideList(String userId, int currentPage, int PAGESIZE) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getHideTotalCnt(userId);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getHideList(userId,currentPage,PAGESIZE,totalCnt));
    	return result;
	}

	@Override
	public Map<String, Object> getSearchHideList(String userId, int currentPage, int PAGESIZE, String searchWord) {
    	Map<String,Object> result=new HashMap<String,Object>();
    	int totalCnt = userDao.getSearchHideTotalCnt(userId,searchWord);
    	result.put("totalCnt",totalCnt);
    	result.put("myGoodsList",userDao.getSearchHideList(userId,currentPage,PAGESIZE,totalCnt,searchWord));
    	return result;
	}
    
    @Override
    public List<MyGoodsListDto> getSoldOutList(String userId) {
        return userDao.getSoldOutList(userId);
    }

    @Override
    public List<MyGoodsListDto> getHideList(String userId) {
        return userDao.getHideList(userId);
    }

    @Override
    public int insertWishList(Map<String, String> map) {
        return userDao.insertWishList(map);
    }

    @Override
    public UserProfileDto getProfile(String userId) {
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
    public String checkId(String userId) {
        return userDao.checkId(userId);
    }

    @Override
    public int checkMobileNumber(String mobileNumber) {
        return userDao.checkMobileNumber(mobileNumber);
    }

    @Override
    @Transactional
    public int signup(UserDto userDto, UserInsertAddressDto addressDto) throws IOException{
    	int result = 0;
    	result = userDao.signup(userDto);
    	result += userDao.insertAddress(addressDto);		
        return result;
    }

    @Override
    public SafePurchaseInfoDto getSafePurchaseInfo(String transactionId) {
        return userDao.getSafePurchaseInfo(transactionId);
    }

    @Override
    public int acceptSafeTrading(String transactionId) {
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

	@Override
	public String checkIdForSafe(String transactionId) {
		return userDao.checkIdForSafe(transactionId);
	}

	@Override
	public String checkIdForSafeSeller(String transactionId) {
		return userDao.checkIdForSafeSeller(transactionId);
	}


}
