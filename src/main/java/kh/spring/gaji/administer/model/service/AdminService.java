package kh.spring.gaji.administer.model.service;

import java.util.List;

import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.dto.AdminSafeTradingDto;
import kh.spring.gaji.pay.model.dto.InFacePurchaseDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingInfoDto;
import kh.spring.gaji.user.model.dto.UserCountReportDto;
import kh.spring.gaji.user.model.dto.UserInfoDto;

	public interface AdminService {
	    List<InFacePurchaseDto> InFacePurchaseDomain();  // 33P 직거래 조회
	    
	    List<InFacePurchaseDto> getSearchTitleInfacePurchaseList(String searchWord);  // 33P 직거래 조회 상품명
	    
	    List<InFacePurchaseDto> getSearchIdInfacePurchaseList(String searchWord);  // 33P 직거래 조회 상품ID
	    
	    List<InFacePurchaseDto> getSearchUserInfacePurchaseList(String searchWord);  // 33P 직거래 조회 회원ID
	    
	    InFaceTradingInfoDto getInfaceTradingInfo(int inFaceTradingId);  // 34P 관리자 직거래 세부조회
	    
	    List<AdminSafeTradingDto> getSafeTradingList();  // 35P 안전거래조회(관리자)
	    
	    List<AdminSafeTradingDto> getSearchSafeTradingList(String searchWord);  // 35P 안전거래 조회 검색(안전거래번호)
	    
	    List<AdminSafeTradingDto> getIdSearchSafeTradingList(String searchWord);  // 35P 안전거래조회 검색(판매자ID)
	    
	    List<AdminSafeTradingDto> getGoodsSearchSafeTradingList(String searchWord);  // 35P 안전거래조회 검색(상품명)
	    
	    SafeTradingInfoDto getSafeTradingInfo(String searchWord);  // 36P 안전거래 세부조회(관리자)
	    
	    List<UserCountReportDto> getUserList();  // 37P 회원정보조회 LIST 신고상위
	    
	    List<UserCountReportDto> adminGetUserList();  // 37P 거래상위 회원정보조회 LIST
	    
	    List<UserCountReportDto> getSearchUserList(String searchWord);  // 37P 거래상위 회원정보조회 LIST
	    
	    UserInfoDto getUserInfo(String userId);  // 38P 회원정보 세부조회
	    
	    int banUser(UserBlockingDto userBlockingDto);  // 38P 유저 계정 정지
	    
	    int unBanUser(String userId);  // 38P 유저 계정 정지 해제
	}
