<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:useBean id="toDay" class="java.util.Date" />
<fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd' var="nowDate"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=2.0, minimum-scale=1.0" />
<!-- <link rel="stylesheet" type="text/css" href="../style/main.css" /> -->
<link rel="stylesheet" type="text/css" href="../style/index.css" />
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<style>
.myDetailList a {
	background: #f1f1f1;
	background-size: 12px;
	font-weight: 600;
	font-size: 20px;
	color: #666;
	border-radius: 5px;
	display: none;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
	padding: 40px 40px 40px 40px;
	box-sizing: border-box;
	width: 170px;
	hegiht: 40px;
	margin-right: 10px;
}
#pjt_member input{
	margin-right: 3px;
	margin-left: 7px;
}
</style>
<script type="text/javascript">
	function winOpen(){
		window.open('inviteSearch.jsp', '이메일 검색', 'width=550, height=150');
	}
</script>
<title></title>
</head>
<body>
	<!-- <a id="insertProjectForm" value="test" class="btn btn-primary">test</a> -->
	<header> </header>

	<section class="main">
		<div class="wrap2">
			<div class="top_menu">
				<div class="menu_left">
					<h2>${project.pjt_title}</h2>
					<span class="a_1">
					<a href="#n">Travidux</a>
					</span> 
					<span class="a_3"><a href="#n" id="btn_inviteList" >Team Visible</a></span>
						<div id="inviteList">
						</div>
						
						
						<%-- <c:forEach var="inviteList" items="${list3}">
							<span class="glyphicon glyphicon-user">${inviteList.name }</span>
						</c:forEach> --%>
					<!-- <button class="btn btn-mini btn-primary" type="button" onclick="location.href='inviteListAction.in?pjt_no=2'">참가자</button> -->
				</div>
				<div class="menu_right">
					<button class="btn btn-mini btn-primary pull-right" type="button" onclick="winOpen()" ><span class="glyphicon glyphicon-plus"></span></button>
						<form action="noticeAction.no" method="post" name="notice_form">
							<input type="hidden" name="no" value=5></input>
							<a id="notice_btn" class="btn btn-mini btn-primary pull-right" value="알림 확인" ><span class="glyphicon glyphicon-bell"></span></button>
						</form>
					<span><a href="#n" class="menu_open">··· Show Menu</a></span>
					
					<div class="menu">
						<h3 class="title_m">MENU</h3>
						<ul class="sub_menu">
							<li><a href="#n">Project Delete</a></li>
							<li><a href="listChatRoomAction.chat">Chat</a></li>
							<li><a href="#n">Activity</a>
								<ul>
									<li><a href="#n">
											<div class="act_left">
												<span class="name">병록</span>
											</div>
											<div class="act_right">
												<span><em>윤병록</em>added ㅇㅇ to this board</span> <span
													class="time">18 minutes ago</span>
											</div>
									</a></li>
									<li><a href="#n">
											<div class="act_left">
												<span class="name">병록</span>
											</div>
											<div class="act_right">
												<span><em>윤병록</em>added ㅇㅇ to this board</span> <span
													class="time">18 minutes ago</span>
											</div>
									</a></li>
									<li><a href="#n">
											<div class="act_left">
												<span class="name">병록</span>
											</div>
											<div class="act_right">
												<span><em>윤병록</em>added ㅇㅇ to this board</span> <span
													class="time">18 minutes ago</span>
											</div>
									</a></li>
								</ul></li>
						</ul>
						<button class="close_btn2">close</button>
					</div>
				</div>
			</div>



			<div class="cts_board grid">


				<c:forEach var="card" items="${card}">

					<div class="item">
						<div class="heading">
							<h3 class="board_title">${card.c_title}</h3>
							<a href="#n" class="more">···</a>
						</div>

						<div class="item_content" id="${card.c_no }">

							<c:forEach var="post" items="${post}">

								<c:if test="${card.c_no == post.c_no}">
									<a href="#n" class="detailPostView post ui-state-default">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="${post.p_no}">
											<!-- <div class="progress"></div> -->
											<h4>${post.p_title}</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> <span
													class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
									</a>
								</c:if>
							</c:forEach>

						</div>

						<button class="add_txt"
							href="insertPostFormAction.post?pjt_no=${project.pjt_no}">post
							생성</button>
					</div>
				</c:forEach>
			</div>
		</div>


		<%-- <header> </header>
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
					
					<ul class="item_content" id="card1">
	
						<c:forEach var="post" items="${todo}">
						<li class="post">
							<a href="#" 
								class="post_item detailPostView detailPostView">
								<input type="hidden" class="select_p_no" vlaue="${post.p_no}">
								<div class="progress"></div>
								<h4>${post.p_title}</h4>
								<div class="btn_box">
									<span class="list"></span> 
									<span class="check">0/4</span> 
									<span class="date">Jul 20</span>
								</div>
								<div class="peo_box">
									<img src="images/peo.png" alt=""/>
								</div>
							</a>
						</li>
						</c:forEach> 
									
					</ul>
					<button class="add_txt" href="insertPostFormAction.post?pjt_no=${pb.pjt_no}">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Doing</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content" id="card2">
						<c:forEach var="post" items="${doing}">
						<li class="post">
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
									<img src="images/peo.png" alt=""/>
								</div>
							</a>
						</li>
						</c:forEach> 
				
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Done</h3>
						<a href="#n" class="more">···</a>
					</div>
					
					<div class="item_content" id="card3">
						<c:forEach var="post" items="${done}">
						<li class="post">
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
									<img src="images/peo.png" alt=""/>
								</div>
							</a>
						</li>
						</c:forEach> 
				
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Close</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content" id="card4">
						<c:forEach var="post" items="${close}">
						<li class="post">
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
									<img src="images/peo.png" alt=""/>
								</div>
							</a>
						</li>
						</c:forEach> 
						
						
					</div>
					<button class="add_txt">Add a card...</button>
				</div>
			</div>
		</div>
	</section> --%>
		<div class="popup DetailPostPopUp">
		<input type="hidden" id="now" value="${nowDate }">

			<div class="popup_bg">
				<div class="inner">
					<div class="title_holder holder">
						<h3 class="title_p" id="post_title"></h3>
						<div class="holder_inner">
							<%-- <ul id="charge">
								<c:if test="${PostMemberList != null}">
									<c:forEach var="supervisor" items="${PostMemberList}">
										<li>${supervisor.name}</li>
									</c:forEach>
								</c:if>
							</ul> --%>
							<div class="addcard_holder holder">
								<div class="myDetailList">
									<a href="" id="memberList"></a> <a href="" id="labelList"></a>
									<a href="" id="d_dateList"></a>
								</div>
							</div>
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
								<a href="">Members</a> <a href="" class="label_btn">Labels</a> <a href="">Checklist</a>
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
		</div>



		<div class="popup InsertPopUp">
			<div class="popup_bg">
				<div class="inner">
					<form name="insertPostForm">
						<div class="title_holder holder">
							<h3 class="title_p">Post 생성</h3>
						
						<div class="form-group">
						 <div class="col-xs-7">
							<label for="Input_p_title">제목</label> 
							<input type="text" class="form-control" name="p_title" placeholder="작업 제목을 입력하세요">
						</div>
						</div>
					</div>
						
						<div class="form-group holder">
						<div class="col-xs-4">
							<label for="Input_c_position">작업 단계</label>
							<select class="form-control" name="pjt_card">
								
							</select>
							</div>
						</div>
						
						<div class="form-group holder">
						<div class="col-xs-12">
							<label for="checkBox_pjt_member">담당자</label>
							<div id="pjt_member" >
							
							</div>
						</div>
						</div>
						
						<div class="form-group holder">
							<div class="col-xs-6">
								<label for="post_d_date">마감일</label>
								<input type="text" class="form-control" name="DateInfo" value="${nowDate}">
							</div>
						</div>
						</form>
					<a class="btn pull-right btn-primary" id="insertPost" href="">저장</a>
				</div>
				<button class="close_btn">close</button>
			</div>
		</div>
		
		<div class="label_box">
					<div class="label_header">
						<h3 class="title_h">Labels</h3>
						<button class="label_close">close</button>
					</div>
					<div>
						<div class="label_list">
							<div>
								<!-- <input class="search_label" type="text" placeholder="Search labels..."> -->
								<ul id="mylabel_list">
									<%-- <c:forEach items="" var="label">
										<c:if test="${label.color_no = 1 }">
											<li>
												<input type="hidden" value="${label.label_no }" class="select_l_no">
												<a href="#n" class="card_edit"></a>
												<span class="card_label red">${label.label_text }</span>
											</li>
										</c:if> --%>
									<%-- 	<c:if test="${label.color_no = 2 }">
											<li>
												<input type="hidden" value="${label.label_no }" class="select_l_no">
												<a href="#n" class="card_edit"></a>
												<span class="card_label orange">${label.label_text }</span>
											</li>
										</c:if>
										<c:if test="${label.color_no = 3 }">
											<li>
												<input type="hidden" value="${label.label_no }" class="select_l_no">
												<a href="#n" class="card_edit"></a>
												<span class="card_label yellow">${label.label_text }</span>
											</li>
										</c:if>
										<c:if test="${label.color_no = 4 }">
											<li>
												<input type="hidden" value="${label.label_no }" class="select_l_no">
												<a href="#n" class="card_edit"></a>
												<span class="card_label green">${label.label_text }</span>
											</li>
										</c:if> --%>
									<%-- </c:forEach>  --%>
									<!-- <li>
										<a href="#n" class="card_edit"></a>
										<span class="card_label red"></span>
									</li>
									<li>
										<a href="#n" class="card_edit"></a>
										<span class="card_label orange"></span>
									</li>
									<li>
										<a href="#n" class="card_edit"></a>
										<span class="card_label yellow"></span>
									</li>
									<li>
										<a href="#n" class="card_edit"></a>
										<span class="card_label green"></span>
									</li> -->
									
								</ul>
							</div>
							<div class="label_btm">
								<a href="#n" class="create_label">Create a new label</a>
								<hr>
								<a href="#n" class="label_mode">Enable color blind friendly mode.</a>
							</div>
						</div>
					</div>
				</div>
				
	</section>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../js/jquery-ui.min.js"></script>
	<script src="../js/index.js"></script>
	<script src="../js/start.js"></script>

</body>
</html>