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
<h1>회원가입 페이지</h1>
</body>
<form action="/member/join" method="post">
<input id="userId" name ="userId" type="text" placeholder="아이디"><span id = "checkId"></span><br>
<input id="userPw" name ="userPw" type="password" placeholder="비밀번호">
<button id="joinbnt">회원가입</button>
<!-- <input type="button" value="회원가입" id="joinbnt"> -->
</form>

<script type="text/javascript">

	console.log(userId)
$('#userId').keyup(function () {
	let userId = $('#userId').val();
	data = { 'userId' : userId }
	let str=''
	
	
	$.ajax({
		type : 'post',
		url : '/join/idCheck',
		data : data,
		
		success : function(res){
			
			if(res){
				str ="중복된 아이디 입니다."
				$('#joinbnt').prop('disabled', true);
			}else{
				 $('#joinbnt').prop('disabled', false);
				str = "사용가능한 아이디 입니다."
			}
			$('#checkId').html(str)
			
		}	
	})
})
// $('#userPw').keyup(function () {
// 	let userPw = $('#userPw').val();
// 	let str=''
	
// 	if(userPw >)
// })
let m = '${msg}'
	if (m != '') {
		alert(m);
	}
	console.log(m)
</script>
</html>