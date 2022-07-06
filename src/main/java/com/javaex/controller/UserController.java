package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//회원가입폼
	@RequestMapping(value="user/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("Controller > joinForm");
		
		return "user/joinForm";
	}
	
	//회원가입시도
	@RequestMapping(value="user/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {

		System.out.println("Controller > join");
		
		userService.join(userVo);
		
		return "user/joinSuccess";
	}
	
	//로그인폼
	@RequestMapping(value="user/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("Controller > loginForm");
		
		return "user/loginForm";
	}
	
	//로그인시도
	@RequestMapping(value="user/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login() {
		System.out.println("Controller > login");
		
		return "";
	}
	
}
