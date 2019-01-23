<%@page import="com.service.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.service.CheckListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	CheckListService service = CheckListService.getInstance();
	
	List<Board> checklist = service.listBoardService(request);
	request.setAttribute("checklist", checklist);
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<form action="insertAction20.do" method="post" >
<!-- 	checklist_no: <input type="text" name="checklist_no"><br> -->
				<input type="hidden" name = "${checklist.checklist_no}}">
	list_info : <input type="text" name="list_info"><br>
	<br>
	<input type="submit" value="list등록">
</form>

</body>
</html>




