<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
  function winOpen(){
     window.open('memberBoardAction.do','사람찾기','width=550, height=300');
  } 
</script>
</head>

<body>
	  <form id="fmt">
		초대 <input type="text" name="memberSearch" size="10" id="bb"></input>
		<input type="button"value="검색" onclick="winOpen()"></input>
	  </form>
	<br></br>
	<br></br>

</body>
</html>