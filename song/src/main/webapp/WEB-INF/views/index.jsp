<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link rel="stylesheet" href="/css/style.css">
<script>
let m = '${param.msg}';
	if(m!=''){
		alert(m);
	}
$(()=>{
	//bxSlider 설정용 스크립트
	$(".slider").bxSlider({
	    auto: true,
	    slideWidth: 600,
	})		
})

</script>
</head>
<body>
 <jsp:include page="./header.jsp"></jsp:include>
<section>
        <div class="content-home">
            <div class="slider">
                <div><img src="/img/Chrysanthemum.jpg"></div>
                <div><img src="/img/Desert.jpg"></div>
                <div><img src="/img/Lighthouse.jpg"></div>
                <div><img src="/img/Tulips.jpg"></div>
            </div>
        </div>
    </section>
 <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>