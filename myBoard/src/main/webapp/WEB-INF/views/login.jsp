<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
<h1>로그인 페이지</h1>

<form action="/member/login" method="post">
<input type="text" id="userId" name="userId" placeholder="아이디">
<input type="password" id="userPw" name="userPw" placeholder="비밀번호">
<button>로그인</button>
</form>
<a href="/join">회원가입 하러가기</a>
</body>
<script type="text/javascript">
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
</script>
</html>