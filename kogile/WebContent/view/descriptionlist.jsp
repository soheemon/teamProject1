<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>post내부페이지</h3>
	<a href="insertDescriptionForm.do">글쓰기</a>
	<table width="500" border="1" cellpadding="0" cellspacing=0;>
		<tr>
			<td>descripiton내용</td>
			<td>post번</td>
		</tr>
		<tr>
			<td>${detail.d_contents }</td>
			<td>${detail.p_no }</td>
		</tr>
		<a href="descriptionDelete.do?p_no=${detail.p_no }">삭제하기</a>
		<a href="descriptionUpdate.do?p_no=${detail.p_no }">수정하기</a>
	</table>
	
	
	<br>
	<table width="500" border="1" cellpadding="0" cellspacing=0;>
		<tr>
			<td>댓글내용</td>
			<td>작성일</td>
			<td>작성자</td>
			<td>수정/삭제</td>
		</tr>
		<c:forEach var="reply" items="${memberList }">
			<tr>
				<td>${reply.r_contents }</td>
				<td>${reply.r_date }</td>
				<td>${reply.name }</td>
				<td>
					<a href="replyDelete.do?r_no=${reply.r_no }&info_no=${reply.info_no}">삭제하기</a>
					<a href="replyUpdate.do?r_no=${reply.r_no }&info_no=${reply.info_no}">수정하기</a>
				</td>
				
			</tr>
		</c:forEach>
		
	</table>
	<br><br>
	<form action="insertReply.do" method="post" id="replyform" autocomplete="on">
		<br> 댓글 <br>
		<textarea rows="1.5" cols="70" name="r_contents"></textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>