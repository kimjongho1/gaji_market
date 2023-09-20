package kh.spring.gaji.administer.model.service;

import java.util.List;

import kh.spring.gaji.administer.model.dto.UserBlockingDto;
import kh.spring.gaji.pay.model.domain.InFacePurchaseDomain;
import kh.spring.gaji.pay.model.domain.InFaceTradingInfoDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingDomain;
import kh.spring.gaji.pay.model.domain.SafeTradingInfoDomain;
import kh.spring.gaji.user.model.domain.UserCountReportDomain;
import kh.spring.gaji.user.model.domain.UserInfoDomain;

	public interface AdminService {
	    List<InFacePurchaseDomain> InFacePurchaseDomain();  // 33P 직거래 조회
	    
	    List<InFacePurchaseDomain> getSearchTitleInfacePurchaseList(String searchWord);  // 33P 직거래 조회 상품명
	    
	    List<InFacePurchaseDomain> getSearchIdInfacePurchaseList(String searchWord);  // 33P 직거래 조회 상품ID
	    
	    List<InFacePurchaseDomain> getSearchUserInfacePurchaseList(String searchWord);  // 33P 직거래 조회 회원ID
	    
	    InFaceTradingInfoDomain getInfaceTradingInfo(int inFaceTradingId);  // 34P 관리자 직거래 세부조회
	    
	    List<SafeTradingDomain> getSafeTradingList();  // 35P 안전거래조회(관리자)
	    
	    List<SafeTradingDomain> getSearchSafeTradingList(String searchWord);  // 35P 안전거래 조회 검색(안전거래번호)
	    
	    List<SafeTradingDomain> getIdSearchSafeTradingList(String searchWord);  // 35P 안전거래조회 검색(판매자ID)
	    
	    List<SafeTradingDomain> getGoodsSearchSafeTradingList(String searchWord);  // 35P 안전거래조회 검색(상품명)
	    
	    SafeTradingInfoDomain getSafeTradingInfo(String searchWord);  // 36P 안전거래 세부조회(관리자)
	    
	    List<UserCountReportDomain> getUserList();  // 37P 회원정보조회 LIST
	    
	    List<UserCountReportDomain> getTopReportUserList(); // 37P 회원정보조회 LIST 신고상위
	    
	    List<UserCountReportDomain> getSearchIdTopReportUserList(String searchWord); // 37P 신고상위 ID검색 회원정보조회 LIST
	    
	    List<UserCountReportDomain> getTopTradeUserList(String searchWord); // 37P 거래상위 회원정보조회 LIST
	    
	    List<UserCountReportDomain> getSearchIdTopTradeUserList(String searchWord); // 37P 거래상위 ID검색 회원정보조회 LIST
	    
	    UserInfoDomain getUserInfo(String userId);  // 38P 회원정보 세부조회
	    
	    int banUser(UserBlockingDto userBlockingDto);  // 38P 유저 계정 정지
	    
	    int unBanUser(String userId);  // 38P 유저 계정 정지 해제
	}
