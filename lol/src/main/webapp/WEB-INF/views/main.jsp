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

<h1>회원 아이디: ${userId}</h1>
<a href="/member/input">글내용 작성하기</a>
<a href ="/logout">로그아웃</a>




<table border = "3" align = "center">


<thead>
<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>내용</th>

</thead>

<tbody>



<c:forEach var="item" items="${bSer}" >
<tr>
  <td>${item.bCnt}</td> <td>${item.userId}</td> <td onclick="readBoard(${item.bCnt})"><a href="#">${item.bTitle}</a></td>  <td>${item.bDetail}</td>
</tr>
</c:forEach>


</tbody>



</table>















<script>
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
function readBoard(bCnt){
	 location.href = "/board/read?bCnt="+bCnt
} 
</script>



</body>

</html>