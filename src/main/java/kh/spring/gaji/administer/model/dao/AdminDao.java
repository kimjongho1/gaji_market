package kh.spring.gaji.administer.model.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.dto.InFacePurchaseDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.pay.model.dto.SafeTradingInfoDto;
import kh.spring.gaji.user.model.dto.UserCountReportDto;
import kh.spring.gaji.user.model.dto.UserInfoDto;

@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<InFacePurchaseDto> InFacePurchaseDto() {	//33P 직거래 조회 
		return sqlSession.selectList("admin.getetInfacePurchaseList");
	}
	
	public List<InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord) {	//33P 직거래 조회 상품명
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchTitleInfacePurchaseList",searchWord);
	}
	
	public List<InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord) {	//33P 직거래 조회 상품ID
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchIdInfacePurchaseList",searchWord);
	}
	
	public List<InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord) {	//33P 직거래 조회 회원ID 
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchUserInfacePurchaseList",searchWord);
	}
	
	public InFaceTradingInfoDto getInfaceTradingInfo(int inFaceTradingId) {	//34P 관리자 직거래 세부조회
		return sqlSession.selectOne("admin.getInfaceTradingInfo",inFaceTradingId);
	}
	
	public List<SafeTradingDto> getSafeTradingList() {	//35P 안전거래조회(관리자)
		return sqlSession.selectList("admin.getSafeTradingList");
	}
	
	public List<SafeTradingDto> getSearchSafeTradingList(String searchWord) {	//35P 안전거래 조회 검색(안전거래번호)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getSearchSafeTradingList",searchWord);
	}
	
	public List<SafeTradingDto> getIdSearchSafeTradingList(String searchWord) { // 35P 안전거래조회 검색(판매자ID)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getIdSearchSafeTradingList",searchWord);
	}
	
	public List<SafeTradingDto> getGoodsSearchSafeTradingList(String searchWord) {	//35P 안전거래조회 검색(상품명)
		searchWord="%"+searchWord+"%";
		return sqlSession.selectList("admin.getGoodsSearchSafeTradingList",searchWord);
	}
	
	public SafeTradingInfoDto getSafeTradingInfo(String searchWold) {	//36P 안전거래 세부조회(관리자)
		return sqlSession.selectOne("admin.getGoodsSearchSafeTradingList",searchWold);
	}
	
	// 회원정보조회 LIST
	public List<UserCountReportDto> getUserList() {
	    return sqlSession.selectList("user.getUserList");
	}

	// 회원정보조회 LIST 신고상위
	public List<UserCountReportDto> getTopReportUserList() {
	    return sqlSession.selectList("user.getTopReportUserList");
	}

	// 신고상위 ID검색 회원정보조회 LIST
	public List<UserCountReportDto> getSearchIdTopReportUserList(String searchWord) {
	    return sqlSession.selectList("user.getSearchIdTopReportUserList", searchWord);
	}

	// 거래상위 회원정보조회 LIST
	public List<UserCountReportDto> getTopTradeUserList(String searchWord) {
	    return sqlSession.selectList("user.getTopTradeUserList", searchWord);
	}

	// 거래상위 ID검색 회원정보조회 LIST
	public List<UserCountReportDto> getSearchIdTopTradeUserList(String searchWord) {
	    return sqlSession.selectList("user.getSearchIdTopTradeUserList", searchWord);
	}
	
	public UserInfoDto getUserInfo(String userId) {	// 38P 회원정보 세부조회
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
