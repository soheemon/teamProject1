<!-- 일반회원 회원가입 FORM -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="register.interMem" accept-charset="utf-8" method="POST" >
	        <fieldset style = "width:170px">
                <legend>Create a kogile Account</legend><br>
                <a href="#">or sign in to your account</a>
         name: <input type = "text" name = "name"/><br>
         Email: <input type = "text" name = "email"/><br>
         Password <input type = "password" name = "password"/><br><br>
               <input type = "submit" value="새계정만들기"/>
               <input type ="button" onclick="location.href='redirect.kakaoOauth'" value="Sign up with Kakao"/>
            </fieldset>
	</form>
</body>
</html>