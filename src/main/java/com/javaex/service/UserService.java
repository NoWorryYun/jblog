package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//회원가입
	public int join(UserVo userVo) {
		String id = userVo.getId();
		
		String idCheck = userDao.idCheck(id);
		int count = 0 ;
		if(idCheck == null) {
			count = userDao.join(userVo);
			userDao.createBlog(userVo);
			return count;
		} else {
			return count;
		}
		
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		
		return userDao.login(userVo);
	}
	
	//중복체크
	public String idCheck(String id) {
		
		String idCheck = userDao.idCheck(id);
		System.out.println(idCheck);
		
		String result;
		
		if(idCheck != null) {
			result = "fail";
		} else {
			result = "success";
		}
		
		System.out.println(result);
		
		return result;
	}
}
