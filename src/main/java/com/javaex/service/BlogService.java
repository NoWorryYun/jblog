package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public List<BlogVo> blogData(String id) {

		List<BlogVo> data = blogDao.blogData(id);
		
		System.out.println(data);
		
				System.out.println(data);
		return data;
	}
	
}
