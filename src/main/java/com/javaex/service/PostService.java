package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public int write(PostVo postVo) {
		
		return postDao.write(postVo);
		
	}
}
