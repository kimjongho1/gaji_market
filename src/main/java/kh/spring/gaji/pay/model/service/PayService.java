package kh.spring.gaji.pay.model.service;
import java.util.List;
import java.util.Map;

import kh.spring.gaji.notification.model.dto.InsertNotificationDto;
import kh.spring.gaji.notification.model.dto.TitleBuyerDto;
import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;


public interface PayService {
	public int checkGoodsStatus(int goodsId);
	public int cancelSafeTrading(String transactionId);
    public int closeSafeTrading(String transactionId,String userId);
    int updateStatus(Map<String, Object> map);
	public int getGoodsId(String transactionId);
    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto);
    public int getAmount(int goodsId);
    public GoodsPayInfoDto getGoodsInfo(int goodsId);
    public List<UserAddressDto> getUserAddressList(String userId);
    public PayUserInfoDto getUserInfo(String userId);
    public int changeStatus(Map<String,Object> map);
    public String checkIdForPay(int goodsId);
    public TitleBuyerDto getBuyerIdFromTransactionId(String transactionId);
    public int insertNoti(InsertNotificationDto insertNotificationDto);
}
