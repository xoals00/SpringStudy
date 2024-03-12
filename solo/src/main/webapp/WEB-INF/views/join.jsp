<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form action="/member/join" method="post">
<input name = "userId" id="userId" type="text" placeholder="아이디">
<input name = "userPw" id="userPw" type="password" placeholder="비밀번호">
<button>회원가입</button>
</form>



</body>
</html>