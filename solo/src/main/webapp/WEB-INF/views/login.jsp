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
<h1>login.jsp</h1>
<form action="/member/login" method="post">
<input name="userId" id="userId" type="text" placeholder="아이디"><br>
<input name="userPw" id="userPw" type="password" placeholder="비밀번호">
<button>로그인</button>
</form>

</body>
<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
 console.log(m)
</script>

</html>