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
<h1>글 작성</h1>
유저아이디 : ${userId} <br><br><br>

<form action="/board/info?nowPage=1" method="post">
<input id = "bTitle" name="bTitle" type="text" placeholder="글 제목"><br>
<textarea id="bDetail" name ="bDetail" placeholder="글 내용"></textarea><br>
<input type="hidden" value = "${userId}" id ="userId" name ="userId" >
<button>작성 완료</button>
</form>


</body>
<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}

</script>
</html>