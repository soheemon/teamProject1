<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail Form Action</title>
</head>
<body>
	<table width="500" border="1" cellpadding="0" cellspacing="0">

		<tr>
			<th>title</th>
			<td>${PostDTO.p_title}</td>
		</tr>
		
		<tr>
			<th>supervisor</th>
			<c:if test="${PostMemberList != null}">
				<td><c:forEach var="supervisor" items="${PostMemberList}">
         	 ${supervisor.name}
         	</c:forEach></td>
			</c:if>
		</tr>

		<%-- <tr>
			<th>현재 날짜</th>
			<c:set var="now" value="<%= new Date() %>"></c:set>
			<td><fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd"/></td>
			<th>남은 일 수</th>
			<fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true"
			var="nowDays" scope="request"/>
			<fmt:parseNumber value="${now.WriteDate.time / (1000*60*60*24)}" integerOnly="true"
			var="oldDays" scope="page"/>
			<c:set value="${nowDays - oldDays}" var="dateDiff"/>
			<c:out value="${dateDiff}"/>
		</tr> --%>
		
		


		

		<%-- <th style="">description</th>
         <td colspan="3"><textarea type="text" name="description"
               style="width: 100%; height: 100px;">${PostDTO.d_contents}</textarea></td>
         <th>checklist</th>
         <td>${PostDTO.check_title}</td>
         <th>reply</th>
         <td>${PostDTO.r_contents}</td>
         <th>delete</th> --%>
		<tr>
			<td></td>
			<td><a href="deletePostAction.post?p_no=${PostDTO.p_no}"> 삭제 </a></td>
		</tr>

	</table>
</body>
</html>