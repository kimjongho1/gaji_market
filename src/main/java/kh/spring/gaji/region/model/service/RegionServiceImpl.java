package kh.spring.gaji.region.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.region.model.dao.RegionDao;
import kh.spring.gaji.region.model.dto.DongDto;
import kh.spring.gaji.region.model.dto.GuDto;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionDao regionDao;

	@Override
	public List<DongDto> dongList() {
		return regionDao.dongList();
	}

	@Override
	public List<GuDto> guList() {
		return regionDao.guList();
	}

	@Override
	public List<DongDto> dongList(int guId) {
		return regionDao.dongList(guId);
	}
	
	
}
