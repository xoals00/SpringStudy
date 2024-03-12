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
<h1>내용</h1>
글 작성자 :${bdto.userId}
글번호 : ${bdto.bCnt}
글제목 : ${bdto.bTitle}
글내용 :${bdto.bDetail}

<button onclick = "boardUpdata()">글 수정</a></button>
<%-- <button onclick="boardUpdata(${bdto.userId})">글 수정</button> --%>


<button onclick = "boardUpdataReal()">작성자와 같은지 확인</button>
<script>
function boardUpdataReal(){
	
	if('${userId}' == '${bdto.userId}'){
	console.log("같다")		
	}else{
		console.log("다르다")
	}
	
}
</script>
<script>
function boardUpdata(){
	let userId = '${bdto.userId}'
	console.log(userId)
	location.href = "/board/updata?userId="+userId
}
</script>
</body>
</html>