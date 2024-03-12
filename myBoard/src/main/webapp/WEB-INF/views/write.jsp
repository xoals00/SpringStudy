<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">유저 아이디 : ${userId}</h3>
<h1 align="center">글 작성</h1><br>
<div align="center">
<form action="/board/insert" method="post">
<input id = "bTitle" name="bTitle" type="text" placeholder="글 제목"><br>
<textarea id="bDetail" name ="bDetail" placeholder="글 내용" style="width: 300px; height: 300px;"></textarea><br>
<input type="hidden" value = "${userId}" id ="userId" name ="userId" >
<button>작성 완료</button>
</form>


</div>

</body>
</html>