<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/labelcss.css" rel="stylesheet">

<script src="../bootstrap/js/jquery.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<form action="labellist.post" method="get">
		post 번호 : <input type="text" name="p_no" value="${p_no}">
		<input type="submit" class="btn btn-primary" value="label">
	</form>
	
	<c:if test="${label != null }">
		<c:forEach var="label" items="${label }">
			<c:choose>
			
					<c:when test="${label.color_no == 1}">
						<a href="deleteLabelInfo.post?label_no=${label.label_no }&p_no=${p_no}" class="labelcolor_red">${label.label_text }</a>
					</c:when>
					<c:when test="${label.color_no == 2}">
						<a href="deleteLabelInfo.post?label_no=${label.label_no }&p_no=${p_no}" class="labelcolor_orange">${label.label_text }</a>
					</c:when>
					<c:when test="${label.color_no == 3}">
						<a href="deleteLabelInfo.post?label_no=${label.label_no }&p_no=${p_no}" class="labelcolor_yellow">${label.label_text }</a>
					</c:when>
					<c:when test="${label.color_no == 4}">
						<a href="deleteLabelInfo.post?label_no=${label.label_no }&p_no=${p_no}" class="labelcolor_green">${label.label_text }</a>
					</c:when>
					
			</c:choose>
		</c:forEach>
	</c:if>
	
	
	
	
	</div>
</body>
</html>