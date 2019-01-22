<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../style/startPage.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">

<title>listProject</title>

</head>
<body>
	<header></header>
	<div>
		<div class="wrap">
			<div class="nav">
				<ul>
					<li class="on"><a href="#n">Home</a></li>
				</ul>
			</div>
			<div class="contents">
				<h2 style="display:inline; margin-right : 30px;">Project Boards</h2> <a id="insertProjectForm" class= "btn btn-primary" href="#">프로젝트 생성</a> 
				<ul class="create" id="pjt">
					<c:forEach var="Project" items="${List}">
						<li><a href="detailProject.pjt?pjt_no=${Project.pjt_no}">${Project.pjt_title}</a>
						</li>
					</c:forEach>
				</ul>
					
			</div>
		</div>
	</div>
	

	<script src="../js/jquery-1.12.4.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../js/startPage.js"></script>
	<script src="../js/start.js"></script>
</body>
</html>