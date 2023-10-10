package kh.spring.gaji.goods.model.Service;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;

import java.util.Map;

public interface GoodsService {

    int insertGoods(GoodsDto goodsDto);

    GoodsInfoDto getGoodsInfo(int goodsId);
    
    GoodsListDto getGoodsList(int currentPage,int PAGESIZE,int sort,int priceFloor,int priceCeiling,int category,int guId,int dongId);
    
    GoodsListDto getGoodsList(int currentPage,int PAGESIZE,int sort,int priceFloor,int priceCeiling,int category,int guId,int dongId,String searchWord);

    int updateStatus(Map<String, Object> map);

    int updateGoods(GoodsDto goodsDto);

    int deleteGoods(int goodsId);
}
