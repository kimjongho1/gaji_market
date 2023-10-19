package kh.spring.gaji.file.model.service;

import java.util.List;

import kh.spring.gaji.file.model.dto.FileDto;

public interface FileService {
	
	public int insertFile(FileDto fileDto);
	
	public List<FileDto> goodsImageList(int goodsId);
}
