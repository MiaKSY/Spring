<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- 반복문을 쓰기 위해서 jstl을 불러왔다. -->
<!-- jstl -->

<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!-- 만약에 jstl이 잘 불려오지 않는다면
		1) (자동이었을 경우)pom.xml에 Test주석 위에 jstl이 있는지 확인
		2) 안된다면, WEB-INF 안에 lib 폴더를 만들고
			그 안에 jstl.jar 과 standard.jar 넣어주기  -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multiInsert.jsp</title>
</head>
<body>

<h3>멤버 목록 보기</h3>

<table>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
	</tr>
	
	<!-- jstl 불러오고 반복문 + 조건문-->
	<c:forEach var='vo' items='${memberVOList.list}'>
		<c:if test="${vo.state}">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
			</tr>
		</c:if>
	</c:forEach>
</table>

</body>
</html>