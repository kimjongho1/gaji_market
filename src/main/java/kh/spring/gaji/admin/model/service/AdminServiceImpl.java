package kh.spring.gaji.admin.model.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.admin.model.dao.AdminDao;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class AdminServiceImpl implements AdminService {
	    @Autowired
	    private AdminDao adminDao;
	 // 33P 직거래 조회
	    @Override
	    public List<InFacePurchaseDto> getInfacePurchaseList() {
	        return adminDao.getInfacePurchaseList();
	    }
	    // 33P 직거래 조회 상품명
	    @Override
	    public List<InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord) {
	        return adminDao.getSearchTitleInfacePurchaseList(searchWord);
	    }
	    // 33P 직거래 조회 상품ID
	    @Override
	    public List<InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord) {
	        return adminDao.getSearchIdInfacePurchaseList(searchWord);
	    }
	 // 33P 직거래 조회 회원ID
	    @Override
	    public List<InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord) {
	        return adminDao.getSearchUserInfacePurchaseList(searchWord);
	    }
	 // 34P 관리자 직거래 세부조회
	    @Override
	    public InFaceTradingInfoDto getInfaceTradingInfo(String inFaceTradingId) {
	        return adminDao.getInfaceTradingInfo(inFaceTradingId);
	    }
	    // 35P 안전거래조회(관리자)
	    @Override
	    public List<SafeTradingDto> getSafeTradingList() {
	        return adminDao.getSafeTradingList();
	    }
	 // 35P 안전거래조회 검색(안전거래번호)
	    @Override
	    public List<AdminSafeTradingDto> getSearchSafeTradingList(String searchWord) {
	        return adminDao.getSearchSafeTradingList(searchWord);
	    }
	    // 35P 안전거래조회 검색(판매자ID)
	    @Override
	    public List<AdminSafeTradingDto> getIdSearchSafeTradingList(String searchWord) {
	        return adminDao.getIdSearchSafeTradingList(searchWord);
	    }
	    // 35P 안전거래조회 검색(상품명)
	    @Override
	    public List<AdminSafeTradingDto> getGoodsSearchSafeTradingList(String searchWord) {
	        return adminDao.getGoodsSearchSafeTradingList(searchWord);
	    }
	    // 36P 안전거래 세부조회(관리자)
	    @Override
	    public SafeTradingInfoDto getSafeTradingInfo(String transactionId) {
	        return adminDao.getSafeTradingInfo(transactionId);
	    }
	    // 37P 회원정보조회 LIST
	    @Override
	    public List<UserCountReportDto> getUserList() {
	        return adminDao.getUserList();
	    }
	    // 37P 회원정보조회 LIST 신고상위
	    @Override
	    public List<UserCountReportDto> getTopReportUserList() {
	        return adminDao.getTopReportUserList();
	    }
	    // 37P 신고상위 ID검색 회원정보조회 LIST
	    @Override
	    public List<UserCountReportDto> getSearchIdTopReportUserList(String searchWord) {
	        return adminDao.getSearchIdTopReportUserList(searchWord);
	    }
	    // 37P 거래상위 회원정보조회 LIST
	    @Override
	    public List<UserCountReportDto> getTopTradeUserList() {
	        return adminDao.getTopTradeUserList();
	    }
	    // 37P 거래상위 ID검색 회원정보조회 LIST
	    @Override
	    public List<UserCountReportDto> getSearchIdTopTradeUserList(String searchWord) {
	        return adminDao.getSearchIdTopTradeUserList(searchWord);
	    }
	    // 38P 회원정보 세부조회
	    @Override
	    public UserInfoDto getUserInfo(String userId) {
	        return adminDao.getUserInfo(userId);
	    }
	    // 38P 유저 계정 정지
	    @Override
	    public int banUser(String userId) {
	        return adminDao.banUser(userId);
	    }
	    // 38P 유저 계정 정지 해제
		@Override
		public int unBanUser(String userId) {
			return adminDao.unBanUser(userId);
		}
	    // 38P 계정정지 테이블에 아이디추가

	    @Override
	    public int insertBanUser(UserBlockingDto userBlockingDto) {
	        return adminDao.insertBanUser(userBlockingDto);
	    }
	    // 39P 상품글리스트(상품+신고수)

	    @Override
	    public List<GoodsReportCountDto> getGoodsReportCount() {
	        return adminDao.getGoodsReportCount();
	    }
	    // 39P 상품글리스트(상품+신고수) 미검토글만
	    @Override
	    public List<GoodsReportCountDto> getGoodsReportCountN() {
	        return adminDao.getGoodsReportCountN();
	    }
	    // 39P 회원 ID검색 상품글리스트(상품+신고수)
	    @Override
	    public List<GoodsReportCountDto> getSearchGoodsReportCount(String searchWord) {
	        return adminDao.getSearchGoodsReportCount(searchWord);
	    }
	    // 39P 회원 ID검색 상품글리스트(상품+신고수) 미검토글만
	    @Override
	    public List<GoodsReportCountDto> getSearchGoodsReportCountN(String searchWord) {
	        return adminDao.getSearchGoodsReportCountN(searchWord);
	    }
	    // 40P 하나의 상품글에 대한 신고들 조회
	    @Override
	    public List<ReportDto> getGoodsReportList(String refId) {
	        return adminDao.getGoodsReportList(refId);
	    }
	    // 41P 상품 신고내용 상세조회
	    @Override
	    public GoodsReportInfoDto getGoodsReportInfo(Map<String, String> map) {
	        return adminDao.getGoodsReportInfo(map);
	    }

	
}