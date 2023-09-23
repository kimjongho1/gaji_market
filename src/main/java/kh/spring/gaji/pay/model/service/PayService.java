package kh.spring.gaji.pay.model.service;
import java.util.List;

import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;


public interface PayService {
	public int cancelSafeTrading(String transactionId);
    public int closeSafeTrading(String transactionId);
    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto);
    public int getAmount(int goodsId);
    public GoodsPayInfoDto getGoodsInfo(int goodsId);
    public List<UserAddressDto> getUserAddressList(String userId);
    public PayUserInfoDto getUserInfo(String userId);
}
