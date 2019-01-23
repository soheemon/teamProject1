<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-1.8.2.js'></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="../tag/tag_autocomplete.js"></script>
  <script src="ajax.js"></script>

  
</head>
<body>
	<h3>post내부페이지</h3>
<!-- 	<a href="insertDescriptionForm.do">글쓰기</a> -->
	<a id="desATag" href="#">글쓰기</a>
<hr>

<form action="insertDescription.do" method="post" id="descrptionForm" style="display:none">
	<br>
	내용 <br>
	<textarea rows="6" cols="70" name="d_contents" id="desFormTextArea"></textarea>
	<br>
	<input type="submit" id="descriptionSubmit" value="등록">
</form>

<a href="descriptionDelete.do?p_no=${detail.p_no }">삭제하기</a>
<a href="descriptionUpdate.do?p_no=${detail.p_no }">수정하기</a>
		
	<table id="description" width="500" border="1" cellpadding="0" cellspacing=0;>
		<tr>
			<td>descripiton내용</td>
			<td>수정하기</td>
			<td>삭제하기</td>
			
		</tr>	
	</table>
	
	
	<br>

	<table id ="reply" width="500" border="1" cellpadding="0" cellspacing=0;>

	</table>
	<br><br>
	
	<form action="replyUpdateForm.do" method="post" id="replyUpdateForm" style="display:none">
		
		<input type="hidden" name="r_no" id="r_no">
		<input type="hidden" name="info_no" id="info_no">
		<br> 댓글 <br>
		<textarea rows="1.5" cols="70" name="r_contents" id="updateFormContents">${replyOrgin.r_contents }</textarea>
		<br> <input type="submit" id="updateSubmit" value="수정">
	</form>
	
	<form action="insertReply.do" method="post" >
		<br> 댓글 <br>
		<textarea type="text" rows="1.5" cols="70" name="r_contents" id="r_contents"></textarea>
		<br>
		<br>태그할사람
		<input type="text" id="autocomplete" name="t.info_no">
		<br><input type="submit" id="submit" value="등록">
	</form>
</body>
</html>