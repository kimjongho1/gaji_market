package kh.spring.gaji.goods.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.goods.model.dao.GoodsDao;
import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsDto> getKeepList(int userId) {// 5P 사진을 포함한 찜목록을 가져옴
        return goodsDao.getKeepList(userId);
    }

    @Override
    public int updateViewCount(String goodsId) {// 상품 조회수+1
        return goodsDao.updateViewCount(goodsId);
    }

    @Override
    public List<GoodsDto> getFavoriteList(String userId) {// 6P 모아보기목록 가져옴 
        return goodsDao.getFavoriteList(userId);
    }

    @Override
    public List<GoodsDto> getOnSaleList(String userId) {// 10P 판매중 + 예약중 불러오기
        return goodsDao.getOnSaleList(userId);
    }

    @Override
    public List<GoodsDto> getSoldOutList(String userId) {// 10P 거래완료 판매내역 가지고오기 
        return goodsDao.getSoldOutList(userId);
    }

    @Override
    public List<GoodsDto> getHideList(String userId) {//10P 숨김중인 판매내역 가져오기
        return goodsDao.getHideList(userId);
    }

    @Override
    public int insertGoods(GoodsDto goodsDto) {// 24P 상품글 등록
    	return goodsDao.insertGoods(goodsDto);
    }

    @Override
    public GoodsInfoDto getGoodsInfo(int goodsId) {// 23P 상품글 상세조회
        return goodsDao.getGoodsInfo(goodsId);
    }

    @Override
    public int updateStatus(String status, int goodsId) {// 23P 상품상태
    	return goodsDao.updateStatus(status, goodsId);
    }

    @Override
    public int insertWishList(int goodsId, int userId) {// 23P 찜하기
    	return goodsDao.insertWishList(goodsId, userId);
    }

    @Override
    public int updateGoods(GoodsDto goodsDto) {// 25P 상품글 수정
    	return goodsDao.updateGoods(goodsDto);
    }

    @Override
    public int deleteGoods(int goodsId) {// 상품글 삭제는 active_status='N'으로 처리함
        return goodsDao.deleteGoods(goodsId);
    }
}
