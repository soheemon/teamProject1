<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="toDay" class="java.util.Date" />
<fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd' var="nowDate"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post insert Form</title>
</head>
<body>

	<!-- 제목 입력 -->
	<form action="insertPostAction.do" method="post">
		업무 제목 : <input type="text" name="p_title"><br>


		<!-- Card 위치 선택 -->

		업무 위치 :
		<c:if test="${CardInfo != null}">
			<table>
				<tr>
					<td><select name="pjt_card">
							<c:forEach var="CardInfo" items="${CardInfo}">
								<option value="${CardInfo.c_no}">${CardInfo.c_title}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
			</table>
		</c:if>


		<!-- 담당자 선택 -->
		<c:if test="${MemberList != null}">
			<c:forEach items="${MemberList}" var="member">
				<input type="checkbox" name="pjt_member" value="${member.total_no}">${member.name}
		</c:forEach>
		</c:if><br>
		
		
		<!-- 마감일 입력 -->
		마감일 : <input type="text" name="DateInfo" value="${nowDate}">
		
		
		<input type="submit" value="생성">
	</form>
</body>
</html>