package kh.spring.gaji.goods.model.Service;

import java.util.List;

import kh.spring.gaji.goods.model.dto.GoodsDto;
import kh.spring.gaji.goods.model.dto.GoodsInfoDto;

public interface GoodsService {
	List<GoodsDto> getKeepList(int userId);// 5P 사진을 포함한 찜목록을 가져옴

    int updateViewCount(String goodsId);// 상품 조회수+1

    List<GoodsDto> getFavoriteList(String userId);// 6P 모아보기목록 가져옴 

    List<GoodsDto> getOnSaleList(String userId);// 10P 판매중 + 예약중 불러오기

    List<GoodsDto> getSoldOutList(String userId);// 10P 거래완료 판매내역 가지고오기 

    List<GoodsDto> getHideList(String userId);//10P 숨김중인 판매내역 가져오기

    int insertGoods(GoodsDto goodsDto); // 24P 상품글 등록

    GoodsInfoDto getGoodsInfo(int goodsId);// 23P 상품글 상세조회

    int updateStatus(String status, int goodsId); // 23P 상품상태

    int insertWishList(int goodsId, int userId);// 23P 찜하기

    int updateGoods(GoodsDto goodsDto);// 25P 상품글 수정

    int deleteGoods(int goodsId);// 상품글 삭제는 active_status='N'으로 처리함
}
