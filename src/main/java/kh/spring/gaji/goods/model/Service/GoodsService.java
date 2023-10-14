package kh.spring.gaji.goods.model.Service;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

import java.util.Map;

public interface GoodsService {

    int insertGoods(GoodsDto goodsDto);

    GoodsInfoDto getGoodsInfo(int goodsId);
    
    Map<String,Object> getGoodsList(int currentPage,int PAGESIZE,int sort,int priceCeiling,int category,int dongId,String searchWord);

    int updateStatus(Map<String, Object> map);

    int updateGoods(GoodsDto goodsDto);

    int deleteGoods(int goodsId);
}
