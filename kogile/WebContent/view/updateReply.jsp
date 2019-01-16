<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="replyUpdateForm.do" method="post">
		
		<input type="hidden" name="r_no" value="${replyOrgin.r_no }">
		<input type="hidden" name="info_no" value="${replyOrgin.info_no }">
		<br> 댓글 <br>
		<textarea rows="1.5" cols="70" name="r_contents">${replyOrgin.r_contents }</textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>