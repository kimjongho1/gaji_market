package kh.spring.gaji.report.model.service;

import java.util.List;
import java.util.Map;

import kh.spring.gaji.goods.model.dto.GoodsReportCountDto;
import kh.spring.gaji.report.model.dto.GoodsReportInfoDto;
import kh.spring.gaji.report.model.dto.ReportDto;

public interface ReportService {
    // 11P 상품 신고하기
	int reportGoods(ReportDto reportDto);

    // 39P 상품글리스트(상품+신고수)
    List<GoodsReportCountDto> getGoodsReportCount();

    // 39P 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDto> getGoodsReportCountN();

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDto> getSearchGoodsReportCount(String searchWord);

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDto> getSearchGoodsReportCountN(String searchWord);

    // 40P 하나의 상품글에 대한 신고들 조회
    List<ReportDto> getGoodsReportList(String refId);

    // 41P 상품 신고내용 상세조회
    GoodsReportInfoDto getGoodsReportInfo(Map<String, Object> params);
}
