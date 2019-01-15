<%@page import="kogile.checklist.DAO.CheckListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	CheckListDao dao = CheckListDao.getInstance();
	
	dao.insertchecklist1();
	
	%>
</body>
</html>