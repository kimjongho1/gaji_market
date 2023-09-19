package kh.spring.gaji.pay.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.trade.model.domain.SafePurchaseInfoDomain;
import kh.spring.gaji.trade.model.dto.DealReviewDto;
import kh.spring.gaji.trade.model.dto.InFaceTradingDto;
import kh.spring.gaji.trade.model.dto.SafeTradingDto;

@Repository
public class PayDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int cancelSafeTrading(int transactironId) {
		return sqlSession.update("trade.cancelSafeTrding",transactironId);
	} //11P 안전거래 취소
	
	public int acceptSafeTrading(int transactironId) {
		return sqlSession.update("trade.acceptSafeTrading",transactironId);
	}; //11P 안전거래 수락 거래상태 상품준비중
	
	public int updateTrackingNumber(Map<String,String> map) {
		return sqlSession.update("trade.updateTrackingNumber",map);
	}; //운송장번호 업데이트
	
	public int closeSafeTrading(int transactionId) {
		return sqlSession.update("trade.closeSafeTrading",transactionId);
	}; //안전결제 확정
	
	public SafePurchaseInfoDomain getSafePurchaseInfo(String transactionId) {
		return sqlSession.selectOne("trade.getSafePurchaseInfo",transactionId);
	};	// 안전거래 상세정보
	
	public List<SafeTradingDto> getSafePurchaseList(String buyerId){
		return sqlSession.selectList("trade.getInfacePurchaseList",buyerId);
	};	// 안전거래 리스트
	
	public int addSafeTrading(SafeTradingDto safeTradingInfo) {
		return sqlSession.insert("trade.addSafeTrading",safeTradingInfo);
	}; // 안전결제 추가
	
	public List<InFaceTradingDto> getInfacePurchaseList(String buyerId){
		return sqlSession.selectList("trade.getInfacePurchaseList",buyerId); 
	};  //직거래 구매기록
	
	public int addDealReview(DealReviewDto dealReviewDto) {
		return sqlSession.insert("trade.addDealReview",dealReviewDto);
	}	//거래후기 작성
	
	public int updateRatingScore(String userId) {
		return sqlSession.update("user.updateRatingScore",userId);	
		//거래온도 업데이트.
	}
}
