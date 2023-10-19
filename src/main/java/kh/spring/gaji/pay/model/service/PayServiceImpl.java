package kh.spring.gaji.pay.model.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.pay.model.dao.PayDao;
import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;

@Service
@Transactional
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDao payDao;
    
	@Override
	public int checkGoodsStatus(int goodsId) {
		return payDao.checkGoodsStatus(goodsId);
	}
  
	
    @Override
    public int cancelSafeTrading(String transactionId) {
        return payDao.cancelSafeTrading(transactionId);
    }
    
    @Override
    public int closeSafeTrading(String transactionId,String userId) {
        return payDao.closeSafeTrading(transactionId,userId);
    }
    
    @Override
    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto) {
 
        return payDao.addSafeTrading(insertSafeTradingDto);
    }
    
	@Override
    public int getAmount(int goodsId) {	// 결제시 가격확인을 위한 함수
    	return payDao.getAmount(goodsId);
    }
	
	public GoodsPayInfoDto getGoodsInfo(int goodsId) {
		return payDao.getGoodsInfo(goodsId);
	}
	
	public List<UserAddressDto> getUserAddressList(String userId){
		return payDao.getUserAddressList(userId);
	}
	
	 public PayUserInfoDto getUserInfo(String userId) {
		 return payDao.getUserInfo(userId);
	 }

	@Override
	public int updateStatus(Map<String, Object> map) {
		return payDao.updateStatus(map);
	}


	@Override
	public int changeStatus(Map<String, Object> map) {
		return payDao.changeStatus(map);
	}


	@Override
	public String checkId(String transactionId) {
		return payDao.checkId(transactionId);
	}


	@Override
	public int getGoodsId(String transactionId) {
		return payDao.getGoodsId(transactionId);
	}


	@Override
	public String checkIdForPay(int goodsId) {
		return payDao.checkIdForPay(goodsId);
	}

}