<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>re / request.jsp</title>
</head>
<body>

request.do 요청에 의한 뷰페이지 <br>

사용자 입력값
<hr>
아이디 : ${memberVO.id} <br>
이름 : ${param.name} <br>
나이 : ${vo.age} <br>
<!-- 
	// 값을 가져올때는 param이나 클래스명(객체명)으로 가져와야 한다. 바로 별칭으로 가져올 수는 없다.
	// 별칭으로 가져오고 싶다면
	// @ModelAttribute("vo") 를 해줘야 별칭으로 가져올 수 있다.
	// 대신에 별칭으로 가져오면 클래스명(객체명)으로는 가져올 수 없다.
	// 별칭이나 클래스명, 둘 중에 선택해서 사용해야 한다.
-->

</body>
</html>