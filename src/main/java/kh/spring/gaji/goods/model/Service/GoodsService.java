package kh.spring.gaji.goods.model.Service;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;
import kh.spring.gaji.goods.model.dto.GuDongInfoDto;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    int insertGoods(GoodsDto goodsDto);

    GoodsInfoDto getGoodsInfo(int goodsId);
    
    List<GoodsInfoDto> goodsUserInfo(int goodsID);
    
    List<GoodsInfoDto> userGoodsList(int goodsId);
    
    Map<String,Object> getGoodsList(int currentPage,int PAGESIZE,int sort,int priceCeiling,int category,int dongId,String searchWord);

    int updateStatus(Map<String, Object> map);

    int updateGoods(GoodsDto goodsDto);

    int deleteGoods(int goodsId);
    
    int updateViewCount(int goodsId);
    
    GuDongInfoDto getGuDongInfo(String userId);
}
