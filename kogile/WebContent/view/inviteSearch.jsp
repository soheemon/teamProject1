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
	  <form action="memberBoardAction.me" method = "post">
		초대 <input type="text" name="search" size="25" id="autocomplete" placeholder="초대 할 회원의 메일주소 입력"></input>
		<input type="submit"value="검색" ></input>
	  </form>
	<br></br>
	<br></br>
	<form action="insertMemberBoardAction.me" method="post">
	
	
	<c:forEach var="memberBoard" items="${list}">
		
			${memberBoard.no }
			${memberBoard.name }
			${memberBoard.mail }
		<br></br>
	</c:forEach>


	</table>
	<input type="submit" value="초대">
	</form>
	
</body>
</html>