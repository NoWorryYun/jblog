<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="center-content">

		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- 메인 해더 -->


		<div>
			<form id="joinForm" method="post"
				action="${pageContext.request.contextPath}/user/join">
				<table>
					<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
					<tr>
						<td><label for="txtId">아이디</label></td>
						<td><input id="txtId" type="text" name="id"></td>
						<td><button id="btnIdCheck" type="button">아이디체크</button></td>
					</tr>
					
					<tr>
						<td></td>
						<td id="tdMsg" colspan="2"></td>
					</tr>
					<tr>
						<td><label for="txtPassword">패스워드</label></td>
						<td><input id="txtPassword" type="password" name="password" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="txtUserName">이름</label></td>
						<td><input id="txtUserName" type="text" name="userName" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><span>약관동의</span></td>
						<td colspan="3"><input id="chkAgree" type="checkbox"
							name="agree" value="y"> <label for="chkAgree">서비스
								약관에 동의합니다.</label></td>
					</tr>
				</table>
				<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit">회원가입</button>
				</div>

			</form>

		</div>


		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- 메인 푸터  자리-->

	</div>
<input id="idCheckOk" type="hidden" value="">
</body>
<script type="text/javascript">

$("#joinForm").on("submit", function(){
	
	var id = $("#txtId").val();
	var password = $("#txtPassword").val();
	var name = $("#txtUserName").val();
	var idCheckOk = $("#idCheckOk").val();
	if(id == "" || id == null){
		alert("아이디를 입력해주세요");
		return false;
	}
	
	if(password == "" || password == null){
		alert("비밀번호를 입력해주세요");
		return false;
	}

	if(name == "" || name == null){
		alert("이름을 입력해주세요");
		return false;
	}
	
	if(idCheckOk == "" || idCheckOk == null){
		alert("아이디를 확인해 주세요.");
		return false;
	} else if(idCheckOk == "NOK"){
		alert("아이디를 확인해 주세요.");
		return false;
	} else {
		
	}

	//약관동의
	var agree = $("#chkAgree").is(":checked");
	if(agree == false){
		alert("약관동의를 체크해주세요");
		return false;
	}
})
$("#btnIdCheck").on("click", function(){
	var id = $("#txtId").val();
	
	console.log(id);

	$.ajax({

		url : "${pageContext.request.contextPath }/user/idCheck",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(id),

		dataType : "json",
		success : function(result) {
			/*성공시 처리해야될 코드 작성*/
			if(id == "" || id == null) {
				$("#tdMsg").text("아이디를 입력해 주세요");
				$("#idCheckOk").val("NOK");
			} else if(result == "fail") {
				$("#tdMsg").text("다른 아이디로 가입해 주세요.");
				$("#txtId").val("");
				$("#idCheckOk").val("NOK");
			} else if(result =="success"){
				$("#tdMsg").text("사용할 수 있는 아이디 입니다.");
				$("#idCheckOk").val("OK");
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	})
})
</script>

</html>