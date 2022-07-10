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
	
	//카테고리 등록
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
	
	//카테고리 삭제
	public String removeCate(CategoryVo categoryVo) {
		
		String state;
		int count = categoryDao.removeCate(categoryVo);
		
		if(count > 0 ) {
			state = "success";
		} else {
			state = "fail";
		}
		return state;
	}
	
	//리스트 불러오기
	public List<CategoryVo> cateList(String id) {
		System.out.println("cateList Service");
		
		System.out.println(categoryDao.cateList(id));
		return categoryDao.cateList(id);
	}
	
	//리스트전체 불러오기
	public List<CategoryVo> cateListAll() {
		System.out.println("cateList Service");
		
		System.out.println(categoryDao.cateListAll());
		return categoryDao.cateListAll();
	}
}
