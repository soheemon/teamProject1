<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/labelcss.css" rel="stylesheet">

<script src="../bootstrap/js/jquery.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1></h1>
	<div class="container">
			
			<c:if test="${label != null }">
				<c:forEach var="test" items="${label }">
					<c:choose>
						<c:when test="${test.color_no == 1 }">
							<li class="labelcolor_red label_select"><a href="postDetailView.do?label_no=${test.label_no}">${test.label_text }</a>
<%-- 							<a href="deleteLabel.do?color_no=${test.color_no }&label_text=${test.label_text}&pjt_no=${test.pjt_no}"><!--  -->
 --%>							<a href="deleteLabel.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-remove pull-right" aria-hidden="true"></span></a>
							<a href="updateLabelForm.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a>
							</li>
						</c:when>
						<c:when test="${test.color_no == 2 }">
							<li class="labelcolor_orange label_select"><a href="postDetailView.do?p_no=${p_no }&label_no=${test.label_no}">${test.label_text }</a>
							<a href="deleteLabel.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-remove pull-right" aria-hidden="true"></span></a>
							<a href="updateLabelForm.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a>
							</li>
						</c:when>
						<c:when test="${test.color_no == 3 }">
							<li class="labelcolor_yellow label_select"><a href="postDetailView.do?p_no=${p_no }&label_no=${test.label_no}">${test.label_text }</a>
							<a href="deleteLabel.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-remove pull-right" aria-hidden="true"></span></a>
							<a href="updateLabelForm.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a>
							</li>
						</c:when>
						<c:when test="${test.color_no == 4 }">
							<li class="labelcolor_green label_select"><a href="postDetailView.do?p_no=${p_no }&label_no=${test.label_no}">${test.label_text }</a>
							<a href="deleteLabel.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-remove pull-right" aria-hidden="true"></span></a>
							<a href="updateLabelForm.do?label_no=${test.label_no}">
							<span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a>
							</li>
						</c:when>
					</c:choose>
				</c:forEach>
			</c:if>
		<a href="insertLabelForm.do?">라벨추가</a>
		

	</div>




</body>
</html>