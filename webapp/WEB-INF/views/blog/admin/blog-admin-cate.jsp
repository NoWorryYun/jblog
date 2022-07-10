<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
		

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath }/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath }/${authUser.id}/admin/write">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="cateName" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		<!-- 개인블로그 푸터 -->
		
	<input type="hidden" name="authUserId" value="${authUser.id}">
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">

$(document).ready(function() {
	//console.log("jquery로 data만 받는 요청");

	fetchList();
});

	$("#btnAddCate").on("click", function(){
		
		
		var cateName = $("#admin-cate-add [name = 'cateName']").val();
		var description = $("#admin-cate-add [name = 'desc']").val();
		var id = $("[name = 'authUserId']").val();
		
		var categoryVo = {
				id : id,
				cateName : cateName,
				description : description
		}
		
		$.ajax({

			url : "${pageContext.request.contextPath }/admin/basic/updateCate",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(categoryVo),

			dataType : "json",
			success : function(state) {
				/*성공시 처리해야될 코드 작성*/
				$("#cateList").empty();
			 	fetchList();
				//render(categoryVo, "up");
				
				 $("#admin-cate-add [name = 'cateName']").val("");
				 $("#admin-cate-add [name = 'desc']").val("");
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	})
	
	//리스트 요청
	function fetchList() {
		
		var id = $("[name = 'authUserId']").val();
		
		$.ajax({
			
			url : "${pageContext.request.contextPath }/request/cateList",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(id),

			dataType : "json",
			success : function(cList) {
				
				console.log(cList);
				//화면에 data + html을 그린다.
				
				for (var i = 0; i < cList.length; i++) {
					render(cList[i], "up"); //vo --> 화면에 그린다
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		});
	};
	
	//리스트그리기
	function render(categoryVo, opt) {

		console.log("render()");
	   
		var str = "";

		str += '<tr id="cateListNo'+ categoryVo.cateNo +'">';
		str += '<td>' + categoryVo.rn + '</td>';
		str += '<td>' + categoryVo.cateName + '</td>';
		str += '<td>' + categoryVo.count + '</td>';
		str += '<td>' + categoryVo.description + '</td>';
		str += "<td class='text-center'>";
		str += '<img class="btnCateDel" data-no="'+ categoryVo.cateNo +'" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
		str += " </td>"
		str += " </tr>"

		if (opt == "down") {
			$("#cateList").append(str);

		} else if (opt = "up") {
			$("#cateList").prepend(str);
		} else {
			console.log("opt오류");
		}

	};

	//삭제버튼
	$("#cateList").on("click", ".btnCateDel", function(){
		var $this = $(this);
		console.log($this);
		var cateNo = $this.data("no");
		var id = $("[name = 'authUserId']").val();
		console.log(cateNo);
		console.log(id);
		
		var categoryVo = {
				cateNo : cateNo,
				id : id
		}
		
		$.ajax({

			url : "${pageContext.request.contextPath }/remove/category",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(categoryVo),

			dataType : "json",
			success : function(state) {
				/*성공시 처리해야될 코드 작성*/
				console.log(state);

				//성공
				if (state == "success") {
					$("#admin-cate-list #cateListNo" + cateNo).remove();
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
		
	})
</script>



</html>