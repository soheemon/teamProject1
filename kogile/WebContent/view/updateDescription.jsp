<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="descriptionUpdateForm.do" method="post">
	<!-- 화면에 보이지 않지만 글번호를 넘기기 위해 아래와 같이 코딩 -->
		<input type="hidden" name="p_no" value="${detail.p_no }">
	내용 <br>
	<textarea rows="6" cols="70" name="d_contents">${detail.d_contents }</textarea>
	<br>
	<input type="submit" value="수정완료">
</form>
</body>
</html>







