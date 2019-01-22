
<%@page import="com.service.ListService"%>
<%@page import="com.service.ListModel"%>
<%@page import="com.service.CheckListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	request.setCharacterEncoding("utf-8");

	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum= "1";
	}

	int requestPage = Integer.parseInt(pageNum);
	ListService service = ListService.getInstance();
	ListModel listModel = service.listBoardService20(requestPage, request);
	request.setAttribute("listModel", listModel);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<ul>
		<li>제목:${board.list_info }
	<br>
	<a href="insert_form20.do?list_no=${board.list_no }">등록</a>
	<a href="updateForm20.do?list_no=${board.list_no }">수정</a>
	<a href="delete20.do?list_no=${board.list_no }">삭제</a>
	<a href="detail.do">목록</a>
		</li>
	</ul>
	
</body>
</html>
