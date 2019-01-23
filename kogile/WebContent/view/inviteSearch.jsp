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
<script type= "text/javascript">
	function yesNo(){
		var a = confirm("초대하시겠습니까?");
			if(a==true){
				alert("초대됐습니다.");
				}
			else{
				alert("초대가 취소됐습니다.");	
				return false;
			}
			
	}
</script>
</head>
<body>
	
	  <form action="memberBoardAction.me" method = "post">
		사람 검색 :  <input type="text" name="search" size="25" id="autocomplete" placeholder="초대 할 회원의 메일주소 입력"></input>
		<input type="submit"value="검색 " ></input>
	  </form>
	<br>
	<table class="table-striped"width="500" border="0" cellpadding="0" cellspacing="0">
	<c:forEach var="memberBoard" items="${list}">
	<form action="insertMemberBoardAction.me" method="post">
			<!-- 임의의값 -->
			<input type="hidden" name="no" value=${memberBoard.no }>
			<input type="hidden" name="name" value=${memberBoard.name }>
			<input type="hidden" name="mail" value=${memberBoard.mail }>
			<tr>
				<td>${memberBoard.name }</td>
				<td>${memberBoard.mail }
				
			
		<input type="submit" value="초대 " onclick="return yesNo()">	</td>
			</tr>		
		</form>
	</c:forEach>
		</table>

		<br>
	
</body>
</html>