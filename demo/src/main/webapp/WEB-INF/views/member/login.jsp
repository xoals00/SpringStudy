<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	const msg = '${msg}';
	if(msg!=='')
		alert(msg);
</script>
</head>
<body>
	<form action="/member/login" method="post">
		아이디:<input type="text" name="username">
		비밀번호:<input type="text" name="password">
		<button>로그인</button>
<%-- 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
	</form>
</body>
</html>