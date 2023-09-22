package kh.spring.gaji.goods.model.Service;

import java.util.List;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

import java.util.Map;

public interface GoodsService {

    int insertGoods(GoodsDto goodsDto);

    GoodsInfoDto getGoodsInfo(int goodsId);

    int updateStatus(int goodsId, String status);

    int updateGoods(GoodsDto goodsDto);

    int deleteGoods(int goodsId);
}
