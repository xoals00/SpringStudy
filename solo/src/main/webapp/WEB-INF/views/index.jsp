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
<h1>index.jsp</h1>

<a href="/login">로그인</a>

<a href="/join">회원가입</a>

</body>
<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
console.log(m)
</script>
</html>