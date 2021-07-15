<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_form.jsp</title>
</head>
<body>

폼의 입력값들 여기에 출력하기
<hr>
param.아이디 : ${param.id} <br>
param.이름 : ${param.name} <br>
param.나이 : ${param.age} <br>
MemverVO.아이디 : ${MemverVO.id} <br>
MemverVO.이름 : ${MemverVO.name} <br>
MemverVO.나이 : ${MemverVO.age} <br>
vo.아이디 : ${vo.id} <br>
vo.이름 : ${vo.name} <br>
vo.나이 : ${vo.age} <br>

<hr>

${sessionScope.login}


</body>
</html>