<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
         <th>supervisor</th>
         <c:if test="${MemberList != null}">
         	<c:forEach var="supervisor" items="${MemberList}" >
         	 이름 : 	<li> ${supervisor.name} </li>
         	</c:forEach>
         </c:if>
         
         
         
         <%-- <th style="">description</th>
         <td colspan="3"><textarea type="text" name="description"
               style="width: 100%; height: 100px;">${PostDTO.d_contents}</textarea></td>
         <th>checklist</th>
         <td>${PostDTO.check_title}</td>
         <th>reply</th>
         <td>${PostDTO.r_contents}</td>
         <th>delete</th> --%>
         <td><a href="deletePostAction.do?p_no=${PostDTO.p_no}"> 삭제 </a></td>
      </tr>
      
   </table>
</body>
</html>