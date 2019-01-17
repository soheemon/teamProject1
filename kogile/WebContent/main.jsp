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
<title></title>
</head>
<body>
	<header> </header>

	<section class="main">
		<div class="wrap2">
			<div class="top_menu">
				<div class="menu_left">
					<h2>${pb.pjt_title}</h2>
					<span class="a_1"><a href="#n">Travidux</a></span> <span
						class="a_2"><a href="#n"></a></span> <span class="a_3"><a
						href="#n">Team Visible</a></span>
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
					<div class="item_content">


						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Manager Reaches Out</h4>
								<div class="btn_box">
									<span class="list"></span> <span class="check">0/4</span> <span
										class="date">Jul 20</span>
								</div>
								<div class="peo_box">
									<img src="images/peo.png" alt="" />
								</div>
							</a>
						</div>


						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Forms to Sign</h4>
								<div class="btn_box">
									<span class="list"></span> <span class="check">3/13</span>
								</div>
								<div class="peo_box">
									<img src="images/peo.png" alt="" /> <img src="images/peo.png"
										alt="" />
								</div>
							</a>
						</div>

						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Enroll in</h4>
								<div class="btn_box">
									<span class="check">0/8</span>
								</div>
								<div class="peo_box">
									<img src="images/peo.png" alt="" /> <img src="images/peo.png"
										alt="" />
								</div>
							</a>
						</div>
					</div>


					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Doing</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content">
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Check out our Employees Manual Board!</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Sign up for:</h4>
								<div class="btn_box">
									<span class="list"></span> <span class="check">0/8</span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Fill in Paperwork</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Get Added To Office Directory</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Get on Our Birthday List</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Done</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content">
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Get A Tour</h4>
								<div class="btn_box">
									<span class="list"></span> <span class="clip">2</span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>Get Building ID and Floor Key Card</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
					</div>
					<button class="add_txt">Add a card...</button>
				</div>

				<div class="item">
					<div class="heading">
						<h3 class="board_title">Close</h3>
						<a href="#n" class="more">···</a>
					</div>
					<div class="item_content">
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>READ ME FIRST</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
						<div class="post">
							<a href="#n" class="post_item">
								<div class="progress"></div>
								<h4>More on Desks & Chairs</h4>
								<div class="btn_box">
									<span class="list"></span>
								</div>
								<div class="peo_box"></div>
							</a>
						</div>
					</div>
					<button class="add_txt">Add a card...</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>