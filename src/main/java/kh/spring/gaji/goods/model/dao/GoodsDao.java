package kh.spring.gaji.goods.model.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kh.spring.gaji.goods.model.domain.GoodsInfoDomain;
import kh.spring.gaji.goods.model.dto.GoodsDto;

@Repository
public class GoodsDao{
	 @Autowired
	    private SqlSession sqlSession;

	    // 5P 사진을 포함한 찜목록을 가져옴
	    public List<GoodsDto> getKeepList(int userId) {
	        return sqlSession.selectList("goods.getKeepList", userId);
	    }

	    // 상품 조회수+1
	    public int updateViewCount(String goodsId) {
	        return sqlSession.update("goods.updateViewCount",goodsId);
	    }

	    // 6P 모아보기목록 가져옴 
	    public List<GoodsDto> getFavoriteList(String userId) {
	        return sqlSession.selectList("goods.getFavoriteList", userId);
	    }

	    // 10P 판매중 + 예약중 불러오기
	    public List<GoodsDto> getOnSaleList(String userId) {
	        return sqlSession.selectList("goods.getOnSaleList", userId);
	    }

	    // 10P 거래완료 판매내역 가지고오기 
	    public List<GoodsDto> getSoldOutList(String userId) {
	        return sqlSession.selectList("goods.getSoldOutList", userId);
	    }
	    //10P 숨김중인 판매내역 가져오기
	    public List<GoodsDto> getHideList(String userId) {	
	        return sqlSession.selectList("goods.getHideList", userId);
	    }

	    // 24P 상품글 등록
	    public int insertGoods(GoodsDto goodsDto) {
	        return sqlSession.insert("goods.insertGoods", goodsDto);
	    }

	    // 23P 상품글 상세조회
	    public GoodsInfoDomain getGoodsInfo(int goodsId) {
	        return sqlSession.selectOne("goods.getGoodsInfo", goodsId);
	    }

	    // 23P 상품상태
	    public int updateStatus(String status, int goodsId) {
	        Map<String, Object> map = new HashMap<>();
	        map.put("status", status);
	        map.put("goodsId", goodsId);
	        return sqlSession.update("goods.updateStatus", map);
	    }

	    // 23P 찜하기
	    public int insertWishList(int goodsId, int userId) {
	        Map<String, Object> map = new HashMap<>();
	        map.put("goodsId", goodsId);
	        map.put("userId", userId);
	        return sqlSession.insert("goods.insertWishList", map);
	    }

	    // 25P 상품글 수정
	    public int updateGoods(GoodsDto goodsDto) {
	    	return sqlSession.update("goods.updateGoods", goodsDto);
	    }

	    // 상품글 삭제는 active_status='N'으로 처리함
	    public int deleteGoods(int goodsId) {
	    	return sqlSession.delete("goods.deleteGoods", goodsId);
	    }
}
