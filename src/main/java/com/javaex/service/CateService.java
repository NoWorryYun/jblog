package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CateService {

	@Autowired
	private CategoryDao categoryDao;
	
	public String addCate(CategoryVo categoryVo) {

		String state;
		int count = categoryDao.addCate(categoryVo);
		
		if (count>0) {
			state = "success";
		} else {
			state = "fail";
		}
		return state;
	}
	
	public List<CategoryVo> cateList(String id) {
		System.out.println("cateList Service");
		
		System.out.println(categoryDao.cateListAll());
		return categoryDao.cateList(id);
	}
	
	
	public List<CategoryVo> cateListAll() {
		System.out.println("cateList Service");
		
		System.out.println(categoryDao.cateListAll());
		return categoryDao.cateListAll();
	}
}
