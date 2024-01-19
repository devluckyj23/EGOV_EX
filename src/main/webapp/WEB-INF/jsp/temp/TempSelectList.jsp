<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<title>데이터 가져오기~</title>
<!--   <script src="/파일경로/제이쿼리파일명.js"></script> -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
table{border-collapse: collapse;}
th{font-weight:bold;}
th, td{padding:5px;border:1px solid #000;}
</style>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>TEMP_ID</th>
			<th>TEMP_VAL</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}">
			<tr>
				<td><c:out value="${result.tempId}"/></td>
				<td>
				<!--상세페이지로 가기 위한 링크를 걸어주는 작업을 해준다. tempVal를 누르면 상세페이지를 처리하는 select.do로 넘어간다. 
				그 id값을 viewUrl로 정하고 밑에 tempVal값에 a태그로 viewUrl값을 누르면 넘어가게 해준다. -->
					<c:url var="viewUrl" value="/temp/select.do">
						<c:param name="tempId" value="${result.tempId}"/>
					</c:url>	
					<a href="${viewUrl}"><c:out value="${result.tempVal}"/></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button type="button" id="btn-reg" data-href="/temp/tempRegist.do">등록하기</button>
<script>
// 클릭하면 현재 url 주소를 $(this).data("href")로 바꾸라는 거  == data-href="/temp/tempRegist.do"
$(document).ready(function(){
	//등록하기
	$("#btn-reg").click(function(){
		location.href = $(this).data("href");
	});
});
</script>
</body>
</html>				