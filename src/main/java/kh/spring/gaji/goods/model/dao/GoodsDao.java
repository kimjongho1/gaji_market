package kh.spring.gaji.goods.model.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

import java.util.Map;

@Repository
public class GoodsDao  {

    @Autowired
    private SqlSession sqlSession;

    public int insertGoods(GoodsDto goodsDto) {// 24P 상품글 등록 
        return sqlSession.insert("goods.insertGoods", goodsDto);
    }

    public GoodsInfoDto getGoodsInfo(int goodsId) {// 상품글 상세조회  
        return sqlSession.selectOne("goods.getGoodsInfo", goodsId);
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
}