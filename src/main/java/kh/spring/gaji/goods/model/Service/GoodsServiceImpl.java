package kh.spring.gaji.goods.model.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.goods.model.dao.GoodsDao;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;
import kh.spring.gaji.goods.model.dto.GoodsListDto;


@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public int insertGoods(GoodsDto goodsDto) {
		return goodsDao.insertGoods(goodsDto);
	}

	@Override
	public GoodsInfoDto getGoodsInfo(int goodsId) {
		return goodsDao.getGoodsInfo(goodsId);
	}

	@Override
	public int updateStatus(Map<String, Object> map) {
		return goodsDao.updateStatus(map);
	}

	@Override
	public int updateGoods(GoodsDto goodsDto) {
		return goodsDao.updateGoods(goodsDto);
	}

	@Override
	public int deleteGoods(int goodsId) {
		return goodsDao.deleteGoods(goodsId);
	}

	@Override
	public GoodsListDto getGoodsList(int currentPage, int PAGESIZE, int sort, int priceFloor, int priceCeiling,
	int category, int guId, int dongId) {
		return null;
	}

	@Override
	public GoodsListDto getGoodsList(int currentPage, int PAGESIZE, int sort, int priceFloor, int priceCeiling,
	int category, int guId, int dongId, String searchWord) {
		return null;
	}

}
