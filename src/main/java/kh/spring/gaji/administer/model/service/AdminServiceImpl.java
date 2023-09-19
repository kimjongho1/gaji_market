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

    @Override
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> InFacePurchaseDomain() {
        return adminDao.InFacePurchaseDomain();
    }

    @Override
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchTitleInfacePurchaseList(String searchWord) {
        return adminDao.getSearchTitleInfacePurchaseList(searchWord);
    }

    @Override
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchIdInfacePurchaseList(String searchWord) {
        return adminDao.getSearchIdInfacePurchaseList(searchWord);
    }

    @Override
    public List<kh.spring.gaji.pay.model.domain.InFacePurchaseDomain> getSearchUserInfacePurchaseList(String searchWord) {
        return adminDao.getSearchUserInfacePurchaseList(searchWord);
    }

    @Override
    public InFaceTradingInfoDomain getInfaceTradingInfo(int inFaceTradingId) {
        return adminDao.getInfaceTradingInfo(inFaceTradingId);
    }

    @Override
    public List<SafeTradingDomain> getSafeTradingList() {
        return adminDao.getSafeTradingList();
    }

    @Override
    public List<SafeTradingDomain> getSearchSafeTradingList(String searchWord) {
        return adminDao.getSearchSafeTradingList(searchWord);
    }

    @Override
    public List<SafeTradingDomain> getIdSearchSafeTradingList(String searchWord) {
        return adminDao.getIdSearchSafeTradingList(searchWord);
    }

    @Override
    public List<SafeTradingDomain> getGoodsSearchSafeTradingList(String searchWord) {
        return adminDao.getGoodsSearchSafeTradingList(searchWord);
    }

    @Override
    public SafeTradingInfoDomain getSafeTradingInfo(String searchWord) {
        return adminDao.getSafeTradingInfo(searchWord);
    }

    @Override
    public List<UserCountReportDomain> getUserList() {
        return adminDao.getUserList();
    }

    @Override
    public List<UserCountReportDomain> adminGetUserList() {
        return adminDao.adminGetUserList();
    }

    @Override
    public List<UserCountReportDomain> getSearchUserList(String searchWord) {
        return adminDao.getSearchUserList(searchWord);
    }

    @Override
    public UserInfoDomain getUserInfo(String userId) {
        return adminDao.getUserInfo(userId);
    }

    @Override
    @Transactional
    public int banUser(UserBlockingDto userBlockingDto) {
    	String userId=userBlockingDto.getBannedId();
    	adminDao.insertBanUser(userBlockingDto);
        return adminDao.banUser(userId);
    }

    @Override
    public int unBanUser(String userId) {
        return adminDao.unBanUser(userId);
    }
}