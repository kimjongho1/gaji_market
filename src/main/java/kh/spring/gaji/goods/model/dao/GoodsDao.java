package kh.spring.gaji.goods.model.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;
import kh.spring.gaji.goods.model.dto.GoodsListInfoDto;
import kh.spring.gaji.goods.model.dto.GuDongInfoDto;
import kh.spring.gaji.goods.model.dto.MainGoodsDto;
import kh.spring.gaji.goods.model.dto.MyGoodsListDto;
import kh.spring.gaji.user.model.dto.FavoriteUserDto;
import kh.spring.gaji.user.model.dto.WishListDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsDao  {

    @Autowired
    private SqlSession sqlSession;
    
    public GoodsListInfoDto getGoodsListInfo(Integer priceCeiling,Integer category,Integer dongId,Integer onsale,String searchWord) {
    	Map<String,Object> map=new HashMap<String,Object>();
        map.put("priceCeiling", priceCeiling);
        map.put("category", category);
        map.put("dongId", dongId);
        map.put("searchWord", searchWord);
        map.put("onsale", onsale);
        return sqlSession.selectOne("goods.getGoodsListInfo",map);
    }
    
    public List<GoodsListDto> getGoodsList(Integer currentPage, Integer PAGESIZE, Integer sort, Integer priceCeiling,
    		Integer category, Integer dongId,Integer onsale, String searchWord,int totalCnt){
    	Map<String,Object> map=new HashMap<String,Object>();
    	int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*PAGESIZE +1;
		endRownum = ((currentPage*PAGESIZE) > totalCnt) ? totalCnt: (currentPage*PAGESIZE);
        map.put("priceCeiling", priceCeiling);
        map.put("category", category);
        map.put("dongId", dongId);
        map.put("searchWord", searchWord);
        map.put("startRownum",startRownum);
		map.put("endRownum",endRownum);
		map.put("sort", sort);
		map.put("onsale", onsale);
		return sqlSession.selectList("goods.getGoodsList",map);
    }
    
    public int insertGoods(GoodsDto goodsDto) {// 24P 상품글 등록 
        return sqlSession.insert("goods.insertGoods", goodsDto);
    }

    public GoodsInfoDto getGoodsInfo(int goodsId) {// 상품글 상세조회  
        return sqlSession.selectOne("goods.getGoodsInfo", goodsId);
    }
    
    public GoodsInfoDto getHideGoodsInfo(int goodsId) {// 상품글 상세조회  
        return sqlSession.selectOne("goods.getHideGoodsInfo", goodsId);
    }
    
    public List<GoodsInfoDto> goodsUrl(int goodsId) { // 상품글 사진 url
    	return sqlSession.selectList("goods.goodsUrl", goodsId);
    }
    
    public GoodsInfoDto goodsUserInfo(int goodsId) { // 상품글 작성자의 후기 안전거래횟수 상품개수
    	return sqlSession.selectOne("goods.goodsUserInfo",goodsId);
    }
    
    public WishListDto checkWishList(Map<String, String> map) { // 해당 상품에 대해 접속하는 유저가 그 상품 찜목록 조회
    	return sqlSession.selectOne("goods.checkWiskList",map);
    }
    
    public FavoriteUserDto checkFavoriteUser(Map<String, String> map) { // 해당 상품에 접속하는 유저가 글 작성 유저 좋아요 조회
    	return sqlSession.selectOne("goods.checkFavoriteUser", map);
    }
    
    public List<GoodsInfoDto> userGoodsList(int goodsId) { // 등록한 사용자의 상품리스트
    	return sqlSession.selectList("goods.userGoodsList", goodsId);
    }
    
    public GoodsDto getGoods(int goodsId){
    	return sqlSession.selectOne("goods.getGoods", goodsId);
    }
    public int pullUpGoods(int goodsId) { //상품 날짜 끌어올림
    	return sqlSession.update("goods.pullUpGoods", goodsId);
    }

    public int updateStatus(Map<String, Object> map) { //23P 상품상태변경 
        return sqlSession.update("goods.updateStatus", map);
    }

    public int updateGoods(GoodsDto goodsDto) {
        return sqlSession.update("goods.updateGoods", goodsDto);//25P 상품글 수정
    }
    
    public int deleteGoods(int goodsId) {
        return sqlSession.update("goods.deleteGoods", goodsId); // 상품삭제 
    }

    public int updateViewCount(int goodsId) {
    	return sqlSession.update("goods.updateViewCount", goodsId);
    }
    
    public List<MainGoodsDto> getMainGoods(int category){
    	return sqlSession.selectList("goods.getMainGoods",category);
    }
    
	public GuDongInfoDto getGuDongInfo(String userId) {
		return sqlSession.selectOne("goods.getGuDongInfo",userId);
	}
	public int getOnsaleTotalCnt(String userId) {
		   return sqlSession.selectOne("goods.getOnsaleTotalCnt",userId);
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
	    	return sqlSession.selectList("goods.getOnsaleList", map);
	    }
	    
	    public int getSearchOnsaleTotalCnt(String userId,String searchWord) {
	       Map<String, Object> map= new HashMap<String, Object>();
	       searchWord="%"+searchWord+"%";
	       map.put("userId", userId);
	       map.put("searchWord", searchWord);
	 	   return sqlSession.selectOne("goods.getSearchOnsaleTotalCnt",map);
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
	    	return sqlSession.selectList("goods.getSearchOnsaleList", map);
	    }
	    
}