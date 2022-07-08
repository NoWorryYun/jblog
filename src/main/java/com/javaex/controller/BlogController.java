package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController > blogMain");
		System.out.println(id);
		
		Map<String, Object> bMap = blogService.blogAllData(id);
		
		System.out.println(bMap);
		
		model.addAttribute("bMap",bMap);
		
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/admin/basic", method = {RequestMethod.GET,RequestMethod.POST})
	public String blogManager(@PathVariable("id") String id, Model model, HttpSession httpsession) {
		
		BlogVo blogTitle = blogService.blogTitle(id);
		String blogId = blogTitle.getId();
		UserVo authUser = (UserVo)httpsession.getAttribute("authUser");
		String authId = authUser.getId();
		System.out.println("blogId : " +blogId);
		System.out.println("authId : "+authId);
		
		if(authId.equals(blogId)) {
			model.addAttribute("blogTitle", blogTitle);
			
			return "blog/admin/blog-admin-basic";
		} else {
			return "redirect:../../";
		}
	
	}
	
	@RequestMapping(value="/{id}/admin/basic/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBlogDefault(@PathVariable("id") String id,
									@RequestParam("file") MultipartFile file,
									HttpSession httpsession,
									@RequestParam("blogTitle") String blogTitle) {
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		
		System.out.println("bCont :" + file);
		System.out.println("bCont :" + authUser);
		String authUserId = authUser.getId();
		
		if(authUserId != null && authUserId.equals(id)) {
			blogService.save(file, id, blogTitle);
		} else {
			
		}
		return "redirect:./";
	}
}
