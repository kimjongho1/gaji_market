package kh.spring.gaji.file.model.dao;

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
}
