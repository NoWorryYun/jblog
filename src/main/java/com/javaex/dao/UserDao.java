package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlsession;
	
	
	//회원가입
	public int join(UserVo userVo) {
		
		int count = sqlsession.insert("users.join", userVo);
		
		return count;
	}

	//블로그생성
	public int createBlog(UserVo userVo) {
		
		return sqlsession.insert("users.createBlog",userVo);
	}

	//블로그명 default값으로 변경
	public int defaultBlogTitle(UserVo userVo) {
		
		return sqlsession.update("users.defaultBlogTitle", userVo);
	}
	
	//카테고리생성
	public int createCategory(UserVo userVo) {
		
		return sqlsession.insert("users.createCategory", userVo);
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		
		return sqlsession.selectOne("users.login", userVo);
	}
	
	//중복체크
	public String idCheck(String id) {
		
		return sqlsession.selectOne("users.idCheck", id);
	}
	
	
}
