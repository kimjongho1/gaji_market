package kh.spring.gaji.administer.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.administer.model.dao.AdminDao;
import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.domain.InFaceTradingInfoDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingInfoDomain;
import kh.spring.gaji.user.model.domain.UserCountReportDomain;
import kh.spring.gaji.user.model.domain.UserInfoDomain;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

    @Override //33P 직거래 조회 
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> InFacePurchaseDomain() {
        return adminDao.InFacePurchaseDomain();
    }

    @Override //33P 직거래 조회 상품명
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchTitleInfacePurchaseList(String searchWord) {
        return adminDao.getSearchTitleInfacePurchaseList(searchWord);
    }

    @Override //33P 직거래 조회 상품ID
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchIdInfacePurchaseList(String searchWord) {
        return adminDao.getSearchIdInfacePurchaseList(searchWord);
    }

    @Override //33P 직거래 조회 회원ID
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchUserInfacePurchaseList(String searchWord) {
        return adminDao.getSearchUserInfacePurchaseList(searchWord);
    }

    @Override //34P 관리자 직거래 세부조회
    public InFaceTradingInfoDomain getInfaceTradingInfo(int inFaceTradingId) {
        return adminDao.getInfaceTradingInfo(inFaceTradingId);
    }

    @Override //35P 안전거래조회(관리자)
    public List<SafeTradingDomain> getSafeTradingList() {
        return adminDao.getSafeTradingList();
    }

    @Override //35P 안전거래 조회 검색(안전거래번호)
    public List<SafeTradingDomain> getSearchSafeTradingList(String searchWord) {
        return adminDao.getSearchSafeTradingList(searchWord);
    }

    @Override // 35P 안전거래조회 검색(판매자ID)
    public List<SafeTradingDomain> getIdSearchSafeTradingList(String searchWord) {
        return adminDao.getIdSearchSafeTradingList(searchWord);
    }

    @Override //35P 안전거래조회 검색(상품명)
    public List<SafeTradingDomain> getGoodsSearchSafeTradingList(String searchWord) {
        return adminDao.getGoodsSearchSafeTradingList(searchWord);
    }

    @Override //36P 안전거래 세부조회(관리자)
    public SafeTradingInfoDomain getSafeTradingInfo(String searchWord) {
        return adminDao.getSafeTradingInfo(searchWord);
    }

    @Override // 37P 회원정보조회 LIST
    public List<UserCountReportDomain> getUserList() {
        return adminDao.getUserList();
    }

    @Override // 37P 회원정보조회 LIST 신고상위
    public List<UserCountReportDomain> getTopReportUserList() {
        return adminDao.getTopReportUserList();
    }

    @Override // 37P 신고상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDomain> getSearchIdTopReportUserList(String searchWord) {
        return adminDao.getSearchIdTopReportUserList(searchWord);
    }

    @Override // 37P 거래상위 회원정보조회 LIST
    public List<UserCountReportDomain> getTopTradeUserList(String searchWord) {
        return adminDao.getTopTradeUserList(searchWord);
    }

    @Override // 37P 거래상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDomain> getSearchIdTopTradeUserList(String searchWord) {
        return adminDao.getSearchIdTopTradeUserList(searchWord);
    }

    @Override // 38P 회원정보 세부조회
    public UserInfoDomain getUserInfo(String userId) {
        return adminDao.getUserInfo(userId);
    }

    @Override
    @Transactional // 38P 유저 계정 정지
    public int banUser(UserBlockingDto userBlockingDto) {
    	String userId=userBlockingDto.getBannedId();
    	adminDao.insertBanUser(userBlockingDto);
        return adminDao.banUser(userId);
    }

    @Override 		// 38P 유저 계정 정지 해제
    public int unBanUser(String userId) {
        return adminDao.unBanUser(userId);
    }
}