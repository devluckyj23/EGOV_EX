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
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
${result.tempId} : ${result.tempVal}

<%--  <c:url> 태그 url을 만들때 사용, 매개변수를 포함한 url을 쉽게 만들수 있다.  --%>
<!-- 	예시 :  -->
<%-- 	<c:url var="변수명" value="url"> --%>
<%-- 	<c:param name="파라미터명" value="값"/> --%>
<%-- 	</c:url> --%>
  


<div class="box-btn">
	<c:url var="uptUrl" value="/temp/tempRegist.do">
		<c:param name="tempId" value="${result.tempId}"/>
	</c:url>
	<a href="${uptUrl}">수정</a>
	
	<c:url var="delUrl" value="/temp/delete.do">
		<c:param name="tempId" value="${result.tempId}"/>
	</c:url>
	<a href="${delUrl}" class="btn-del">삭제</a>
	
	<a href="/temp/selectList.do">목록</a>
</div>
<script>
$(document).ready(function(){
	$(".btn-del").click(function(){
		if(!confirm("삭제하시겠습니까?")){
		//if(!alert("안녕")){		// alert는 확인 문구 하나, confirm은 확인, 취소 둘
			return false;
		}
	});	
});
</script>
</body>
</html>