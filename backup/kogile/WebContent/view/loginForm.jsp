<!-- 일반회원 로그인 FORM -->
<!-- ToDo. 제이쿼리로 입력값 검증하기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="InputDataTest.js"></script>
</head>
<body>
	<div>
		<form action="login.interMem" accept-charset="utf-8" method="POST" >
	        <fieldset style = "width:150px">
                <legend>login to kogile</legend>
                <a href="signupMain.jsp">or create an account</a>
         email: <input type = "text" name = "email"/><br><br>
         password: <input type = "password" name = "password"/><br><br>
               <input type = "submit" name= "submit" value="제출"/>
               <input type ="button" onclick="location.href='redirect.kakaoOauth'" value="Log in with Kakao"/>
            </fieldset>
		</form>
	</div>
</body>
</html>