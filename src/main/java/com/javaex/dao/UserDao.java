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
	
	//로그인
	public UserVo login(UserVo userVo) {
		
		return sqlsession.selectOne("users.login", userVo);
	}
}