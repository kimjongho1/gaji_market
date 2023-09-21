package kh.spring.gaji.pay.model.service;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;

public interface PayService {
    int cancelSafeTrading(int transactionId);
    int closeSafeTrading(int transactionId);
    int addSafeTrading(SafeTradingDto safeTradingDto);
}
