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
<body>
<h1 align = "center">Board Page             <div id="userId"></div> </h1>
<button id="loginbtn" name="loginbtn" style="float: right;" style="display : block;" onclick="login()" >로그인</button>
<button id="joinbnt" name="joinbnt" onclick="join()" style="float: right;">회원가입</button>
<!-- 로그인 시 세션 아이디 -->

<!-- 로그인 시 로그아웃 버튼 생성 -->
<div id = "logout"></div>
<button id="write" name="write"><a href="/write">글 작성</a></button>


<table border = "5" align = "center" >
<thead>
<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>내용</th>

</thead>
<tbody>

<c:forEach var="item" items="${bDto}">
<tr>

<td>${item.bCnt}</td>
<td>${item.userId}</td>
<%-- <td onclick="readBoard(${item.bCnt})">${item.bTitle}</td> --%>
<td><a href = "/board/read?bCnt=${item.bCnt}">${item.bTitle}</a></td>
<td>${item.bDetail}</td>
</tr>
</c:forEach>
</tbody>
</table>
<div style="text-align:center;">
<!-- <a > < </a> -->
<div id = "before"></div>

<c:if test="${paging.beforePage == 0}">   
<a href = "/board?nowPage=1"><<<</a>
</c:if>
 
 <c:if test="${paging.beforePage != 0}">   
 <a href = "/board?nowPage=${paging.beforePage}"><<<</a>
 </c:if>


<c:forEach var="pList" items="${page}">
	<a href="board?nowPage=${pList}" id="${pList}">[${pList}]</a>
</c:forEach>

<a href = "/board?nowPage=${paging.nextPage}">>>></a>
</div>


</body>
<script type="text/javascript">
function readBoard(bCnt){
	location.href = "/board/read?bCnt="+bCnt
}

function login(){
	location.href = "/login"
	
}

function join(){
	location.href = "/join"
	
}
function logout(){
	location.href = "/logout"
}
</script>
<script type="text/javascript">

$(document).ready(function () {
	let userId = '${userId}' // 세션아이디
	data = {'userId' : userId}
	let str = ""
	let newbtn = ""
	$.ajax({
		type : 'post',
		url : '/check/userId',
		data : data,
		
		success : function(res){
			console.log(res)
			if(res == ""){
				$('#loginbtn').show();
				$('#joinbnt').show();
				str = ""
			}else{
				str ="유저아이디:"+res
				newbtn = "<button onclick = 'logout()'>로그아웃</button>"
				$('#loginbtn').hide()
				$('#joinbnt').hide()
			}
			$('#userId').html(str)
			$('#logout').html(newbtn)
			
		}
		
	})
	
})
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
//url 이동 스크립트
</script> 

</html>