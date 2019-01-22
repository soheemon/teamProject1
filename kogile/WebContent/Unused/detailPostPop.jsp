<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../style/index.css" />
</head>
<style>
#charge li {
	padding: 10px;
	display: inline;
}
</style>
<body>
	<!-- 	<div class="popup">-->
	<div class="popup_bg">
		<div class="inner">
			<div class="title_holder holder">
				<h3 class="title_p">${PostDTO.p_title}</h3>
				<div class="holder_inner">
					<ul id="charge">
						<c:if test="${PostMemberList != null}">
							<c:forEach var="supervisor" items="${PostMemberList}"> 
							<li>${supervisor.name}</li>
         					</c:forEach>
						</c:if>
					</ul>
					
				</div>
			</div>
				<div class="left_list">
				<div class="des_holder holder">
					<h3 class="title_p">마감일</h3>
					<a href="#n" class="edit">Edit</a>
					<div class="holder_inner">
						<span class="list_title">발표때 이거 포함하기</span>
						<ul id="d_day">
							<fmt:parseNumber value="${toDay.time / (1000*60*60*24)}" integerOnly="true" var="nowDays" scope="request"/>
 							<fmt:parseNumber value="${d_date.time / (1000*60*60*24)}" integerOnly="true" var="endDays" scope="page"/>
							<c:set value="${(nowDays - endDays) * - 1}" var="d_day"/>
							
							<c:choose>
							<c:when test="${d_date != null}">
							${d_day}일 남았습니다.
							</c:when>
							
							<c:otherwise>
							마감일이 없습니다.
							</c:otherwise>
							
							</c:choose>
						</ul>
					</div>
				</div>
			<div class="left_list">
				<div class="des_holder holder">
					<h3 class="title_p">Description</h3>
					<a href="#n" class="edit">Edit</a>
					<div class="holder_inner">
						<span class="list_title">발표때 이거 포함하기</span>
						<ul>
							<li>아키텍쳐 구조</li>
							<li>명명법</li>
							<li>역할분담</li>
							<li>요구분석</li>
							<li>유스케이스</li>
							<li>화면설계(주요페이지) = daum페이지 오븐?</li>
						</ul>
					</div>
				</div>
				<div class="comment_holder holder">
					<h3 class="title_p">Add Comment</h3>
					<span class="name">병록</span>
					<div class="input_box">
						<textarea class="add_input" placeholder="Write a comment..."></textarea>
						<a href="#n" class="save_btn">Save</a>
					</div>
				</div>
				<div class="active_holder holder">
					<h3 class="title_p">Activity</h3>
					<ul>
						<li><span class="name">철희</span>
							<div class="input_box">
								<span class="fullname">정철희</span> <span class="date">Jan
									16 at 10:00 AM</span> <span class="cts"> <span class="id">@junjang7</span>
									ㅎㅇㅎㅇ
								</span> <a href="#n" class="rep_btn">Reply</a>
							</div></li>
						<li><span class="name">철희</span>
							<div class="input_box">
								<span class="fullname">정철희</span> <span class="date">Jan
									16 at 10:00 AM</span> <span class="cts"> <span class="id">@junjang7</span>
									ㅎㅇㅎㅇ
								</span> <a href="#n" class="rep_btn">Reply</a>
							</div></li>
						<li><span class="name">철희</span>
							<div class="input_box">
								<span class="fullname">정철희</span> <span class="date">Jan
									16 at 10:00 AM</span> <span class="cts"> <span class="id">@junjang7</span>
									ㅎㅇㅎㅇ
								</span> <a href="#n" class="rep_btn">Reply</a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="right_list">
				<div class="addcard_holder holder">
					<h3 class="title_c">ADD TO CARD</h3>
					<div class="btn_list">
						<a href="">Members</a> <a href="">Labels</a> <a href="">Checklist</a>
						<a href="">Due Date</a> <a href="">Attachment</a>
					</div>
				</div>
				<div class="ups_holder holder">
					<h3 class="title_c">POWER-UPS</h3>
					<div class="holder_inner">
						<a href="#n">Get Power-Ups</a>
					</div>
				</div>
				<div class="action_holder holder">
					<h3 class="title_c">ACTION</h3>
					<div class="btn_list">
						<a href="">Move</a> <a href="">Copy</a> <a href="">Watch</a> <a
							href="">Archive</a> <a href="">Share</a>
					</div>
				</div>
			</div>
		</div>
		<button class="close_btn">close</button>
	</div>
	<!-- </div> -->

	<script src="../js/jquery-1.12.4.min.js"></script>
	<script src="https://unpkg.com/hammerjs@2.0.8/hammer.min.js"></script>
	<script src="https://unpkg.com/muuri@0.7.1/dist/muuri.min.js"></script>
	<script src="../js/index.js"></script>
</body>
</html>