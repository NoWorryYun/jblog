package com.javaex.controller;

import java.util.List;
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
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private PostService postService;
	// 블로그 메인
	@RequestMapping(value = {"/{id:(?!assets|upload).*}", "/{id:(?!assets|upload).*}/{cateNo}", "/{id:(?!assets|upload).*}/{cateNo}/{postNo}"}, method = { RequestMethod.GET, RequestMethod.POST })
	public String blogMain( @PathVariable("id") String id,
							@PathVariable(value="cateNo", required = false) Integer cateNo,
							@PathVariable(value="postNo", required = false) Integer postNo,
							Model model) {
		System.out.println("BlogController  =  main");
		Map<String, Object> bMap = blogService.blogAllData(id);

		model.addAttribute("bMap", bMap);

		List<PostVo> postList = postService.postList(cateNo);
		
		model.addAttribute("postList", postList);
		
		PostVo postRead = postService.postRead(cateNo, postNo);
		
		model.addAttribute("postRead", postRead);
		
		return "blog/blog-main";
	}

	// 블로그 타이틀 관리
	@RequestMapping(value = "/{id}/admin/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogDefaultManager(@PathVariable("id") String id, Model model, HttpSession httpsession) {

		BlogVo blogTitle = blogService.blogTitle(id);
		String blogId = blogTitle.getId();
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		String authId = authUser.getId();

		if (authId.equals(blogId)) {
			Map<String, Object> bMap = blogService.blogAllData(id);

			model.addAttribute("bMap", bMap);

			return "blog/admin/blog-admin-basic";
		} else {
			return "redirect:../../";
		}

	}

	// 블로그 관리 업데이트
	@RequestMapping(value = "/{id}/admin/basic/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateBlogDefault(@PathVariable("id") String id, @RequestParam("file") MultipartFile file,
			HttpSession httpsession, @RequestParam("blogTitle") String blogTitle) {
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");

		String authUserId = authUser.getId();

		if (authUserId != null && authUserId.equals(id)) {
			blogService.save(file, id, blogTitle);
		} else {

		}
		return "redirect:./";
	}

	// 블로그 카테고리 관리
	@RequestMapping(value = "/{id}/admin/category", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogCategoryManager(@PathVariable("id") String id, Model model, HttpSession httpsession) {

		BlogVo blogTitle = blogService.blogTitle(id);
		String blogId = blogTitle.getId();
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		String authId = authUser.getId();
		if (authId.equals(blogId)) {
			Map<String, Object> bMap = blogService.blogAllData(id);

			model.addAttribute("bMap", bMap);

			return "blog/admin/blog-admin-cate";
		} else {
			return "redirect:../../";
		}
	}

	// 블로그 글작성 관리
	@RequestMapping(value = "/{id}/admin/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogWriteManager(@PathVariable("id") String id, Model model, HttpSession httpsession) {

		BlogVo blogTitle = blogService.blogTitle(id);
		String blogId = blogTitle.getId();
		UserVo authUser = (UserVo) httpsession.getAttribute("authUser");
		String authId = authUser.getId();
		if (authId.equals(blogId)) {
			Map<String, Object> bMap = blogService.blogAllData(id);

			model.addAttribute("bMap", bMap);

			return "blog/admin/blog-admin-write";
		} else {
			return "redirect:../../";
		}
	}
}
