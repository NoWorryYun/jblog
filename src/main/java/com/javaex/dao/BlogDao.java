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
	
	public List<BlogVo> blogData(String id){
		
		System.out.println(id);
		
		return sqlsession.selectList("blog.blogData", id);
	}
}
