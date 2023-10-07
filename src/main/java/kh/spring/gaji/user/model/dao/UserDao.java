package kh.spring.gaji.user.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;
import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.pay.model.dto.DealReviewDto;
import kh.spring.gaji.pay.model.dto.InFaceTradingDto;
import kh.spring.gaji.pay.model.dto.SafePurchaseInfoDto;
import kh.spring.gaji.pay.model.dto.SafeTradingDto;
import kh.spring.gaji.user.model.dto.UserAddressDto;
import kh.spring.gaji.user.model.dto.UserDto;
import kh.spring.gaji.user.model.dto.UserInsertAddressDto;
import kh.spring.gaji.user.model.dto.UserProfileDto;
import kh.spring.gaji.user.model.dto.UserSafeTradingDto;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public List<GoodsListDto> getKeepList(String userId) {	// 5P 사진을 포함한 찜목록을 가져옴
        return sqlSession.selectList("user.getKeepList", userId);
    }

    public int updateViewCount() {	//상품글 조회수 +1
        return sqlSession.update("user.updateViewCount");
    }

    public List<GoodsListDto> getFavoriteList(String userId) {	//6P 사진을 포함한 모아보기목록 가져옴
        return sqlSession.selectList("user.getFavoriteList", userId);
    }
    

    
    public String checkIdForSafe(String transactionId) {
    	return sqlSession.selectOne("user.checkIdForSafe",transactionId);
    }
    
    public String checkIdForSafeSeller(String transactionId) {
    	return sqlSession.selectOne("user.checkIdForSafeSeller",transactionId);
    }
    
    public int getSafeTotalCnt(String buyerId) {
    	return sqlSession.selectOne("user.getSafeTotalCnt",buyerId);
    }
    
    public int getSearchSafeTotalCnt(String buyerId,String searchWord) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	searchWord="%"+searchWord+"%";
    	map.put("buyerId", buyerId);
    	map.put("searchWord", searchWord);
    	return sqlSession.selectOne("user.getSearchSafeTotalCnt",map);
    }
    
    public List<UserSafeTradingDto> getSearchSafePurchaseList(String buyerId,int currentPage,int PAGESIZE,String searchWord, int totalCnt) {	//9P 안전거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("buyerId", buyerId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		return sqlSession.selectList("user.getSearchSafePurchaseList",map);
    }

    public List<UserSafeTradingDto> getSafePurchaseList(String buyerId,int currentPage,int PAGESIZE, int totalCnt) {	//9P 안전거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("buyerId", buyerId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
        return sqlSession.selectList("user.getSafePurchaseList",map);
    }
    
    public int getSellerSafeTotalCnt(String userId) {
    	return sqlSession.selectOne("user.getSellerSafeTotalCnt",userId);
    }
    
    public int getSearchSellerSafeTotalCnt(String userId,String searchWord) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	searchWord="%"+searchWord+"%";
    	map.put("userId", userId);
    	map.put("searchWord", searchWord);
    	return sqlSession.selectOne("user.getSearchSellerSafeTotalCnt",map);
    }
    
    public List<UserSafeTradingDto> getSearchSellerSafePurchaseList(String userId,int currentPage,int PAGESIZE,String searchWord, int totalCnt) {	//9P 안전거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		return sqlSession.selectList("user.getSellerSearchSafePurchaseList",map);
    }

    public List<UserSafeTradingDto> getSellerSafePurchaseList(String userId,int currentPage,int PAGESIZE, int totalCnt) {	//9P 안전거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
        return sqlSession.selectList("user.getSellerSafePurchaseList",map);
    }
    
    public int getInfaceTotalCnt(String buyerId) {
    	return sqlSession.selectOne("user.getInfaceTotalCnt",buyerId);
    }
    
    public int getSearchInfaceTotalCnt(String buyerId,String searchWord) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	searchWord="%"+searchWord+"%";
    	map.put("buyerId", buyerId);
    	map.put("searchWord", searchWord);
    	return sqlSession.selectOne("user.getSearchInfaceTotalCnt",map);
    }

    public List<InFaceTradingDto> getInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE,int totalCnt) {	//9P 직거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("buyerId", buyerId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
        return sqlSession.selectList("user.getInfacePurchaseList", map);
    }
    
    public List<InFaceTradingDto> getSearchInfacePurchaseList(String buyerId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//9P 직거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("buyerId", buyerId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		map.put("searchWord", searchWord);
        return sqlSession.selectList("user.getSearchInfacePurchaseList", map);
    }
    
    public int getSellerInfaceTotalCnt(String userId) {
    	return sqlSession.selectOne("user.getSellerInfaceTotalCnt",userId);
    }
    
    public int getSearchSellerInfaceTotalCnt(String userId,String searchWord) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	searchWord="%"+searchWord+"%";
    	map.put("userId", userId);
    	map.put("searchWord", searchWord);
    	return sqlSession.selectOne("user.getSearchSellerInfaceTotalCnt",map);
    }

    public List<InFaceTradingDto> getSellerInfacePurchaseList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//9P 직거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
        return sqlSession.selectList("user.getSellerInfacePurchaseList", map);
    }
    
    public List<InFaceTradingDto> getSearchSellerInfacePurchaseList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//9P 직거래 구매내역(회원) 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		map.put("searchWord", searchWord);
        return sqlSession.selectList("user.getSearchSellerInfacePurchaseList", map);
    }
    
   public int getOnsaleTotalCnt(String userId) {
	   return sqlSession.selectOne("user.getOnsaleTotalCnt",userId);
   }

    public List<MyGoodsListDto> getOnsaleList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//10P 판매중 + 예약중 불러오기
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
    	return sqlSession.selectList("user.getOnsaleList", map);
    }
    
    public int getSearchOnsaleTotalCnt(String userId,String searchWord) {
       Map<String, Object> map= new HashMap<String, Object>();
       searchWord="%"+searchWord+"%";
       map.put("userId", userId);
       map.put("searchWord", searchWord);
 	   return sqlSession.selectOne("user.getSearchOnsaleTotalCnt",map);
    }
    
    public List<MyGoodsListDto> getSearchOnsaleList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//10P 판매중 + 예약중 불러오기
    	searchWord="%"+searchWord+"%";
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		map.put("searchWord", searchWord);
    	return sqlSession.selectList("user.getSearchOnsaleList", map);
    }
    
  //찜목록
    public int getKeepUsedTotalCnt(String userId) {		
 	   return sqlSession.selectOne("user.getKeepUsedTotalCnt",userId);
    }
    
  //찜목록
     public List<MyGoodsListDto> getKeepUsedList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//10P 판매중 + 예약중 불러오기
     	int startRownum = 0;
 		int endRownum = 0;
 		startRownum = (currentPage-1)*PAGESIZE +1;
 		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
 		Map<String, Object> map= new HashMap<String, Object>();
 		map.put("userId", userId);
 		map.put("startRownum",startRownum);
 		map.put("endRownum",endRownum);
     	return sqlSession.selectList("user.getKeepUsedList", map);
     }
   //찜목록
     public int getSearchKeepUsedTotalCnt(String userId,String searchWord) {
        Map<String, Object> map= new HashMap<String, Object>();
        searchWord="%"+searchWord+"%";
        map.put("userId", userId);
        map.put("searchWord", searchWord);
  	   return sqlSession.selectOne("user.getSearchKeepUsedTotalCnt",map);
     }
   //찜목록
     public List<MyGoodsListDto> getSearchKeepUsedList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//10P 판매중 + 예약중 불러오기
     	searchWord="%"+searchWord+"%";
     	int startRownum = 0;
 		int endRownum = 0;
 		startRownum = (currentPage-1)*PAGESIZE +1;
 		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
 		Map<String, Object> map= new HashMap<String, Object>();
 		map.put("userId", userId);
 		map.put("startRownum",startRownum);
 		map.put("endRownum",endRownum);
 		map.put("searchWord", searchWord);
     	return sqlSession.selectList("user.getSearchKeepUsedList", map);
     }
     
    //모아보기
     public int getKeepUsersTotalCnt(String userId) {		
  	   return sqlSession.selectOne("user.getKeepUsersTotalCnt",userId);
     }
     
   //모아보기
      public List<MyGoodsListDto> getKeepUsersList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//10P 판매중 + 예약중 불러오기
      	int startRownum = 0;
  		int endRownum = 0;
  		startRownum = (currentPage-1)*PAGESIZE +1;
  		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
  		Map<String, Object> map= new HashMap<String, Object>();
  		map.put("userId", userId);
  		map.put("startRownum",startRownum);
  		map.put("endRownum",endRownum);
      	return sqlSession.selectList("user.getKeepUsersList", map);
      }
    //모아보기
      public int getSearchKeepUsersTotalCnt(String userId,String searchWord) {
         Map<String, Object> map= new HashMap<String, Object>();
         searchWord="%"+searchWord+"%";
         map.put("userId", userId);
         map.put("searchWord", searchWord);
   	   return sqlSession.selectOne("user.getSearchKeepUsersTotalCnt",map);
      }
    //모아보기
      public List<MyGoodsListDto> getSearchKeepUsersList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//10P 판매중 + 예약중 불러오기
      	searchWord="%"+searchWord+"%";
      	int startRownum = 0;
  		int endRownum = 0;
  		startRownum = (currentPage-1)*PAGESIZE +1;
  		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
  		Map<String, Object> map= new HashMap<String, Object>();
  		map.put("userId", userId);
  		map.put("startRownum",startRownum);
  		map.put("endRownum",endRownum);
  		map.put("searchWord", searchWord);
      	return sqlSession.selectList("user.getSearchKeepUsersList", map);
      }
   
    
    public int getClosedTotalCnt(String userId) {
 	   return sqlSession.selectOne("user.getClosedTotalCnt",userId);
    }

     public List<MyGoodsListDto> getClosedList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//10P 판매중 + 예약중 불러오기
     	int startRownum = 0;
 		int endRownum = 0;
 		startRownum = (currentPage-1)*PAGESIZE +1;
 		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
 		Map<String, Object> map= new HashMap<String, Object>();
 		map.put("userId", userId);
 		map.put("startRownum",startRownum);
 		map.put("endRownum",endRownum);
     	return sqlSession.selectList("user.getClosedList", map);
     }
     
     public int getSearchClosedTotalCnt(String userId,String searchWord) {
        Map<String, Object> map= new HashMap<String, Object>();
        searchWord="%"+searchWord+"%";
        map.put("userId", userId);
        map.put("searchWord", searchWord);
  	   return sqlSession.selectOne("user.getSearchClosedTotalCnt",map);
     }
     
     public List<MyGoodsListDto> getSearchClosedList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//10P 판매중 + 예약중 불러오기
     	searchWord="%"+searchWord+"%";
     	int startRownum = 0;
 		int endRownum = 0;
 		startRownum = (currentPage-1)*PAGESIZE +1;
 		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
 		Map<String, Object> map= new HashMap<String, Object>();
 		map.put("userId", userId);
 		map.put("startRownum",startRownum);
 		map.put("endRownum",endRownum);
 		map.put("searchWord", searchWord);
     	return sqlSession.selectList("user.getSearchClosedList", map);
     }
     
     public int getHideTotalCnt(String userId) {
   	   return sqlSession.selectOne("user.getHideTotalCnt",userId);
      }

       public List<MyGoodsListDto> getHideList(String userId,int currentPage,int PAGESIZE,int totalCnt) {	//10P 판매중 + 예약중 불러오기
       	int startRownum = 0;
   		int endRownum = 0;
   		startRownum = (currentPage-1)*PAGESIZE +1;
   		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
   		Map<String, Object> map= new HashMap<String, Object>();
   		map.put("userId", userId);
   		map.put("startRownum",startRownum);
   		map.put("endRownum",endRownum);
       	return sqlSession.selectList("user.getHideList", map);
       }
       
       public int getSearchHideTotalCnt(String userId,String searchWord) {
          Map<String, Object> map= new HashMap<String, Object>();
          searchWord="%"+searchWord+"%";
          map.put("userId", userId);
          map.put("searchWord", searchWord);
    	   return sqlSession.selectOne("user.getSearchHideTotalCnt",map);
       }
       
       public List<MyGoodsListDto> getSearchHideList(String userId,int currentPage,int PAGESIZE,int totalCnt,String searchWord) {	//10P 판매중 + 예약중 불러오기
       	searchWord="%"+searchWord+"%";
       	int startRownum = 0;
   		int endRownum = 0;
   		startRownum = (currentPage-1)*PAGESIZE +1;
   		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
   		Map<String, Object> map= new HashMap<String, Object>();
   		map.put("userId", userId);
   		map.put("startRownum",startRownum);
   		map.put("endRownum",endRownum);
   		map.put("searchWord", searchWord);
       	return sqlSession.selectList("user.getSearchHideList", map);
       }

    public List<MyGoodsListDto> getSoldOutList(String userId) {	//10P 거래완료 판매내역 가지고오기
        return sqlSession.selectList("user.getSoldOutList", userId);
    }

    public List<MyGoodsListDto> getHideList(String userId) {	//10P 숨김중인 판매내역 가져오기
        return sqlSession.selectList("user.getHideList", userId);
    }

    public int insertWishList(Map<String,String> map) {	//23P 찜하기
    	return sqlSession.insert("user.insertWishList",map);
    }

    public UserProfileDto getProfile(String userId) {	//프로필을 가져올때 유저주소 전부를 가져옴
        return sqlSession.selectOne("user.getProfile", userId);
    }

    public List<UserAddressDto> getAddress(String userId) {	//사용자 주소를 가져
        return sqlSession.selectList("user.getAddress", userId);
    }

    public int updateMainAddressNo(String userId) {	//대표주소를 변경하기위해 주소순서를 하나씩 뒤로 민다
    	return sqlSession.update("user.updateMainAddressNo", userId);
    }

    public int updateMainAddress(Map<String, Object> map) {	//주소순서를 1로 바꿈으로써 대표주소 변경
    	return sqlSession.update("user.updateMainAddress", map);
    }
    
    public int updateMainAddress2(Map<String, Object> map) {	//대표주소가 된 주소보다 높은순서들을 다시 1씩 내려주기.
    	return sqlSession.update("user.updateMainAddress2", map);
    }

    public int insertAddress(UserInsertAddressDto addressDto) {	//새로입력된 주소를 count+1 주소순서에 추가한다
    	return sqlSession.insert("user.insertAddress", addressDto);
    }

    public int deleteAddress1(Map<String, Object> map) {	//주소삭제 1단계 작업
    	return sqlSession.delete("user.deleteAddress1", map);
    }
    
    public int deleteAddress2(Map<String, Object> map) {		//주소삭제 2단계 작업
    	return sqlSession.update("user.deleteAddress2",map);
    }

    public int checkNickname(String nickname) {	// 7P 닉네임 중복검사
        return sqlSession.selectOne("user.checkNickname", nickname);
    }

    public int checkEmail(String email) {	//7P 이메일 중복검사
        return sqlSession.selectOne("user.checkEmail", email);
    }

    public String checkPass(String userId) {	//8P 패스워드를 가져온다 (패스워드 변경또는 로그인시 사용)
        return sqlSession.selectOne("user.checkPass", userId);
    }

    public int updateInviteCount(String userId) {	//8P 로그인시 방문횟수 + 1
    	return sqlSession.update("user.updateInviteCount", userId);
    }

    public int updatePass(Map<String, Object> map) {	//8P 패스워드를 변경한다
    	return sqlSession.update("user.updatePass", map);
    }

    public String checkId(String userId) {	//아이디 중복검사
        return sqlSession.selectOne("user.checkId", userId);
    }

    public int checkMobileNumber(String mobileNumber) {	//7P 전화번호 중복검사
        return sqlSession.selectOne("user.checkMobileNumber", mobileNumber);
    }

    public int signup(UserDto userDto) {	//회원가입
    	
    	return sqlSession.insert("user.signup", userDto);
    }

    public SafePurchaseInfoDto getSafePurchaseInfo(String transactionId) {	//11P 안전거래 상세정보 가져오기
        return sqlSession.selectOne("user.getSafePurchaseInfo", transactionId);
    }

    public int acceptSafeTrading(String transactionId) {	//12P 안전거래 수락, 상품준비중으로 거래상태 업데이트
    	return sqlSession.update("user.acceptSafeTrading", transactionId);
    }

    public int updateTrackingNumber(Map<String, Object> map) {	//12P 안전거래번호와 운송장번호를 인자로하여, 운송장번호와 거래상태 업데이트
    	return sqlSession.update("user.updateTrackingNumber", map);
    }

    public String findId(Map<String, String> map) {	//15P 아이디 찾기
        return sqlSession.selectOne("user.findId", map);
    }

    public int findPass(Map<String, String> map) {	//16P 비밀번호변경
    	return sqlSession.update("user.findPass", map);
    }

    public int addAccount(Map<String, String> map) {	//계좌등록
    	return sqlSession.insert("user.addAccount", map);
    }
    
    public int updateRole(String userId) {
    	return sqlSession.update("user.addFavoriteUser",userId);	// 유저 안전거래 가능여부 가능변경
    }

    public int addFavoriteUser(Map<String, String> map) {	//유저 즐겨찾기(모아보기) 23P
    	return sqlSession.insert("user.addFavoriteUser", map);
    }

    public int addDealReview(DealReviewDto dealReviewDto) {	//거래후기넣기 아직 화면설계없음.
    	return sqlSession.insert("user.addDealReview", dealReviewDto);
    }

    public int updateRatingScore(Map<String, String> map) {	// trade-mapper의 거래후기에따른 매너온도 업데이트
    	return sqlSession.update("user.updateRatingScore", map);
    }
}
