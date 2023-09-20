package kh.spring.gaji.report.model.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.goods.model.dto.GoodsReportCountDto;
import kh.spring.gaji.report.model.dto.GoodsReportInfoDto;
import kh.spring.gaji.report.model.dto.ReportDto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDao {
    @Autowired
    private SqlSession sqlSession;

    // 11P 상품 신고하기
    public int reportGoods(ReportDto reportDto) {
        return sqlSession.insert("report.reportGoods", reportDto);
    }

    // 39P 상품글리스트(상품+신고수)
    public List<GoodsReportCountDto> getGoodsReportCount() {
        return sqlSession.selectList("report.getGoodsReportCount");
    }

    // 39P 상품글리스트(상품+신고수) 미검토글만
    public List<GoodsReportCountDto> getGoodsReportCountN() {
        return sqlSession.selectList("report.getGoodsReportCountN");
    }

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    public List<GoodsReportCountDto> getSearchGoodsReportCount(String searchWord) {
        return sqlSession.selectList("report.getSearchGoodsReportCount", searchWord);
    }

    // 39P 회원 ID 검색 상품글리스트(상품+신고수) 미검토글만
    public List<GoodsReportCountDto> getSearchGoodsReportCountN(String searchWord) {
        return sqlSession.selectList("report.getSearchGoodsReportCountN", searchWord);
    }

    // 40P 하나의 상품글에 대한 신고들 조회
    public List<ReportDto> getGoodsReportList(String refId) {
        return sqlSession.selectList("report.getGoodsReportList", refId);
    }

    // 41P 상품 신고내용 상세조회
    public GoodsReportInfoDto getGoodsReportInfo(Map<String, Object> params) {
        return sqlSession.selectOne("report.getGoodsReportInfo", params);
    }
}
