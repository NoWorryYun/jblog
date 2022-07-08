package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CateService;
import com.javaex.vo.UserVo;

@Controller
public class CateController {

	@Autowired
	private CateService cateService;
	
	//블로그 카테고리 등록
	@ResponseBody
	@RequestMapping(value="/{id}/admin/basic/updateCate", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBlogCate(@PathVariable("id") String id,
									HttpSession httpsession,
									@RequestParam("blogTitle") String blogTitle) {
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		
		String authUserId = authUser.getId();
		
		if(authUserId != null && authUserId.equals(id)) {
			
		} else {
			
		}
		return "redirect:./";
	}
}
