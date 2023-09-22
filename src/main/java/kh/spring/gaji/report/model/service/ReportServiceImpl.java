package kh.spring.gaji.report.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.report.model.dao.ReportDao;
import kh.spring.gaji.report.model.dto.ReportDto;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
    private ReportDao reportDao;
	
    @Override
    public int reportGoods(ReportDto reportDto) {
        return reportDao.reportGoods(reportDto);
    }
}