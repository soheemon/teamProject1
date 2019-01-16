<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	int total_m_no;
	String message = "";
	if(session.getAttribute("total_m_no") == null) {
		System.out.println("아직 로그인 안함");
		message = "로그인 안하셨네요! 로그인을 해주세요!";
	}else{
		int membernum = (int)session.getAttribute("total_m_no");
		message = membernum + "번 고객님 어서오세요";
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h3>이것은 테스트 페이지입니다!</h3><br><br>
<%=message %><br><br>
"테스트를 위해 jsp로 바로 이동합니다."<br><br>
<a href="KakaoOauthTest.jsp">로그인하자</a><br><br>
<a href="signupMain.jsp">회원가입하자</a>
</div>

</body>
</html>