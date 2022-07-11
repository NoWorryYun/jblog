package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	//포스트 리스트
	public List<PostVo> postList(Integer cateNo){
		System.out.println("PostSerivce > postList");
		int maxCateNo = postDao.maxCateNo();
		
		if(cateNo == null) {
			cateNo = maxCateNo;
		}
		System.out.println(cateNo);
		List<PostVo> postList = postDao.postList(cateNo);
		
		return postList;
		
	}
	
	//포스트 일기
	public PostVo postRead(Integer cateNo, Integer postNo) {
		
		System.out.println("PostSerivce > postRead");
		int maxPostNo = postDao.maxPostNo(cateNo);
		
		if(postNo == null) {
			postNo = maxPostNo;
		}
		
		PostVo postRead = postDao.postRead(postNo);
		
		return postRead;
	}
	
	//포스트 글쓰기
	public int write(PostVo postVo) {
		
		return postDao.write(postVo);
		
	}
}
