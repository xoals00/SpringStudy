<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	일반 사용자이상(ROLE_USER, ROLE_ADMIN)만 접근가능
	<a href="/">루트로</a>
	<form action="/member/logout" method="post">
		<button >로그아웃</button>
	</form>
</body>
</html>