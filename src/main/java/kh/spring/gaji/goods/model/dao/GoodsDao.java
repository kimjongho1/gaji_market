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

    public int insertGoods(GoodsDto goodsDto) {
        return sqlSession.insert("goods.insertGoods", goodsDto);
    }

    public GoodsInfoDto getGoodsInfo(int goodsId) {
        return sqlSession.selectOne("goods.getGoodsInfo", goodsId);
    }

    public int updateStatus(int goodsId, String status) {
        Map<String, Object> map = Map.of("goodsId", goodsId, "status", status);
        return sqlSession.update("goods.updateStatus", map);
    }

    public int updateGoods(GoodsDto goodsDto) {
        return sqlSession.update("goods.updateGoods", goodsDto);
    }
    
    public int deleteGoods(int goodsId) {
        return sqlSession.update("goods.deleteGoods", goodsId);
    }
}