package kh.spring.gaji.report.model.service;

import java.util.List;
import java.util.Map;

import kh.spring.gaji.goods.model.domain.GoodsReportCountDomain;
import kh.spring.gaji.report.model.domain.GoodsReportInfoDomain;
import kh.spring.gaji.report.model.dto.ReportDto;

public interface ReportService {
    // 11P 상품 신고하기
	int reportGoods(ReportDto reportDto);

    // 39P 상품글리스트(상품+신고수)
    List<GoodsReportCountDomain> getGoodsReportCount();

    // 39P 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDomain> getGoodsReportCountN();

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDomain> getSearchGoodsReportCount(String searchWord);

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    List<GoodsReportCountDomain> getSearchGoodsReportCountN(String searchWord);

    // 40P 하나의 상품글에 대한 신고들 조회
    List<ReportDto> getGoodsReportList(String refId);

    // 41P 상품 신고내용 상세조회
    GoodsReportInfoDomain getGoodsReportInfo(Map<String, Object> params);
}
