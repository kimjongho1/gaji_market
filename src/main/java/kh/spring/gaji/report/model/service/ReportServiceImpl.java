package kh.spring.gaji.report.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.goods.model.domain.GoodsReportCountDomain;
import kh.spring.gaji.report.model.dao.ReportDao;
import kh.spring.gaji.report.model.domain.GoodsReportInfoDomain;
import kh.spring.gaji.report.model.dto.ReportDto;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    // 11P 상품 신고하기
    @Override
    public int reportGoods(ReportDto reportDto) {
        return reportDao.reportGoods(reportDto);
    }

    // 39P 상품글리스트(상품+신고수)
    @Override
    public List<GoodsReportCountDomain> getGoodsReportCount() {
        return reportDao.getGoodsReportCount();
    }

    // 39P 상품글리스트(상품+신고수) 미검토글만
    @Override
    public List<GoodsReportCountDomain> getGoodsReportCountN() {
        return reportDao.getGoodsReportCountN();
    }

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    @Override
    public List<GoodsReportCountDomain> getSearchGoodsReportCount(String searchWord) {
        return reportDao.getSearchGoodsReportCount(searchWord);
    }

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    @Override
    public List<GoodsReportCountDomain> getSearchGoodsReportCountN(String searchWord) {
        return reportDao.getSearchGoodsReportCountN(searchWord);
    }

    // 40P 하나의 상품글에 대한 신고들 조회
    @Override
    public List<ReportDto> getGoodsReportList(String refId) {
        return reportDao.getGoodsReportList(refId);
    }

    // 41P 상품 신고내용 상세조회
    @Override
    public GoodsReportInfoDomain getGoodsReportInfo(Map<String, Object> params) {
        return reportDao.getGoodsReportInfo(params);
    }
}
