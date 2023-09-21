package kh.spring.gaji.admin.model.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.admin.model.dto.UserBlockingDto;
import kh.spring.gaji.goods.model.dto.GoodsReportCountDto;
import kh.spring.gaji.pay.model.dto.AdminSafeTradingDto;
import kh.spring.gaji.pay.model.dto.InFacePurchaseDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.pay.model.dto.SafeTradingInfoDto;
import kh.spring.gaji.report.model.dto.GoodsReportInfoDto;
import kh.spring.gaji.report.model.dto.ReportDto;
import kh.spring.gaji.user.model.dto.UserCountReportDto;
import kh.spring.gaji.user.model.dto.UserInfoDto;

@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;
	
    // 33P 직거래 조회
    public List<InFacePurchaseDto> getInfacePurchaseList() {
        return sqlSession.selectList("admin.getetInfacePurchaseList");
    }

    // 33P 직거래 조회 상품명
    public List<InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord) {
        return sqlSession.selectList("admin.getSearchTitleInfacePurchaseList", searchWord);
    }

    // 33P 직거래 조회 상품ID
    public List<InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord) {
        return sqlSession.selectList("admin.getSearchIdInfacePurchaseList", searchWord);
    }

    // 33P 직거래 조회 회원ID
    public List<InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord) {
        return sqlSession.selectList("admin.getSearchUserInfacePurchaseList", searchWord);
    }

    // 34P 관리자 직거래 세부조회
    public InFaceTradingInfoDto getInfaceTradingInfo(String inFaceTradingId) {
        return sqlSession.selectOne("admin.getInfaceTradingInfo", inFaceTradingId);
    }

    // 35P 안전거래조회(관리자)
    public List<AdminSafeTradingDto> getSafeTradingList() {
        return sqlSession.selectList("admin.getSafeTradingList");
    }

    // 35P 안전거래조회 검색(안전거래번호)
    public List<AdminSafeTradingDto> getSearchSafeTradingList(String searchWord) {
        return sqlSession.selectList("admin.getSearchSafeTradingList", searchWord);
    }

    // 35P 안전거래조회 검색(판매자ID)
    public List<AdminSafeTradingDto> getIdSearchSafeTradingList(String searchWord) {
        return sqlSession.selectList("admin.getIdSearchSafeTradingList", searchWord);
    }

    // 35P 안전거래조회 검색(상품명)
    public List<AdminSafeTradingDto> getGoodsSearchSafeTradingList(String searchWord) {
        return sqlSession.selectList("admin.getGoodsSearchSafeTradingList", searchWord);
    }

    // 36P 안전거래 세부조회(관리자)
    public SafeTradingInfoDto getSafeTradingInfo(String transactionId) {
        return sqlSession.selectOne("admin.getSafeTradingInfo", transactionId);
    }

    // 37P 회원정보조회 LIST
    public List<UserCountReportDto> getUserList() {
        return sqlSession.selectList("admin.getUserList");
    }

    // 37P 회원정보조회 LIST 신고상위
    public List<UserCountReportDto> getTopReportUserList() {
        return sqlSession.selectList("admin.getTopReportUserList");
    }

    // 37P 신고상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDto> getSearchIdTopReportUserList(String searchWord) {
        return sqlSession.selectList("admin.GetSearchIdTopReportUserList", searchWord);
    }

    // 37P 거래상위 회원정보조회 LIST
    public List<UserCountReportDto> getTopTradeUserList() {
        return sqlSession.selectList("admin.GetToptradeUserList");
    }

    // 37P 거래상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDto> getSearchIdTopTradeUserList(String searchWord) {
        return sqlSession.selectList("admin.GetSearchIdTopTradeUserList", searchWord);
    }

    // 38P 회원정보 세부조회
    public UserInfoDto getUserInfo(String userId) {
        return sqlSession.selectOne("admin.getUserInfo", userId);
    }

    // 38P 유저 계정 정지
    public int banUser(String userId) {
    	return sqlSession.update("admin.banUser", userId);
    }

    // 38P 유저 계정 정지 해제
    public int unBanUser(String userId) {
    	return sqlSession.update("admin.unBanUser", userId);
    }

    // 38P 계정정지 테이블에 아이디추가
    public int insertBanUser(UserBlockingDto userBlockingDto) {
        return sqlSession.insert("admin.insertBanUser", userBlockingDto);
    }

    // 39P 상품글리스트(상품+신고수)
    public List<GoodsReportCountDto> getGoodsReportCount() {
        return sqlSession.selectList("admin.getGoodsReportCount");
    }

    // 39P 상품글리스트(상품+신고수) 미검토글만
    public List<GoodsReportCountDto> getGoodsReportCountN() {
        return sqlSession.selectList("admin.getGoodsReportCountN");
    }

    // 39P 회원 ID검색 상품글리스트(상품+신고수)
    public List<GoodsReportCountDto> getSearchGoodsReportCount(String searchWord) {
        return sqlSession.selectList("admin.getSearchGoodsReportCount", searchWord);
    }
    
    // 39P 회원 ID검색 상품글리스트(상품+신고수) 미검토글만
    public List<GoodsReportCountDto> getSearchGoodsReportCountN(String searchWord) {
        return sqlSession.selectList("admin.getSearchGoodsReportCountN", searchWord);
    }
	

    // 40P 하나의 상품글에 대한 신고들 조회
    public List<ReportDto> getGoodsReportList(String refId) {
        return sqlSession.selectList("admin.trading.getGoodsReportList", refId);
    }

    // 41P 상품 신고내용 상세조회
    public GoodsReportInfoDto getGoodsReportInfo(Map<String, String> map) {
        return sqlSession.selectOne("admin.trading.getGoodsReportInfo", map);
    }
}
