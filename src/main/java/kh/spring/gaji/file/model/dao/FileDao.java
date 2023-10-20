package kh.spring.gaji.file.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.file.model.dto.FileDto;

@Repository
public class FileDao {
	@Autowired
    private SqlSession sqlSession;
	
	public int insertFile(FileDto fileDto) {
		return sqlSession.insert("file.insertFile", fileDto);
	}
	
	public List<FileDto> goodsImageList(int goodsId){
		return sqlSession.selectList("file.goodsImageList", goodsId);
	}
	
	public int deleteImg(String imageUrl) {
		return sqlSession.delete("file.deleteImg", imageUrl);
	}
	
	public int modifyFile(FileDto fileDto) {
		return sqlSession.insert("file.modifyFile", fileDto);
	}
}
