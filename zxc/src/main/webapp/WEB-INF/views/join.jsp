<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/member/join" method="post">
		<input name="userId" id="userId" type="text" placeholder="아이디"><span id = "idflag"></span><br>
		<input name="userPw" id="userPw" type="password" placeholder="비밀번호">
		<button>회원가입</button>
	</form>
</body>


<script>
	let m = '${msg}'
	if (m != '') {
		alert(m);
	}
	console.log(m)

	$('#userId').keyup(function() {

		let userId = $('#userId').val();
		data = { 'userId' : userId }
		let str=''
		
		$.ajax({
			type : 'post',
			url : '/checkId',
			data : data,	

			success : function(res) {

				if(res){
					str = "중복입니다."
// 					console.log("중복입니다.")
				}else{
					str = "사용가능합니다."
// 					console.log("사용가능합니다.")
					//사용가능합니다.
				}
				$('#idflag').html(str)
				
				
			}
		})
	})
</script>

</html>