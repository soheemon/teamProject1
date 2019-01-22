<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:useBean id="toDay" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail Form Action</title>
</head>
<body>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
			

		<tr>
			<th>제목</th>
			<td>${PostDTO.p_title}</td>
		</tr>
		
		<tr>
			<th>담당자</th>
			<c:if test="${PostMemberList != null}">
				<td><c:forEach var="supervisor" items="${PostMemberList}">
         	 ${supervisor.name}
         	</c:forEach></td>
			</c:if>
		</tr>

		<tr>
			<th>마감일</th>
			<td>
			<fmt:parseDate var="d_date" value="${DdateDTO.d_date}" pattern="yyyy-MM-dd HH:mm:ss."/>
			<fmt:formatDate value="${d_date}" pattern="yyyy-MM-dd"/>
			<a href="updateDdateFormAction.do"> 마감일 수정 </a>
			<a href="deleteDdateAction.do"> 마감일 삭제 </a>
			</td>
			
			<th>디데이</th>
			<td>
 			<fmt:parseNumber value="${toDay.time / (1000*60*60*24)}" integerOnly="true" var="nowDays" scope="request"/>
 			<fmt:parseNumber value="${d_date.time / (1000*60*60*24)}" integerOnly="true" var="endDays" scope="page"/>
			<c:set value="${(nowDays - endDays) * - 1}" var="d_day"/>
			
			<c:choose>
			<c:when test="${d_date != null}">
			${d_day}일 남았습니다.
			</c:when>
			
			<c:otherwise>
			마감일이 없습니다.
			</c:otherwise>
			
			</c:choose>
			</td> 
		</tr> 
		
		



		<tr>
			<td></td>
			<td><a href="deletePostAction.do"> 삭제 </a></td>

		</tr>

	</table>
</body>
</html>