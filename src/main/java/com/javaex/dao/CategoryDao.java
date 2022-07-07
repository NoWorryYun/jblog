package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlsession;
	
	
	//category 리스트 받기
	public List<CategoryVo> cateList(String id){
		
		return sqlsession.selectList("category.cateList", id);
	}
	
}
