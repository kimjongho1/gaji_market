package kh.spring.gaji.region.model.service;

import java.util.List;

import kh.spring.gaji.region.model.dto.DongDto;
import kh.spring.gaji.region.model.dto.GuDto;

public interface RegionService {
	
	public List<DongDto> dongList();
	
	public List<GuDto> guList();
}
