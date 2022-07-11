<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">

		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="content" class="clearfix">
			<div id="profilecate_area">
				<div id="profile">
					
					<!-- 사용자 업로드 이미지 -->
					<c:choose>
					<c:when test="${bMap.blogTitle.logoFile != null}">
					<img id="proImg" src="${pageContext.request.contextPath}/upload/${bMap.blogTitle.logoFile}">
					</c:when>
					<c:otherwise>
					<img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
					</c:otherwise>
					</c:choose>
					
					<div id="nick">${bMap.blogTitle.userName}(${bMap.blogTitle.id})님</div>
				</div>
				<div id="cate">
					<div class="text-left">
						<strong>카테고리</strong>
					</div>
					<ul id="cateList" class="text-left">
					<c:forEach items="${bMap.cateList}" var="CategoryVo">
						<li><a href="${pageContext.request.contextPath}/${CategoryVo.id}/${CategoryVo.cateNo}">${CategoryVo.cateName}</a></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<!-- profilecate_area -->
			
			<div id="post_area">
				<c:choose>
				<c:when test="${postRead != null}">
				<div id="postBox" class="clearfix">
						<div id="postTitle" class="text-left"><strong>${postRead.postTitle}</strong></div>
						<div id="postDate" class="text-left"><strong>${postRead.regDate}</strong></div>
						<div id="postNick">${bMap.blogTitle.userName}님</div>
				</div>
			
				<div id="post" >
					${postRead.postContent}
				</div>
				</c:when>
				<c:otherwise>
				<div id="postBox" class="clearfix">
							<div id="postTitle" class="text-left"><strong>등록된 글이 없습니다.</strong></div>
							<div id="postDate" class="text-left"><strong></strong></div>
							<div id="postNick"></div>
				</div>
				</c:otherwise>
				</c:choose>
				<div id="post" >
				</div>
				
				<div id="list">
					<div id="listTitle" class="text-left"><strong>카테고리의 글</strong></div>
					<table>
						<colgroup>
							<col style="">
							<col style="width: 20%;">
						</colgroup>
						<c:forEach items="${postList}" var="PostVo">
						<tr>
							<td class="text-left"><a href="${pageContext.request.contextPath}/${PostVo.id}/${PostVo.cateNo}">${PostVo.postTitle}</a></td>
							<td class="text-right">${PostVo.regDate}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<!-- //list -->
			</div>
			<!-- //post_area -->
			
			
			
		</div>	
		<!-- //content -->
		<div class=></div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
	
	
	</div>
	<!-- //wrap -->
</body>
</html>