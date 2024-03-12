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
<h1>글읽기 보기</h1>
유저아이디 : ${userId} <br><br>


글번호 : <input id = "bCnt" value="${bDto.bCnt}"  disabled="disabled"><br>
작성자 : <input id = "userId" value="${bDto.userId}"  disabled="disabled"><br>
<span id = "bTitle">글제목 : ${bDto.bTitle}</span><br>
<span id = "newbDetail">글내용 : ${bDto.bDetail}</span><br>
<button id ="modify">글 수정</button> &nbsp; <button id="boardhide" onclick="boarddelete()">글 삭제</button> 
<input type="text" value = "${bDto.bDetail}" id ="bDetail" name = "${bDto.bDetail}" style="display : none;"><br>

<!-- 두번째 버튼 생성 -->

<div id = "mainDiv"></div>




<script>
		$('#modify').on("click", function() {
			let userId = document.getElementById('userId').value;
			if (userId == '${userId}') {
				$('#bDetail').css("display", "block")
				$('#newbDetail').hide()
				$('#boardhide').hide()
				$('#modify').hide()
				let bodyHtml = "<button onclick = 'aaa()'>글수정완료</button>";
				$("#mainDiv").html(bodyHtml);
			} else {
				alert("글 작성자가 아닙니다.");
			}
		})
		function aaa() {
			let bCnt = document.getElementById('bCnt').value;
			let bDetail = document.getElementById('bDetail').value;
			console.log(bCnt)
			console.log(bDetail)
		 	location.href = "/board/update?bCnt="+bCnt+"&bDetail="+bDetail+"&nowPage=1"
		}
		function boarddelete() {
			let userId = document.getElementById('userId').value;
			if(userId == '${userId}'){
				let bCnt = document.getElementById('bCnt').value;
				location.href = "/board/delete?bCnt="+bCnt+"&nowPage=1"				
			}else{
				alert("글 작성자가 아닙니다.");
			}
		}
	</script>
</body>
</html>