package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	
	@Autowired
	private SqlSession sqlsession;
	//메인페이지 full contents(보류)
	public List<BlogVo> blogData(String id){
		
		System.out.println(id);
		
		return sqlsession.selectList("blog.blogData", id);
	}
	
	//blogTitle 받기
	public BlogVo blogTitle(String id) {
		
		return sqlsession.selectOne("blog.blogTitle", id);
	}
	
	//blogLogo 업데이트
	public int blogImg(BlogVo blogVo) {
	
		return sqlsession.update("blog.blogImg", blogVo);
	}
	
	//logoFile 받기
	public String onlyLogoFile(String id) {
		
		return sqlsession.selectOne("blog.onlyLogoFile", id);
	}
	
}
