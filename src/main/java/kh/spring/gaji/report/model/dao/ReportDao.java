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

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDao {

    @Autowired
     private SqlSession sqlSession;

    public int reportGoods(ReportDto reportDto) {
        return sqlSession.insert("reportGoods", reportDto);
    }
}