<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp</h1>
<form action="/member/login" method="Post">
	<input id="id" name = "userId" type="text"  placeholder="아이디">
	<input id="pw" name = "userPw" type="password"  placeholder="비밀번호">
	<button>로그인</button>
</form>

</body>
</html>