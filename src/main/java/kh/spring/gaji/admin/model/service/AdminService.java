package kh.spring.gaji.admin.model.service;
import java.util.List;
import java.util.Map;

import kh.spring.gaji.admin.model.dto.UserBlockingDto;
import kh.spring.gaji.admin.model.dto.UserListDto;
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

public interface AdminService {
    List<InFacePurchaseDto> getInfacePurchaseList();

    List<InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord);

    List<InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord);

    List<InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord);

    InFaceTradingInfoDto getInfaceTradingInfo(String inFaceTradingId);

    List<AdminSafeTradingDto> getSafeTradingList();

    List<AdminSafeTradingDto> getSearchSafeTradingList(String searchWord);

    List<AdminSafeTradingDto> getIdSearchSafeTradingList(String searchWord);

    List<AdminSafeTradingDto> getGoodsSearchSafeTradingList(String searchWord);

    SafeTradingInfoDto getSafeTradingInfo(String transactionId);

    List<UserCountReportDto> getUserList();

    List<UserCountReportDto> getTopReportUserList();

    List<UserCountReportDto> getSearchIdTopReportUserList(String searchWord);

    List<UserCountReportDto> getTopTradeUserList();

    List<UserCountReportDto> getSearchIdTopTradeUserList(String searchWord);

    UserInfoDto getUserInfo(String userId);

    int banUser(String userId);

    int unBanUser(String userId);

    int insertBanUser(UserBlockingDto userBlockingDto);

    List<GoodsReportCountDto> getGoodsReportCount();

    List<GoodsReportCountDto> getGoodsReportCountN();

    List<GoodsReportCountDto> getSearchGoodsReportCount(String searchWord);

    List<GoodsReportCountDto> getSearchGoodsReportCountN(String searchWord);

    List<ReportDto> getGoodsReportList(String refId);

    GoodsReportInfoDto getGoodsReportInfo(Map<String, String> map);
    
    
    List<UserListDto> userList();
    
    List<UserListDto> userReportList(String userId);
    
    UserListDto userReportInfo(int refId);
    
    int reportReview(int refId);
    
    int checkBan(String userId);
    
    String checkReview(int refId);
    
    List<UserBlockingDto> banUserList();
}
