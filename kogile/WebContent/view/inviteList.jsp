<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h3>초대리스트</h3>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>회원번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>Grade</td>
	</tr>
	<c:forEach var="inviteList" items="${list3}">
		<tr>
			<td>${inviteList.no }</td>
			<td>${inviteList.name }</td>
			<td>${inviteList.mail }</td>
			<td>${inviteList.grade}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>