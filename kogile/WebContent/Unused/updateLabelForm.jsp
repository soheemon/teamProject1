<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div class="container">
		<h1>LABEL</h1>
		<table class="table table-striped">
			<form action="updateLabel.post" method="post">
				<input type="hidden" value="${before.label_no }" name="label_no">
			
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" name="label_text" value="${before.label_text}"></td>
				</tr>

				<tr>
					<td>COLOR</td>
					<td>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="1">
								<div class="label_radio labelcolor_red"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="2">
								<div class="label_radio labelcolor_orange"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="3">
								<div class="label_radio labelcolor_yellow"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="4">
								<div class="label_radio labelcolor_green"></div>
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center"><input type="submit"
						value="등록" class="btn btn-success"> <a
						href="javascript:history.back()" class="btn btn-danger">취소</a>
				</tr>
			</form>
		</table>
	</div>

</body>
</html>