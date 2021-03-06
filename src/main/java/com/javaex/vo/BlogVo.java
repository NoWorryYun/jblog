package com.javaex.vo;

public class BlogVo {

	// 일반
	private String id;
	private int cateNo;
	private int postNo;
	private String blogTitle;
	private String logoFile;
	private String cateName;
	private String postTitle;
	private String postContent;
	private String regDate;
	private String userName;
	private int count;

	// 생성자
	public BlogVo() {
		super();
	}

	public BlogVo(String id) {
		super();
		this.id = id;
	}
	
	public BlogVo(String id, String logoFile) {
		super();
		this.id = id;
		this.logoFile = logoFile;
	}

	public BlogVo(String id, String blogTitle, String logoFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}

	public BlogVo(String id, int cateNo, int postNo) {
		super();
		this.id = id;
		this.cateNo = cateNo;
		this.postNo = postNo;
	}

	public BlogVo(String id, String blogTitle, String logoFile, String cateName, String postTitle, String postContent,
			String regDate) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.cateName = cateName;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
	}

	public BlogVo(String id, String blogTitle, String logoFile, String cateName, String postTitle, String postContent,
			String regDate, String userName) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.cateName = cateName;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
		this.userName = userName;
	}

	public BlogVo(String id, String blogTitle, String logoFile, String cateName, String postTitle, String postContent,
			String regDate, String userName, int count) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.cateName = cateName;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
		this.userName = userName;
		this.count = count;
	}

	// GS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	// 일반
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogNo=" + cateNo + ", postNo=" + postNo + ", blogTitle=" + blogTitle
				+ ", logoFile=" + logoFile + ", cateName=" + cateName + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + ", userName=" + userName + ", count=" + count + "]";
	}

}
