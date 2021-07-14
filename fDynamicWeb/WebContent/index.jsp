<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
</head>
<body>

오늘도 화이팅

<hr>

<!-- web.xml에서 우리가 서블릿으로 정해준대로, 
.do확장자가 들어왔을 때에 작업을 한다. -->
<a href="start.do">스프링 시작</a>
<!-- 콘솔에 start.do 요청됨 이 뜨는지가 중요하다!!! -->
<!-- 만약에 없다면 xml에서 빈을 만들었는지 의심해봐야 한다. -->



<!-- WebContent 밑에 있는 파일들은 사용자에게 다 보인다. 우리는 보안을 중요하게 생각하니까 

사용자가 접근을 하지 못하는 WEB-INF 아래에 폴더를 만들고 그 안에서 작업한다. 

그리고 우리가 controller.java에서 그 페이지를 보내주면 된다.-->


</body>
</html>