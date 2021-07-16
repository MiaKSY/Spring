<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 잊지말자@ -->    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진첩</title>
</head>
<body>


	<table border='1'>
	
		<thead>
			<tr>
				<th colspan="3">사진</th>
			</tr>
		</thead>

		<c:if test="${imageList.size()==0 }">
			<tfoot>
				<tr>
					<td colspan="3">사진첩에 사진이 한장도 없습니다.</td>
				</tr>
			</tfoot>
		</c:if>

		<tbody>
			<c:forEach items="${imageList }" var="board" varStatus="sta" step='3'>
				<tr>
					<c:forEach items="${imageList }" var="board" begin="${sta.index}" end="${sta.index+2}" varStatus="ss">
						<td><a href="getBoard.do?b_id=${board.b_id }"><img src='resources/upload/${board.b_fname}' alt="첨부파일없음" width="100" height="100"></a>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>

	</table>

<br><br>
여기까지 내꺼
<br><br>
<hr>

<!--------------------


<a href="getBoard.do?b_id=${board.b_id }">


<c:forEach items="${imageList }" var="board">
	<tr>
		<td><a href="getBoard.do?b_id=${board.b_id }"><img src='resources/upload/${board.b_fname}' alt="첨부파일없음"></a></td>
	</tr>
</c:forEach>


----------------------->

<!-- 이정성 -->

<table border="1">
	<tr>
		<td colspan="3" align="center" bgcolor="orange">사진첩</td>
	</tr>
	<c:forEach items="${boardList}" var="board" varStatus="status" step="3">
	<tr>
		<c:forEach items="${boardList}" var="boa" varStatus="stat" begin="${status.index}" end="${status.index+2}" step="1">
		<td>
			<c:choose>
			    <c:when test="${boa.b_fsize==0}">
			    <a href='getBoard.do?b_id=${boa.b_id }'><img alt="첨부파일 없음" width="100" height="100"/></a>
			    </c:when>
			    <c:otherwise>		
			    		<a href='getBoard.do?b_id=${boa.b_id }'><img src='resources/upload/${boa.b_fname}' width="100" height="100"/></a>	    	
			    </c:otherwise>
			 </c:choose>
		</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>

<!-- 이정성 -->

<!-- 김인철 -->

	<table border="1">
		<tr>
			<th bgcolor="orange" width="600" colspan='3'>사진첩</th>


		</tr>
		<c:set var="i">0</c:set>
		<c:forEach items="${boardList }" var="board">

			<!-- 프라퍼티이름 변경 -->
			<c:if test="${i%3 eq 0 }">
				<tr>
			</c:if>


			<!-- 추가 -->
			<td><c:choose>
					<c:when test="${board.b_fsize==0}">첨부파일 없음</c:when>
					<c:otherwise>
						<a href="getBoard.do?b_id=${board.b_id }"> <img src="resources/upload/${board.b_fname}">
						</a>
					</c:otherwise>
				</c:choose></td>

			<c:if test="${i%3 eq 3 }">
				</tr>
			</c:if>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>

<!-- 김인철 -->
	
<!-- 안영상 -->
	
	<h1>사진첩</h1>
	총 이미지 갯수 : ${ boardSize }
	<hr>
	<table>
		<tr>

			<!-- 증감 연산자에 사용할 변수 i 선언 -->
			<c:set var="i" value="1" />
			
			<!-- 반복문 forEach 선언 -->
			<c:forEach items="${boardList }" var="board">
				<td><a href="getBoard.do?b_id=${board.b_id }"> <img
						src="/gWebBoard1/resources/upload/${board.b_fname }" width="300px" />
				</a></td>

				<c:choose>
					<c:when test="${i < 3}">
						<c:set var="i" value="${i + 1}" />
					</c:when>

					<c:otherwise>
		</tr>
		<tr>
			<c:set var="i" value="1" />
			</c:otherwise>
			</c:choose>
			</c:forEach>
		</tr>
	</table>
	
<!-- 안영상 -->

</body>
</html>