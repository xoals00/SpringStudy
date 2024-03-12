<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
	const msg = '${msg}';
	if(msg!=='')
		alert(msg);
</script>

<script>
$(document).ready(function(){
  	$("#login").click(function(){
    	location.href="/member/login";
  	});
  	
  	$('#logout').click(function() {  
		const form = `
			<form action="/member/logout" method="post">
			</form>
		`;  
		$(form).appendTo($('body')).submit();
	});
});
</script>
</head>
<body>
	<p>루트 페이지입니다</p>
	<sec:authorize access="isAuthenticated()">
		<div>
			<!--<span><sec:authentication property="principal" /></span><hr>-->
			<!-- <span><sec:authentication property="principal.Username" /></span>님 환영합니다<hr>-->
			<span><sec:authentication property="name" /></span>님 환영합니다
		</div>
	</sec:authorize>

	<ul>
		<li><a href="/member/anyone">누구나 접근가능</a></li>
		<li><a href="/member/anonymous">로그인 여부로 접근 제어(authentication)
				: 비로그인만 접근가능</a></li>
		<li><a href="/member/authenticated">로그인 여부로 접근
				제어(authentication) : 로그인만 접근가능</a></li>
		
		<li><a href="/member/user">권한으로 접근 제어(authorization) :
				ROLE_USER이상 접근가능</a></li>
		<!--  반드시 ROLE_ 붙일것. -->
		<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
		<li><a href="/member/admin">권한으로 접근 제어(authorization) :
				ROLE_ADMIN만 접근가능</a></li>
		</sec:authorize>		
		
		<li><a href="/board/list">board/list</a></li>
	</ul>

	<hr>
	<sec:authorize access="isAnonymous()">
		<button id="login" class="btn btn-primary">로그인으로</button>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<button id="logout" class="btn btn-warning">로그아웃</button>
	</sec:authorize>
</body>
</html>