package kh.spring.gaji.pay.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;

@Repository
public class PayDao {
    @Autowired
    private SqlSession sqlSession;

    public int cancelSafeTrading(int transactionId) {	//거래취소
        return sqlSession.update("pay.cancelSafeTrading", transactionId);
    }

    public int closeSafeTrading(int transactionId) {	//거래확정
        return sqlSession.update("pay.closeSafeTrading", transactionId);
    }

    public int addSafeTrading(InsertSafeTradingDto insertSafeTradingDto) {	//안전거래 생성 
        return sqlSession.insert("pay.addSafeTrading", insertSafeTradingDto);
    }
}
