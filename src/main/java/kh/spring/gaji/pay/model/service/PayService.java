package kh.spring.gaji.pay.model.service;
import java.util.List;
import java.util.Map;

import kh.spring.gaji.pay.model.domain.SafePurchaseInfoDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingDomain;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;

public interface PayService {
	public int cancelSafeTrading(int transactironId); //11P 안전거래 취소
	public int acceptSafeTrading(int transactironId); //11P 안전거래 수락 거래상태 상품준비중
	public int updateTrackingNumber(Map<String,String> map); //운송장번호 업데이트
	public int closeSafeTrading(int transactionId); //안전결제 확정.
	public SafePurchaseInfoDomain getSafePurchaseInfo(String transactionId);	// 안전거래 상세정보
	public List<SafeTradingDto> getSafePurchaseList(String buyerId);	// 안전거래 리스트
	public int addSafeTrading(SafeTradingDto safeTradingInfo); // 안전결제 추가
	public List<InFaceTradingDto> getInfacePurchaseList(String buyerId);  //직거래 구매기록
}
