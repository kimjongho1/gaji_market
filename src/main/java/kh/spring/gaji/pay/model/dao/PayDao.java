package kh.spring.gaji.pay.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PayDao {
    @Autowired
    private SqlSession sqlSession;

    public int cancelSafeTrading(int transactionId) {
        return sqlSession.update("pay.cancelSafeTrading", transactionId);
    }

    public int closeSafeTrading(int transactionId) {
        return sqlSession.update("pay.closeSafeTrading", transactionId);
    }

    public int addSafeTrading(SafeTradingDto safeTradingDto) {
        return sqlSession.insert("pay.addSafeTrading", safeTradingDto);
    }
}
