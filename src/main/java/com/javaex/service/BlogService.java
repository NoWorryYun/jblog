package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	/*
	//블로그 전체정보 (보류)
	public List<BlogVo> blogData(String id) {

		List<BlogVo> data = blogDao.blogData(id);
		
		System.out.println(data);
		
				System.out.println(data);
		return data;
	}
	*/
	
	//블로그 정보받기(Title)
	public BlogVo blogTitle(String id) {
		BlogVo blogTitle = blogDao.blogTitle(id);
		return blogTitle;
	}
	
	//블로그 정보받기(메인용)
	public Map<String, Object> blogAllData(String id) {
		
		BlogVo blogTitle = blogDao.blogTitle(id);
		List<CategoryVo> cateList = categoryDao.cateList(id);
		
		Map<String, Object> bMap = new HashMap<String, Object>();
		
		bMap.put("blogTitle", blogTitle);
		bMap.put("cateList", cateList);
		
		return bMap;
	}
	
	//블로그 이미지 업로드
	public String save(MultipartFile file, String id, String blogTitle) {
		
		//파일 디렉토리
		String saveDir = "C:\\javaStudy\\upload";
		
		//파일명 받아오기
		String orgName = file.getOriginalFilename();
		
		//확장자지정
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장될 파일 이름 지정 (현재시간 + 랜덤이름 + 확장자)
		String logoFile = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일 저장 경로(저장이름 추가)
		String filePath = saveDir + "\\" + logoFile;
		
		BlogVo blogVo = new BlogVo(id, blogTitle, logoFile);
		
		
		System.out.println("sv" + blogVo);
		
		//DB에 저장
		blogDao.blogImg(blogVo);
		
		//하드디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			os.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return logoFile;
	}
	
}
