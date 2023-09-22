package kh.spring.gaji.pay.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.pay.model.dao.PayDao;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDao payDao;

    @Override
    public int cancelSafeTrading(int transactionId) {
        return payDao.cancelSafeTrading(transactionId);
    }
    
    @Override
    public int closeSafeTrading(int transactionId) {
        return payDao.closeSafeTrading(transactionId);
    }
    
    @Override
    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto) {
        return payDao.addSafeTrading(insertSafeTradingDto);
    }
}