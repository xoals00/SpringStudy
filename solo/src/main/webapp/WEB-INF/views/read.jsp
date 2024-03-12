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
<input type="hidden" value = "${bDto.bCnt}" id ="bCnt" name = "bCnt">
<h1>글 읽기</h1>
유저아이디 : ${userId} <br><br>


글 작성자: ${bDto.userId} <br>
글번호 : ${bDto.bCnt}	<br>
글제목 : ${bDto.bTitle}	<br>

<span id = "bDetail1">글내용 : ${bDto.bDetail}</span>
 	<input type="text" value = "${bDto.bDetail}" id ="bDetail" name = "${bDetail}" style="display : none;">
<button id ="modify">글 수정</button>


<script>
$('#modify').on("click",function(){
	 let userId = document.getElementById('userId').value;
	 let bCnt = document.getElementById('bCnt').value;
		console.log(userId)
		console.log('${bDto.userId}')
		if (userId == '${userId}'){
			$('#bDetail').css("display","block")
			$('#bDetail1').hide()
// 			   $('#(아이디명)').css('display', 'block');
// 		location.href = "/board/update?bCnt="+bCnt
		}else{
			alert("글 작성자가 아닙니다.");
		}
	
	
})


</script>
</body>
</html>