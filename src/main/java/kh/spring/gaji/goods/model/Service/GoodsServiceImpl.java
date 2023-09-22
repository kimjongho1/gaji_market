package kh.spring.gaji.goods.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.gaji.goods.model.dao.GoodsDao;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

@Service
@Transactional
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
    public int updateStatus(int goodsId, String status) {
        return goodsDao.updateStatus(goodsId, status);
    }

    @Override
    public int updateGoods(GoodsDto goodsDto) {
        return goodsDao.updateGoods(goodsDto);
    }

    @Override
    public int deleteGoods(int goodsId) {
        return goodsDao.deleteGoods(goodsId);
    }
}