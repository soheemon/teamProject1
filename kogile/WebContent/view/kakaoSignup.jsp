<!-- 카카오톡 회원가입 Form -->
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
	<form action="register.kakaoOauth" accept-charset="utf-8" method="POST" >
	        <fieldset style = "width:150px">
                <legend>kakao 회원가입</legend>
                    이름 : <input type = "text" name = "name"/><br><br>
                    이메일: <input type = "text" name = "email"/><br><br>
               <input type = "submit" id = "KakaoRegFormSub" value="제출"/>
            </fieldset>
	</form>
</body>
</html>