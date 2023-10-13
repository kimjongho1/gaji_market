package kh.spring.gaji.region.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.gaji.region.model.dto.DongDto;
import kh.spring.gaji.region.model.dto.GuDto;

@Repository
public class RegionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<DongDto> dongList(){
		return sqlSession.selectList("region.dongList");
	}
	
	public List<DongDto> dongList(int guId){
		return sqlSession.selectList("region.dongListUsingGuId",guId);
	}
	
	public List<GuDto> guList(){
		return sqlSession.selectList("region.guList");
	}
}
