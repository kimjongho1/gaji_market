package kh.spring.gaji.category.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.gaji.category.model.dao.CategoryDao;
import kh.spring.gaji.category.model.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;
		
	@Override
	public List<CategoryDto> categoryList() {
		return categoryDao.categoryList();
	}

}
