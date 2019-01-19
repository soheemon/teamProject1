<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=2.0, minimum-scale=1.0" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script src="https://unpkg.com/hammerjs@2.0.8/hammer.min.js"></script>
<script src="https://unpkg.com/muuri@0.7.1/dist/muuri.min.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript">

var pjt_no =${project_pjt_no};
location.href='listPostAction.post?pjt_no=pjt_no';


/*  $(document).ready(function(){
	$.ajax({
		type:'post',
		url:'listPostAction.post',
		success: function(){
		}
	});
});  */
</script>
<title></title>
</head>
<body>


	<header> </header>
	<section class="main">
		<div class="wrap2">
			<div class="top_menu">
				<div class="menu_left">
					<h2>${project.pjt_title}</h2>
					<span class="a_1"><a href="#n">Travidux</a></span> 
					<span class="a_3"><a href="#n">Team Visible</a></span>
				</div>
				<div class="menu_right">
					<span><a href="#n">··· Show Menu</a></span>
				</div>
			</div>

			<div class="cts_board grid">
			
				<div class="item">
					<div class="heading">
						<h3 class="board_title">To Do</h3>
						<a href="#n" class="more">···</a>
					</div>
					
					<div class="item_content" id="card1" val="">
	
						<c:forEach var="post" items="${post}">
						<div class="post">
							<a href="detailPostAction.post?p_no=${post.p_no}" 
								class="post_item">
								<div class="progress"></div>
								<h4>${post.p_title}</h4>
								<div class="btn_box">
									<span class="list"></span> 
									<span class="check">0/4</span> 
									<span class="date">Jul 20</span>
								</div>
								<div class="peo_box">
									<img src="images/peo.png" alt="" />
								</div>
							</a>
						</div>
						</c:forEach> 
									
					</div>
					<button class="add_txt" href="insertPostFormAction.post?pjt_no=${pb.pjt_no}">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Doing</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content" id="card2">
						
				
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Done</h3>
						<a href="#n" class="more">···</a>
					</div>
					
					<div class="item_content" id="card3">
						
				
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Close</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content" id="card4">
						
						
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>