<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="#" accept-charset="utf-8" method="POST" >
	        <fieldset style = "width:150px">
                <legend>login to kogile</legend>
                <a href="#">or create an account</a>
         email: <input type = "text" name = "email"/><br><br>
         password: <input type = "text" name = "password"/><br><br>
               <input type = "submit" value="제출"/>
               <input type ="button" onclick="location.href='redirect.kakaoOauth'" value="Log in with Kakao"/>
            </fieldset>
	</form>
</body>
</html>