<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Ddate Form</title>
</head>
<body>
	<form action="updateDdateAction.do" method="post">
		<fmt:parseDate var="date" value="${DdateDTO.d_date}" pattern="yyyy-MM-dd"></fmt:parseDate>
		수정 날짜 : <input type="text" name="update_Ddate" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>