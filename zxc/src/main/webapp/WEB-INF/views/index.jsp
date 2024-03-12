<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index 페이지</h1>
<form action="/login">
<button>로그인</button>
</form>

<form action="/join">
<button>회원가입</button>
</form>
<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
 console.log(m)
</script>
</body>
</html>