<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<style>
.atag {    text-align: center;}

</style>
<body>
<h1>메인페이지</h1>
<%-- // ${pList} --%>
유저아이디 : ${userId} <form action="/board"><button>글 작성</button></form><a href="/logout">로그아웃</a>
<table border = "3" align = "center">

<thead>
<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>내용</th>

</thead>
<tbody>

<c:forEach var="item" items="${bDto}">
<tr>
<td>${item.bCnt}</td><td>${item.userId}</td><td onclick="readBoard(${item.bCnt})"><a href="#">${item.bTitle}</a></td><td>${item.bDetail}</td>
</tr>
</c:forEach>
</tbody>
</table>
<div style="text-align:center;">
<!-- <a > < </a> -->
<div id = "before"></div>

<c:if test="${paging.beforePage == 0}">   
<a href = "/main?nowPage=1"><<<</a>
</c:if>
 
 <c:if test="${paging.beforePage != 0}">   
 <a href = "/main?nowPage=${paging.beforePage}"><<<</a>
 </c:if>


<c:forEach var="pList" items="${page}">
	<a href="main?nowPage=${pList}" id="${pList}">[${pList}]</a>
</c:forEach>

<a href = "/main?nowPage=${paging.nextPage}">>>></a>
</div>




<script>
//let pList = document.getElementById('${pList}').value;
// console.log(pList)
function before(){
	location.href = "/main?nextPage="+1+"&nowPage="+${nowPage}
}
function readBoard(bCnt){
	location.href = "/read?bCnt="+bCnt
}
let m = '${msg}'
	if(m!=''){
		alert(m);
	}

function logout(){
	location.href = "/logout"
}

function nextPage(){
	let bodyHtml = "<a onclick='before()'> < </a>";
	$("#before").html(bodyHtml); 
	location.href = "/main?nextPage=0"+"&nowPage="+${nowPage}
	
}

</script>

</body>

</html>