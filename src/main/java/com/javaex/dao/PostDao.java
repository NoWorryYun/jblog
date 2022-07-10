package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	
	@Autowired
	private SqlSession sqlsession;
	
	public int write(PostVo postVo) {
		
		return sqlsession.insert("post.write", postVo);
	}
}
