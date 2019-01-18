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
		window.open('inviteSearch.jsp', '이메일 검색', 'width=550, height=300');
	}
	function winOpen2(){
		window.open('noticeAction.no', '알람 리스트', 'width=600, height=300');
	}
	
</script>
</head>
<body>

<form action="deleteInviteListAction.in" method="post">
<input type="hidden" name="pjt_no" value=2>
<!-- 임의의값 -->
<input type="hidden" name="no" value=6>
<!-- 임의의값 -->
<input type="submit" value="프로젝트 나가기" onclick="return exit()">
</form>
<br></br>
<input type="button" value="초대" onclick="winOpen()">
<br></br>
<input type="button" value="알림 확인" onclick="winOpen2()">
<br></br>
	<a href="inviteListAction.in?pjt_no=2">프로젝트 참여자</a>
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