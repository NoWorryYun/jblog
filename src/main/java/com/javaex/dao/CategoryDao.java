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
	
	
	public List<CategoryVo> cateListAll(){
		System.out.println("cateDao");
		return sqlsession.selectList("category.cateListAll");
	}
	
	
	//category 리스트 받기(부분)
	public List<CategoryVo> cateList(String id){
		
		return sqlsession.selectList("category.cateList", id);
	}
	
	//category 추가
	public int addCate(CategoryVo categoryVo) {
		
		return sqlsession.insert("category.addCate", categoryVo);
	}
	
	//category 삭제
	public int removeCate(CategoryVo categoryVo) {
		
		return sqlsession.delete("category.removeCategory", categoryVo);
	}
}
