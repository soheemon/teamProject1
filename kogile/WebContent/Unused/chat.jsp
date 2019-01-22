<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<title>chat</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../style/chat.css">
<!-- <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
<script src="../js/jquery-1.12.4.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
	var lastID = 0;

	$(document).ready(function() {
		chatListFunction();
		getInfiniteChat();
	});
	//상대방이 보낸것도 확인해야 하기때문에 시간마다 체크
	function getInfiniteChat() {
		setInterval(function() {
			chatListFunction();
		}, 1000);
	}

	/*입력값을컨트롤로 보냅니다.*/
	function submitFunction() {
		var chatName = $('#info_no').val();
		var chatContent = $('#chatContent').val();
		$.ajax({
			type : "POST",
			url : "chatInsert.chat",
			data : {//데이터가공 에러방지위해서  하나의 객체로 묶어서보냄 데이터라는걸로
				/* 	chatName : encodeURIComponent(chatName),
					chatContent : encodeURIComponent(chatContent) */
				info_no : chatName,
				chatContent : chatContent
			},
		});
		$('#chatContent').val('');
	}

	function chatListFunction() {
		var chatName = $('#info_no').val();
		var chatContent = $('#chatContent').val();
		$.ajax({
			type : "POST",
			url : "chatList.chat",
			dataType : "JSON",

			success : function(data) {
				var txt = "";
				for (var i = 0; i < data.length; i++) {
					txt += "<p>" + data[i].info_no + data[i].chat_contents
							+ data[i].chat_date + "</p>";
				}
				console.log(data.length);
				$("#chatList").html(txt);
			}
		});
	}
</script>
</head>

<body>
	<div class="container">
		<div class="container bootstrap snippet">
			<div class="row">
				<div class="col-xs-12">
					<div class="portlet portlet-default">
						<div class="panel-heading">
							<div class="portlet-title">
								<h4>
									<i class="fa fa-circle text-green"></i>
								</h4>
							</div>
							<div class="clearfix"></div>
						</div>

						<div id="chat" class="panel-cpllapse collapse in">


							<div id="chatList" class="portlet-body chat-widget"
								style="overflow-y: auto; width: auto; height: 300px;"></div>



							<div class="portlet-footer">
								<div class="row">
									<div class="form-group col-xs-4">
										<input style="height: 40px;" type="hidden" id="info_no"
											class="form-control" maxlength="20" value="1">
									</div>
								</div>

								<div class="row" style="height: 90px">
									<div class="form-group col-xs-10">
										<textarea style="height: 80px;" id="chatContent"
											class="form-control" placeholder="message" maxlength="100"></textarea>
									</div>

									<div class="form-group col-xs-2">
										<button type="button" class="btn btn-default pull-right"
											onClick="submitFunction();">Submit</button>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>