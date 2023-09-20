package kh.spring.gaji.administer.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.administer.model.dao.AdminDao;
import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.pay.model.dto.SafeTradingInfoDto;
import kh.spring.gaji.user.model.dto.UserCountReportDto;
import kh.spring.gaji.user.model.dto.UserInfoDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

    @Override //33P 직거래 조회 
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> InFacePurchaseDto() {
        return adminDao.InFacePurchaseDto();
    }

    @Override //33P 직거래 조회 상품명
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord) {
        return adminDao.getSearchTitleInfacePurchaseList(searchWord);
    }

    @Override //33P 직거래 조회 상품ID
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord) {
        return adminDao.getSearchIdInfacePurchaseList(searchWord);
    }

    @Override //33P 직거래 조회 회원ID
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord) {
        return adminDao.getSearchUserInfacePurchaseList(searchWord);
    }

    @Override //34P 관리자 직거래 세부조회
    public InFaceTradingInfoDto getInfaceTradingInfo(int inFaceTradingId) {
        return adminDao.getInfaceTradingInfo(inFaceTradingId);
    }

    @Override //35P 안전거래조회(관리자)
    public List<SafeTradingDto> getSafeTradingList() {
        return adminDao.getSafeTradingList();
    }

    @Override //35P 안전거래 조회 검색(안전거래번호)
    public List<SafeTradingDto> getSearchSafeTradingList(String searchWord) {
        return adminDao.getSearchSafeTradingList(searchWord);
    }

    @Override // 35P 안전거래조회 검색(판매자ID)
    public List<SafeTradingDto> getIdSearchSafeTradingList(String searchWord) {
        return adminDao.getIdSearchSafeTradingList(searchWord);
    }

    @Override //35P 안전거래조회 검색(상품명)
    public List<SafeTradingDto> getGoodsSearchSafeTradingList(String searchWord) {
        return adminDao.getGoodsSearchSafeTradingList(searchWord);
    }

    @Override //36P 안전거래 세부조회(관리자)
    public SafeTradingInfoDto getSafeTradingInfo(String searchWord) {
        return adminDao.getSafeTradingInfo(searchWord);
    }

    @Override // 37P 회원정보조회 LIST
    public List<UserCountReportDto> getUserList() {
        return adminDao.getUserList();
    }

    @Override // 37P 회원정보조회 LIST 신고상위
    public List<UserCountReportDto> getTopReportUserList() {
        return adminDao.getTopReportUserList();
    }

    @Override // 37P 신고상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDto> getSearchIdTopReportUserList(String searchWord) {
        return adminDao.getSearchIdTopReportUserList(searchWord);
    }

    @Override // 37P 거래상위 회원정보조회 LIST
    public List<UserCountReportDto> getTopTradeUserList(String searchWord) {
        return adminDao.getTopTradeUserList(searchWord);
    }

    @Override // 37P 거래상위 ID검색 회원정보조회 LIST
    public List<UserCountReportDto> getSearchIdTopTradeUserList(String searchWord) {
        return adminDao.getSearchIdTopTradeUserList(searchWord);
    }

    @Override // 38P 회원정보 세부조회
    public UserInfoDto getUserInfo(String userId) {
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