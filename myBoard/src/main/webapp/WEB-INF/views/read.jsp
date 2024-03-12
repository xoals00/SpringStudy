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
<input type="hidden" value = "${bDto.userId}" id ="userId">
<div align="center">
<h1>글 읽기</h1>
<div align="right">
<div id="loginbtn"><button onclick="login()">로그인</button></div>
<button onclick="board()">돌아가기</button>
</div>

<h3>유저아이디 : ${userId} </h3><br>
글번호 : <input id = "bCnt" value="${bDto.bCnt}"  disabled="disabled"><br>
작성자 : <input id = "userId" value="${bDto.userId}"  disabled="disabled"><br>
<span id = "bTitle">글제목 : ${bDto.bTitle}</span><br>
<span>글내용</span><br>

	<textarea id="bDetail" name ="bDetail" style= " width: 300px; height: 300px;" disabled>${bDto.bDetail}</textarea><br>
</div>
<table align="center">


<th id = flag><button onclick="boardupdate()">수정</button></th>

<td></td><td></td><td></td>
<td></td><td></td><td></td>

<th><button onclick="comment()">댓글</button></th>

<td></td><td></td><td></td>
<td></td><td></td><td></td>

<th><button onclick = "boarddelete()">삭제</button></th>
</table>
<c:if test="${bCom  != null}">
<table border = "3" align = "center" id="commentTable">
<c:forEach var="item" items="${bCom}">
<tr>
<td>${item.cCnt}</td>
<td>${item.userId}</td>
<td>${item.cDetail}</td>
</tr>
</c:forEach>
</table>
</c:if>
<div id = "commentdiv"></div>
</body>
<script defer="defer" type="text/javascript">
let m = '${msg}'
	if(m!=''){
		alert(m);
	}
let userId = document.getElementById('userId').value; // 게시글 아이디
$(document).ready(function () { 
	if('${userId}' == ""){
		$('#loginbtn').show();
	}else{
		$('#loginbtn').hide();
	}
})
function comment(){
	str1 = ''
	str1 = "<table align = 'center' border = '2' id ='commentTh'></table>"
	$('#commentdiv').html(str1)
	str2= "<span>유저아이디 :"+userId+"</span>"
	$('#commentTh').html(str2)
	str3 = "<span><input id='cDetail' name='cDetail' type='text'><input type='button' value='작성완료' onclick='commentUpdate()'></span>"
	$('#commentTh').append(str3)
}
function commentUpdate(){
	let userId = '${userId}'
	let bCnt = document.getElementById('bCnt').value;
	let cDetail = document.getElementById('cDetail').value;
	console.log(userId)
	console.log(bCnt)
	console.log(cDetail)
	location.href = "/comment/update?userId="+userId+"&bCnt="+bCnt+"&cDetail="+cDetail
}

function boardupdate(a){
	str=''
	if(userId == '${userId}'){
		$('#bDetail').attr("disabled", false);
		str = "<input type = 'button' value = '수정완료' id = 'modify' onclick='modify()'/>"
		$('#flag').html(str);		
	}else{
		alert('글 작성자가 아닙니다.')
	}
	
}
function modify(){// 글 수정	
	let bCnt = document.getElementById('bCnt').value;
	let bDetail = document.getElementById('bDetail').value;
	console.log(bCnt)
	console.log(bDetail)
	location.href = "/board/update?bCnt="+bCnt+"&bDetail="+bDetail
}
function boarddelete(){
	if(userId == '${userId}'){
		let bCnt = document.getElementById('bCnt').value;
		location.href = "/board/delete?bCnt="+bCnt
	}else{
		alert('글 작성자가 아닙니다.')
	}
}
function login(){
	location.href = "/login"
}
function board(){
	location.href = "/board?nowPage=1"
}
</script>
</html>