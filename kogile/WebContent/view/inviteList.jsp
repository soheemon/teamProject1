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
 <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="../bootstrap/js/glyphicons-halflings-regular.eot">
<link rel="stylesheet" href="../bootstrap/css/font-awesome.min.css">

		
<script type= "text/javascript">
	function exit(){
		var e = confirm("프로젝트에서 나가시겠습니까?");
			if(e==true){
				alert("프로젝트에서 나왔습니다.");
				}
			else{
				alert("나가기를 취소하셨습니다.");
				return false;
			}
	}
	
	function winOpen(){
		window.open('inviteSearch.jsp', '이메일 검색', 'width=550, height=150');
	}
	
	
</script>
</head>
<body>

<form action="deleteInviteListAction.in" method="post">
<input type="hidden" name="pjt_no" value=2>
<!-- 임의의값 -->
<input type="hidden" name="no" value=2>
<!-- 임의의값 -->
<button type="submit" value="Project Exit" onclick="return exit()"><span class="glyphicon glyphicon-remove"></span></button>
</form>
<br></br>
<button class="btn btn-mini btn-primary" type="button"onclick="winOpen()"><span class="glyphicon glyphicon-plus"></span></button>

<br></br>
<form action="noticeAction.no" method="post">
<input type="hidden" name="no" value=5></input>
<button type="submit" class="btn btn-mini btn-primary" value="알림 확인" ><span class="glyphicon glyphicon-bell"></span></button>
</form>
<br></br>

 <button class="btn btn-mini btn-primary" type="button" onclick="location.href='inviteListAction.in?pjt_no=2'">참가자</button>
	<c:forEach var="inviteList" items="${list3}">
		<span class="glyphicon glyphicon-user">${inviteList.name }</span>
	</c:forEach>
	
</body>
</html>