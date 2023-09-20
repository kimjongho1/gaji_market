package kh.spring.gaji.administer.model.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.domain.InFacePurchaseDomain;
import kh.spring.gaji.pay.model.domain.InFaceTradingInfoDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingInfoDomain;
import kh.spring.gaji.user.model.domain.UserCountReportDomain;
import kh.spring.gaji.user.model.domain.UserInfoDomain;

@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<InFacePurchaseDomain> InFacePurchaseDomain() {	//33P 직거래 조회 
		return sqlSession.selectList("admin.getetInfacePurchaseList");
	}
	
	public List<InFacePurchaseDomain> getSearchTitleInfacePurchaseList(String searchWord) {	//33P 직거래 조회 상품명
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchTitleInfacePurchaseList",searchWord);
	}
	
	public List<InFacePurchaseDomain> getSearchIdInfacePurchaseList(String searchWord) {	//33P 직거래 조회 상품ID
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchIdInfacePurchaseList",searchWord);
	}
	
	public List<InFacePurchaseDomain> getSearchUserInfacePurchaseList(String searchWord) {	//33P 직거래 조회 회원ID 
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchUserInfacePurchaseList",searchWord);
	}
	
	public InFaceTradingInfoDomain getInfaceTradingInfo(int inFaceTradingId) {	//34P 관리자 직거래 세부조회
		return sqlSession.selectOne("admin.getInfaceTradingInfo",inFaceTradingId);
	}
	
	public List<SafeTradingDomain> getSafeTradingList() {	//35P 안전거래조회(관리자)
		return sqlSession.selectList("admin.getSafeTradingList");
	}
	
	public List<SafeTradingDomain> getSearchSafeTradingList(String searchWord) {	//35P 안전거래 조회 검색(안전거래번호)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchSafeTradingList",searchWord);
	}
	
	public List<SafeTradingDomain> getIdSearchSafeTradingList(String searchWord) { // 35P 안전거래조회 검색(판매자ID)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getIdSearchSafeTradingList",searchWord);
	}
	
	public List<SafeTradingDomain> getGoodsSearchSafeTradingList(String searchWord) {	//35P 안전거래조회 검색(상품명)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getGoodsSearchSafeTradingList",searchWord);
	}
	
	public SafeTradingInfoDomain getSafeTradingInfo(String searchWold) {	//36P 안전거래 세부조회(관리자)
		return sqlSession.selectOne("admin.getGoodsSearchSafeTradingList",searchWold);
	}
	
	// 회원정보조회 LIST
	public List<UserCountReportDomain> getUserList() {
	    return sqlSession.selectList("user.getUserList");
	}

	// 회원정보조회 LIST 신고상위
	public List<UserCountReportDomain> getTopReportUserList() {
	    return sqlSession.selectList("user.getTopReportUserList");
	}

	// 신고상위 ID검색 회원정보조회 LIST
	public List<UserCountReportDomain> getSearchIdTopReportUserList(String searchWord) {
	    return sqlSession.selectList("user.getSearchIdTopReportUserList", searchWord);
	}

	// 거래상위 회원정보조회 LIST
	public List<UserCountReportDomain> getTopTradeUserList(String searchWord) {
	    return sqlSession.selectList("user.getTopTradeUserList", searchWord);
	}

	// 거래상위 ID검색 회원정보조회 LIST
	public List<UserCountReportDomain> getSearchIdTopTradeUserList(String searchWord) {
	    return sqlSession.selectList("user.getSearchIdTopTradeUserList", searchWord);
	}
	
	public UserInfoDomain getUserInfo(String userId) {	// 38P 회원정보 세부조회
		return sqlSession.selectOne("admin.getUserInfo");
	}
	public int banUser(String userId) {
		return sqlSession.update("admin.banUser",userId);	// 38P 유저 계정 정지
	}
	public int unBanUser(String userId) {
		return sqlSession.update("admin.unBanUser",userId);	// 38P 유저 계정 정지 해제
	} 
	public int insertBanUser(UserBlockingDto userBlockingDto) {	// 38P 계정정지 테이블에 아이디추가
		return sqlSession.insert("admin.insertBanUser",userBlockingDto);
	}
}
