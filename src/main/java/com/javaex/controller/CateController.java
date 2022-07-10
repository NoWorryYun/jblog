package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CateService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Controller
public class CateController {

	@Autowired
	private CateService cateService;
	
	//블로그 카테고리 등록
	@ResponseBody
	@RequestMapping(value="/admin/basic/updateCate", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBlogCate(   HttpSession httpsession,
									@RequestBody CategoryVo categoryVo) {
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		
		String authUserId = authUser.getId();
		String id = categoryVo.getId();
		if(authUserId != null && authUserId.equals(id)) {
			String state = cateService.addCate(categoryVo);
			
			return state;
		} else {
			return "redirect:./";
		}
	}
	
	//블로그 카테고리 삭제
	@ResponseBody
	@RequestMapping(value="/remove/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String removeCategory(@RequestBody CategoryVo categoryVo,
								 HttpSession httpsession) {
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		
		String authUserId = authUser.getId();
		String id = categoryVo.getId();
		if(authUserId != null && authUserId.equals(id)) {
			String state = cateService.removeCate(categoryVo);
			return state;
		} else {
			return "redirect:./";
		}
	}
	
	//카테고리 리스트 보내주기
	@ResponseBody
	@RequestMapping(value="/request/cateList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CategoryVo> cateList(@RequestBody String id) {
		System.out.println("cateList");
		List<CategoryVo> cList = cateService.cateList(id);
		System.out.println(cList);
		return cList;
	}
}
