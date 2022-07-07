package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	/*
	//블로그 전체정보 (보류)
	public List<BlogVo> blogData(String id) {

		List<BlogVo> data = blogDao.blogData(id);
		
		System.out.println(data);
		
				System.out.println(data);
		return data;
	}
	*/
	//블로그 정보받기
	public Map<String, Object> blogAllData(String id) {
		
		BlogVo blogTitle = blogDao.blogTitle(id);
		List<CategoryVo> cateList = categoryDao.cateList(id);
		
		Map<String, Object> bMap = new HashMap<String, Object>();
		
		bMap.put("blogTitle", blogTitle);
		bMap.put("cateList", cateList);
		
		return bMap;
	}
	
}
