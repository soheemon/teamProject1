<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Post Form Action</title>
</head>
<body>
	<form action="updatePostAction.do" method="post">
		수정 제목 : <input type="text" name="update_title" value="${PostDTO.p_title}"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>