package kh.spring.gaji.pay.model.service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.pay.model.dao.PayDao;
import kh.spring.gaji.trade.model.domain.SafePurchaseInfoDomain;
import kh.spring.gaji.trade.model.dto.DealReviewDto;
import kh.spring.gaji.trade.model.dto.InFaceTradingDto;
import kh.spring.gaji.trade.model.dto.SafeTradingDto;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDao payDao;
	
	@Override
	public int cancelSafeTrading(int transactironId) {
		return payDao.cancelSafeTrading(transactironId); // 11P 안전거래 결제취소
	}

	@Override
	public int acceptSafeTrading(int transactironId) {
		return payDao.acceptSafeTrading(transactironId); // 11P 안전거래 수락
	}

	@Override
	public int updateTrackingNumber(Map<String, String> map) { // 안전거래번호와 운송장번호를 인자로하여, 운송장번호와 거래상태 업데이트
		return payDao.updateTrackingNumber(map);
	}

	@Override
	public int closeSafeTrading(int transactionId) {	// 11P 거래확정, 거래상태 업데이트
		return payDao.closeSafeTrading(transactionId);
	}

	@Override
	public SafePurchaseInfoDomain getSafePurchaseInfo(String transactionId) {	// 11P 안전거래 상세정보 가져오기 
		return payDao.getSafePurchaseInfo(transactionId);
	}

	@Override
	public List<SafeTradingDto> getSafePurchaseList(String buyerId) {	// 9P 안전거래 구매내역(회원) 불러오기
		return payDao.getSafePurchaseList(buyerId);
	}

	@Override
	public int addSafeTrading(SafeTradingDto safeTradingInfo) {		// 49P 새로운 안전결제 레코드 생성
		return payDao.addSafeTrading(safeTradingInfo);
	}

	@Override
	public List<InFaceTradingDto> getInfacePurchaseList(String buyerId) {	// 9P 직거래 구매내역(회원) 불러오기
		return getInfacePurchaseList(buyerId);
	}
	
}


/*
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import kh.project.dml.admin.model.dao.FpAdminDao; import
 * kh.project.dml.admin.model.vo.FpAdminVo;
 * 
 * @Service("fpAdminServiceImpl") public class FpAdminServiceImpl implements
 * FpAdminService {
 * 
 * @Autowired private FpAdminDao fpAdminDao;
 * 
 * @Override public List<FpAdminVo> selectList() { return
 * fpAdminDao.selectList(); }
 * 
 * @Override public FpAdminVo selectOne(String adminId) { return
 * fpAdminDao.selectOne(adminId); }
 * 
 * @Override public int insert(FpAdminVo vo) { return fpAdminDao.insert(vo); }
 * 
 * @Override public int update(FpAdminVo vo) { return fpAdminDao.update(vo); }
 * 
 * @Override public int delete(String adminId) { return
 * fpAdminDao.delete(adminId); } }
 */