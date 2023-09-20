package kh.spring.gaji.administer.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.administer.model.dao.AdminDao;
import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.dto.AdminSafeTradingDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingInfoDto;
import kh.spring.gaji.user.model.dto.UserCountReportDto;
import kh.spring.gaji.user.model.dto.UserInfoDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

    @Override
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> InFacePurchaseDomain() {
        return adminDao.InFacePurchaseDomain();
    }

    @Override
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord) {
        return adminDao.getSearchTitleInfacePurchaseList(searchWord);
    }

    @Override
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord) {
        return adminDao.getSearchIdInfacePurchaseList(searchWord);
    }

    @Override
    public List<kh.spring.gaji.pay.model.dto.InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord) {
        return adminDao.getSearchUserInfacePurchaseList(searchWord);
    }

    @Override
    public InFaceTradingInfoDto getInfaceTradingInfo(int inFaceTradingId) {
        return adminDao.getInfaceTradingInfo(inFaceTradingId);
    }

    @Override
    public List<AdminSafeTradingDto> getSafeTradingList() {
        return adminDao.getSafeTradingList();
    }

    @Override
    public List<AdminSafeTradingDto> getSearchSafeTradingList(String searchWord) {
        return adminDao.getSearchSafeTradingList(searchWord);
    }

    @Override
    public List<AdminSafeTradingDto> getIdSearchSafeTradingList(String searchWord) {
        return adminDao.getIdSearchSafeTradingList(searchWord);
    }

    @Override
    public List<AdminSafeTradingDto> getGoodsSearchSafeTradingList(String searchWord) {
        return adminDao.getGoodsSearchSafeTradingList(searchWord);
    }

    @Override
    public SafeTradingInfoDto getSafeTradingInfo(String searchWord) {
        return adminDao.getSafeTradingInfo(searchWord);
    }

    @Override
    public List<UserCountReportDto> getUserList() {
        return adminDao.getUserList();
    }

    @Override
    public List<UserCountReportDto> adminGetUserList() {
        return adminDao.adminGetUserList();
    }

    @Override
    public List<UserCountReportDto> getSearchUserList(String searchWord) {
        return adminDao.getSearchUserList(searchWord);
    }

    @Override
    public UserInfoDto getUserInfo(String userId) {
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