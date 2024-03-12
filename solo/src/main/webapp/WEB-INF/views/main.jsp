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
<h1>main.jsp</h1>
유저아이디 : ${userId}<br>

<form action="/board/info" method="post">
<input id = "bTitle" name="bTitle" type="text" placeholder="글 제목"><br>
<textarea id="bDetail" name ="bDetail" placeholder="글 내용"></textarea><br>
<button>글쓰기</button>
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