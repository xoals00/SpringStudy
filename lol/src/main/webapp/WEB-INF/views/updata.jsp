<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  action="/board/reload" method="post">
<input name="bTitle" id="bTitle" type="text" placeholder="수정할 글 제목">
<input name="bDetail" id="bDetail" type="text" placeholder="수정할 글 내용">
<input type = "hidden" id = "userId" value="">
<button>글 수정완료</button>
</form>
<button onclick = "boardUpdataReal()">작성자와 같은지 확인</button>
<script>
function boardUpdataReal(){
	
	if('${userId}' == '${dDto.userId}'){
	console.log("같다")		
	}else{
		console.log("다르다")
	}
	location.href = "/board/reload?data="+data
}
</script>
</body>
</html>