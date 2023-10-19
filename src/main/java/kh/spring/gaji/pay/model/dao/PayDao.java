package kh.spring.gaji.pay.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.notification.model.dto.InsertNotificationDto;
import kh.spring.gaji.notification.model.dto.TitleBuyerDto;
import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;

@Repository
public class PayDao {
    @Autowired
    private SqlSession sqlSession;
    
    public int getGoodsId(String transactionId) {
    	return sqlSession.selectOne("pay.getGoodsId",transactionId);
    }
    
    public int checkGoodsStatus(int goodsId) {	//판매중 상품인지를 확인함.
    	return sqlSession.selectOne("pay.checkGoodsStatus",goodsId);
    }
    
    public int changeStatus(Map<String,Object> map) {
    	return sqlSession.update("pay.changeStatus",map);
    }
    
    public int cancelSafeTrading(String transactionId) {	//거래취소
        return sqlSession.update("pay.cancelSafeTrading", transactionId);
    }
    
    public int updateStatus(Map<String, Object> map) { //23P 상품상태변경 
        return sqlSession.update("pay.updateStatus", map);
    }
    
    public int updateGoodsToSelling(int goodsId) {
    	return sqlSession.update("pay.updateGoodsToSelling",goodsId);
    }

    public int closeSafeTrading(String transactionId,String userId) {	//거래확정
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("transactionId", transactionId);
     	map.put("userId", userId);
        return sqlSession.update("pay.closeSafeTrading", map);
    }

    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto) {	//안전거래 생성 
        return sqlSession.insert("pay.addSafeTrading", insertSafeTradingDto);
    }
    
    public int getAmount(int goodsId) {	// 결제시 가격확인을 위한 함수
    	return sqlSession.selectOne("pay.getAmount",goodsId);
    }
    
    
    public GoodsPayInfoDto getGoodsInfo(int goodsId) {	//결제시 상품정보 가져오기
    	return sqlSession.selectOne("pay.getGoodsInfo",goodsId);
    }
    
    public List<UserAddressDto> getUserAddressList(String userId) {	//결제시 구매자 주소가져오기
    	return sqlSession.selectList("pay.getUserAddressList",userId);
    }
    
    public PayUserInfoDto getUserInfo(String userId) {
    	return sqlSession.selectOne("pay.getUserInfo",userId);
    }
    
    public String checkIdForPay(int goodsId) {
		return sqlSession.selectOne("pay.checkIdForPay",goodsId);
	}
    
    public TitleBuyerDto getBuyerIdFromTransactionId(String transactionId) {
    	return sqlSession.selectOne("pay.getIdFromTransactionId",transactionId);
    }
    public int insertNoti(InsertNotificationDto insertNotificationDto) {
    	return sqlSession.insert("notification.insertNoti",insertNotificationDto);
    }
    public int insertSellerNoti(InsertNotificationDto insertNotificationDto) {
    	return sqlSession.insert("notification.insertSellerNoti",insertNotificationDto);
    }
}
