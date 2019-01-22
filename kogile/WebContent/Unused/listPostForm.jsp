<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post List</title>
</head>
<body>
	<h3>포스트 목록</h3>

	<table width="200" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>제목</td>
		</tr>

		<c:forEach var="PostDTO" items="${list}">
		
			<tr>
				<td><a href="detailPostAction.post?p_no=${PostDTO.p_no}">${PostDTO.p_title}</a> 
				<a style="float: right"
					href="updatePostFormAction.post?p_no=${PostDTO.p_no}"> 수정 </a></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			
		</c:forEach>
	</table>
	<a href="insertPostFormAction.post?pjt_no=1"> Post 생성 </a>
</body>
=======
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post List</title>
</head>
<body>
	<h3>포스트 목록</h3>
	<table width="200" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>제목</td>
	</tr>
	
	<c:forEach var="PostDTO" items="${list}">
	<tr>
		<td><a href="detailPostAction.do?p_no=${PostDTO.p_no}"> ${PostDTO.p_title}</a> 
		<a style="float: right" href="updatePostFormAction.do?p_no=${PostDTO.p_no}"> 수정 </a></td>
	</tr>
	<tr>
		<td> 
		</td>
	</tr>
	</c:forEach>
	</table>
	<a href="insertPostFormAction.do"> Post 생성 </a>
 </body>
</html>