<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 수정</h1>
유저아이디 : ${userId}<br>

<form action="/update" method="post">
<input id = "bTitle" name="bTitle" type="text" placeholder="글 제목"><br>
<textarea id="bDetail" name ="bDetail" placeholder="글 내용"></textarea><br>
<input type="hidden" value = "${userId}" id ="userId" name ="userId" >
<input type="hidden" value = "${bCnt}" id ="bCnt" name ="bCnt" >
<button>수정하기</button>
</form>
</body>
</html>