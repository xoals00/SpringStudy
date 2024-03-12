<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/member/join">
 <input name="userId" id="userId" type="text">
 <input name="userPw" id="userPw" type="password">
 <button>회원가입</button>
</form>
<a href="/login">로그인</a>
</body>
<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
</script>
</html>