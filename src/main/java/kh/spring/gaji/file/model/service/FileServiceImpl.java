package kh.spring.gaji.file.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.file.model.dao.FileDao;
import kh.spring.gaji.file.model.dto.FileDto;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDao fileDao;
	
	@Override
	public int insertFile(FileDto fileDto) {
		return fileDao.insertFile(fileDto);
	}

	@Override
	public List<FileDto> goodsImageList(int goodsId) {
		return fileDao.goodsImageList(goodsId);
	}

	@Override
	public int deleteImg(String imageUrl) {
		return fileDao.deleteImg(imageUrl);
	}

	@Override
	public int modifyFile(FileDto fileDto) {
		return fileDao.modifyFile(fileDto);
	}

}
