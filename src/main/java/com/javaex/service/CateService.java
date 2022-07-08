package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CateService {

	@Autowired
	private CategoryDao categoryDao;
	
	public int addCate(CategoryVo categoryVo) {
		
		return categoryDao.addCate(categoryVo);
	}
}
