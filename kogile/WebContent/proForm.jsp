<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style/startPage.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/startPage.js"></script>
<title>project produce page</title>
</head>
<body>
	<div class="wrap popup">
		<div class="project_box">
			<h3>프로젝트 생성</h3>
			<form action="proFormAction.do" method="post">
				<div class="form_box">
					<span><label>제목</label><input type="text" name="title" style="width:320px;"></span>
					<span><label>내용</label><textarea name="contents"></textarea></span>
					<div class="btn_area">
						<input type="submit" value="등록" class="add_btn btn1">
						<input type="reset" value="취소" class="btn1">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>