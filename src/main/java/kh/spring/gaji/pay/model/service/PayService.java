package kh.spring.gaji.pay.model.service;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;


public interface PayService {
    int cancelSafeTrading(int transactionId);
    int closeSafeTrading(int transactionId);
    int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto);
    public int getAmount(int goodsId);
}
