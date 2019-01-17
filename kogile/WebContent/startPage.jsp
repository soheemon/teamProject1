<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style/startPage.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/startPage.js"></script>
<title>StartPage</title>
</head>
<body>
	<header></header>
	<div class="section">
		<div class="wrap">
			<div class="nav">
				<ul>
					<li class="on"><a href="#n">Home</a></li>
				</ul>
			</div>
			<div class="contents">
				<h2>Project Boards</h2>
				<ul class="create">
					<c:forEach var="ProjectBoard" items="${List}">
					<li>
						<a href="main.do?seq=${ProjectBoard.pjt_no}">${ProjectBoard.pjt_title}</a>
					</li>
					</c:forEach>
					<li class="add_create"><a href="proForm.do">Create new board…</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>