<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../style/startPage.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css" />
<style type="text/css">
body {
	background-color: rgba(9, 45, 66, .08);
}
</style>

<title>project produce page</title>
</head>
<body>
	<div class="container">
		<h3>프로젝트 생성</h3>
		<form action="insertProjectFormAction.pjt" method="post">
			<div class="form_box">
				<span><label>제목</label> <input type="text" id="pjt_title"
					style="width: 320px;"> </span> <span><label>내용</label> <textarea
						id="pjt_contents"></textarea></span>
				<div class="btn_area">
					<input type="button" value="등록" class="add_btn btn1" id="insertProject"> <input
						type="reset" value="초기화" class="btn1"> <input
						type="button" class="closeWindow btn1" value="취소">
				</div>
			</div>
		</form>
	</div>
	<!-- 	</div> -->
	<script src="../js/jquery-1.12.4.min.js"></script>
	<script src="../js/startPage.js"></script>
	<script src="../js/start.js"></script>
</body>
</html>