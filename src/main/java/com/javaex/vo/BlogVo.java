package com.javaex.vo;

public class BlogVo {

	//일반
	private String id;
	private String blogTitle;
	private String logoFile;
	private String cateName;
	private String postTitle;
	private String postContent;
	private String regDate;
	
	
	//생성자
	public BlogVo() {
		super();
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

	
	//GS
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

	
	
	//일반
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + ", cateName=" + cateName
				+ ", postTitle=" + postTitle + ", postContent=" + postContent + ", regDate=" + regDate + "]";
	}


	
	
}
