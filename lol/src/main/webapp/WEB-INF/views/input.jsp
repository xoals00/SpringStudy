<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>회원 아이디: ${userId}</h4>
<h1>글쓰기</h1>

<form action="/board/dataInput" method="post">
<input name="bTitle" id="bTitle" type="text" placeholder="글제목">
<input name="bDetail" id="bDetail" type="text" placeholder="글내용">
<button>글 작성</button>
</form>








</body>
</html>