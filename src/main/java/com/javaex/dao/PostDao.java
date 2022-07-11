package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	
	@Autowired
	private SqlSession sqlsession;
	
	//포스트 리스트
	public List<PostVo> postList (int cateNo){
		
		return sqlsession.selectList("post.postList", cateNo);
	}
	
	//포스트 글쓰기
	public int write(PostVo postVo) {
		
		return sqlsession.insert("post.write", postVo);
	}
	
	//최신 카테고리
	public int maxCateNo() {
		return sqlsession.selectOne("post.maxCateNo");
	}

	//포스트 읽기
	public PostVo postRead(int postNo) {
		return sqlsession.selectOne("post.postRead", postNo);
	}
	
	//최신 카테고리
	public int maxPostNo(int cateNo) {
		return sqlsession.selectOne("post.maxPostNo");
	}
	
}
