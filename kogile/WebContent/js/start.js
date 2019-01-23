(function($) {
	$(function() {
//		$('#memberList').css('display', 'inline');
		
		$('#insertProjectForm').on(
				'click',
				function() {
					window.open('insertProject.pjt', '프로젝트 생성',
							'width= 500, height = 350, left=400, top=200;');
					return false;
				})

		$('.closeWindow').on('click', function() {
			window.close();
			return false;
		})

		$('#insertProject').on('click', function() {
			insertProject();
			return false;
		})
		
		$('.detailPostView').on('click', function(){
//			var url='detailPostAction.do?p_no=' + p_no;
//			console.log(p_no);
//			
//			window.open(url, '뷰 상세보기', 'width=740, height =600, left=400, top=200');
			var p_no = $(this).find('.select_pno').val();
			detailPostView(p_no);
			showdescription();
			replyPrint();
			return false;
		})
		
		$('#d_dateList').on('click', function(){
//			현재날짜 (시간제외 9시로 맞춰짐)
			var now = new Date($('#now').val());
//			var now = new Date();
//			now.setHours(9);
//			now.setMinutes(0);
//			now.setSeconds(0);
			console.log(now);

			var cris = new Date($('#d_dateList').html());
			console.log(cris);
			
			//날짜 차일 계산
			var gap = cris.getTime() - now.getTime();
			gap =  Math.floor(gap / (1000 * 60 * 60 * 24));
			if(gap > 0){
				alert('마감일까지 ' + gap +'일 남았습니다.');				
			}else if(gap == 0){
				alert('금일까지 작업 완료가 필요합니다.');
				
			}else{
				alert('마감일이 지났습니다.');
			}
			
			return false;
		})
		
		$('.add_txt').on('click', function(){
			$('.InsertPopUp').show();
			$("html, body").css({overflow : "hidden", height : $(window).height()}).bind("scroll touchmove", function(e){e.preventDefault();e.stopPropagation();return false;});
			insertPostForm();
			return false;
		});
		
		$('#insertPost').on('click', function(){
			$('.popup').hide();
			$("html, body").css({overflow : "visible", height : "auto"}).unbind('scroll touchmove mousewheel');
			insertPost();
			return false;
		});
		
		//label(0122)
		var click_check = $('.label_btn').hasClass('on');

		$('.label_btn').on('click', function(){
			click_check = $('.label_btn').hasClass('on');
			if(click_check == false){
	          $(this).addClass('on');
	          $('.label_box').show();
	        }else{
	          $(this).removeClass('on');
	          $('.label_box').hide();
	        }
	        return false;
	      });
		$('.label_btn').on('click', function(){
			listLabel();
	        return false;
		})

		$('.label_close').on('click', function(){
			$('.label_btn').removeClass('on');
			$('.label_box').hide();
		});
		
		$('#btn_inviteList').on('click', function(){
			inviteList();
			return false;
		})
		
		$('#notice_btn').on('click', function(){
			window.open('noticeAction.no', '알림', 'width= 500, height = 350, left=400, top=200;');
			return false;
		})
		$('#Replysubmit').on('click',function(){
			replyInsert();
			replyPrint();
			return false;
		})

		$('#updateSubmit').click(replyUpdate);

	})

	function insertProject() {
		var pjt_title = $('#pjt_title').val();
		var pjt_contents = $('#pjt_contents').val();

		$.ajax({
			type : "POST",
			url : "insertProjectFormAction.pjt",
			dataType : "JSON",
			cache : false,
			data : {
				pjt_title : pjt_title,
				pjt_contents : pjt_contents
				},
				success : function(res) {
					window.close();
					var txt = '';
					for (var i = 0; i < res.length; i++) {
						txt += '<li>';
						txt += '<a href="detailProject.pjt?pjt_no='
								+ res[i].pjt_no + '">' + res[i].pjt_title
								+ '</a>';
						txt += '</li>';
						}
						$(opener.document).find('#pjt').html(txt);
					}
				});
	}
	
	
	function detailPostView(p_no){
		$.ajax({
			type : "POST",
			dataType : "JSON",
			data : {
				p_no : p_no
			},
			url : "detailPostAction.do"
//		,
//			success : function(res){
//				var p_title =res[0].p_title;
//				var txt1 ='';
//				txt1 += p_title;
//				console.log(txt1);
//				$('#post_title').html(txt1);
//			}
		}).then(function(res){
			console.log(res);
			var txt1 ='';
			txt1 += res[0].p_title;
			console.log(txt1);
			$('#post_title').html(txt1);
			
			if(res[1] != null){
				var txt2 = '';
				txt2 += res[1].d_date.slice(0,10);
				txt2.split(10);
				
				$('#d_dateList').html(txt2).css('display', 'inline');
				
			}else{
				$('#d_dateList').html('마감일이 없습니다.').css('display', 'none');
			}
						
		}).catch(function(err){
			console.error(err);
		})
		
		
	}
	
	function insertPostForm(){
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : "insertPostFormAction.do",
		}).then(function(res){
			console.log(res);
			var txt = '';
			for(var i =0; i<res[1].length; i++){
				txt += '<option value="';
				txt += res[1][i].c_no;
				txt += '">' + res[1][i].c_title + '</option>';
			}
			console.log(txt);
			$("select[name=pjt_card]").html(txt);
			
			var txt2 = '';
			for(var i =0; i<res[0].length; i++){
//				txt2 += '<label>'
				txt2 += '<input name="pjt_member" type="checkbox" value="';
				txt2 += res[0][i].total_no + '">';
				txt2 += res[0][i].name + '</input>';
			}
			console.log(txt2);
			$('#pjt_member').html(txt2);
		}).catch(function(err){
			console.error(err);
		})
	}
	
	function insertPost(){
		var insertForm = $("form[name=insertPostForm]").serialize();
		
		$.ajax({
			type : "POST",
			url : "insertPostAction.do",
			data : insertForm,
			dataType : "JSON" 
		}).then(function(res){
			var txt ='';
			txt += '<a href="#n" class="detailPostView post ui-state-default">';
			txt += '<div class="post_item">';
			txt += '<input type="hidden" class="select_pno" value="' + res.p_no + '">';
			txt += '<h4>' +res.p_title+ '</h4>';
			txt += '<div class="btn_box">';
			txt += '<span class="list"></span> <span class="check">0/4</span> <spanclass="date">Jul 20</span>';
			txt += '</div>';
			txt += '<div class="peo_box"></div>';
			txt += '</div></a>';
			var i = '#' + res.c_no;
			$(i).append(txt);
			
		}).catch(function(e){
			console.error(e);
		})
	}
	
	function listLabel(){
		const data = {};
		
		$.ajax({
			type : 'GET',
			url : 'labellist.do',
			dataType : 'JSON',
			data : data
		}).then(function(res){
			console.log(res);
			var txt = '';
			for(var i = 0; i < res.length; i++){
				if(res[i].color_no == 1){
					txt += '<li>';
					txt += '<input type="hidden" value="'+ res[i].label_no + '" class="select_l_no">';
					txt += '<a href="#n" class="card_edit"></a>';
					txt += '<span class="card_label red">'+ res[i].label_text + '</span>';
					txt += '</li>';
				}else if(res[i].color_no == 2){
					txt += '<li>';
					txt += '<input type="hidden" value="'+ res[i].label_no + '" class="select_l_no">';
					txt += '<a href="#n" class="card_edit"></a>';
					txt += '<span class="card_label orange">'+ res[i].label_text + '</span>';
					txt += '</li>';
				}else if(res[i].color_no == 3){
					txt += '<li>';
					txt += '<input type="hidden" value="'+ res[i].label_no + '" class="select_l_no">';
					txt += '<a href="#n" class="card_edit"></a>';
					txt += '<span class="card_label yellow">'+ res[i].label_text + '</span>';
					txt += '</li>';
				}else if(res[i].color_no == 4){
					txt += '<li>';
					txt += '<input type="hidden" value="'+ res[i].label_no + '" class="select_l_no">';
					txt += '<a href="#n" class="card_edit"></a>';
					txt += '<span class="card_label green">'+ res[i].label_text + '</span>';
					txt += '</li>';
				}
				console.log(txt);
				$('#mylabel_list').html(txt);
			}
			
		}).catch(function(err){
			console.log('fail');
		})
	}
	
	function inviteList(){
		const data = {};
		
		$.ajax({
			type : 'get',
			dataType : 'JSON',
			url : 'inviteListAction.in'
		}).then(function(res){
			console.log(res);
			var txt = '';
			for(var i = 0; i<res.length; i++){
				txt += '<span class="glyphicon glyphicon-user">'+ res[i].name +'</span>';
			}
			$('#inviteList').html(txt);
		}).catch(function(err){
			console.log('fail');
		})
	}
	
	function notice_execute(){
		const data = $("form[name=notice_form]").serialize();
		$.ajax({
			data : data,
			type : 'POST',
			dataType : 'JSON',
			url : 'noticeAction.no'
		}).then(function(res){
			window.open('noticeAction.no')
		}).catch(function(err){
			console.log('fail');
		})
		
	}
	
	function showdescription() {
		$.ajax({
			type : 'GET',
			dataType : 'JSON',
			url : 'descriptionlist.do'
		}).then(function(res){
			var txt = '';
			txt = res[0].d_contents;			
			$('#myDescription').html('');
			$('#myDescription').html(txt);
		}).catch(function(err){
			console.log('fail');
		})
		
	}
	
	function replyPrint(){
		
		$.ajax({
			type : 'GET',
			async: false,
			url : "descriptionlistAjax.do",
			success : parse,
			error : (function() {
				console.log("error");
			})
		});
	}
	//서버에서 json Arr형식의 데이터를 보내주면 그것을 파싱해서 자바스크립트 객체배열로 바꾼다.
	function parse(data) {
		console.log(data);
		//alert(data);
		var table = document.getElementById("reply"); //table을 가져온다.
		$(table).empty();
		printMenu(table);
		
		var replyArr = JSON.parse(data); // reply
//		console.log(replyArr);
		for(var index = 0; index < replyArr.length; index++){
			var reply = replyArr[index];
			//console.log(reply);
			printData(reply);
		}
	}
	
//	<ul>
//	<li><span class="name">철희</span>
//		<div class="input_box">
//			<span class="fullname">정철희</span> <span class="date">Jan
//				16 at 10:00 AM</span> <span class="cts"> <span class="id">@junjang7</span>
//				ㅎㅇㅎㅇ
//			</span> <a href="#n" class="rep_btn">Reply</a>
//		</div></li>
//		</ul>
	function printData(data) {
		var table = document.getElementById("reply"); //table을 가져온다.
		
		var tr = document.createElement("tr");
		table.appendChild(tr);
		
		//내용 
		var r_contents = document.createElement("td");
		r_contents.innerHTML = data.r_contents;
		tr.appendChild(r_contents);
		
		var d_contents = document.createElement("td");
		d_contents.innerHTML = data.d_contents;
		tr.appendChild(r_contents);
		
		//작성일 
		var r_date = document.createElement("td");
		r_date.innerHTML = data.r_date;
		tr.appendChild(r_date);
		
		//작성자
		var r_writer = document.createElement("td");
		r_writer.innerHTML = data.name;
		tr.appendChild(r_writer);
		
		//수정
		var mod = document.createElement("td");
		var modA = document.createElement("a");
		modA.setAttribute("href", "#");
		modA.innerHTML = '수정';
		modA.classList.add('modify');
		modA.id = data.r_no + '#' + data.info_no;
		
		mod.appendChild(modA);
		tr.appendChild(mod);
		
		//삭제
		var del = document.createElement("td");
		var delA = document.createElement("a");
		//replyDelete.do?r_no=${reply.r_no }&info_no=${reply.info_no}
		var deleteLink = "replyDelete.do?r_no="+data.r_no+"&info_no="+data.info_no;
		delA.setAttribute("href", deleteLink);
		delA.innerHTML = '삭제';
		del.appendChild(delA);
		
		tr.appendChild(del);
		addEvent();
	}
	//modify a태그를 찾아서 이벤트 핸들러 등록.
	function addEvent() {
		var aTags = document.getElementsByClassName('modify');
		for(var index = 0; index < aTags.length; index++){
			$(aTags[index]).click(function(){
				var updateForm = document.getElementById("replyUpdateForm");
				updateForm.style.display="block";
				var r_no = this.id;
				replyModify(r_no);
			});
		}
	}
	function printMenu(table) {
		
		var tr = document.createElement("tr");
		table.appendChild(tr);
		
		var td1 = document.createElement("td");
		td1.innerHTML = "댓글내용";
		tr.appendChild(td1);
		
		var td2 = document.createElement("td");
		td2.innerHTML = "작성일";
		tr.appendChild(td2);
		var td3 = document.createElement("td");
		td3.innerHTML = "작성자";
		tr.appendChild(td3);
		var td4 = document.createElement("td");
		td4.innerHTML = "수정";
		tr.appendChild(td4);
		var td5 = document.createElement("td");
		td5.innerHTML = "삭제";
		tr.appendChild(td5);
		
	}
	
	function replyModify(r_no){
		//alert('helloworld');
		$.ajax({
			type : 'GET',
			url : "UpdateReplyFormAjax.do",
			data : {replyInfo:r_no},
			success : replyModifyPrint,
			error : (function() {
				console.log("error");
			})
		});
	}

	function replyModifyPrint(data){
		console.log(data);
		var reply = JSON.parse(data).reply;
		console.log(reply.info_no);
		
		var updateForm = document.getElementById("replyUpdateForm");
		var r_contents = updateForm.r_contents;
		var r_no = updateForm.r_no;
		var info_no = updateForm.info_no;
		
		r_no.value = reply.r_no;
		info_no.value = reply.info_no;
		r_contents.value = reply.r_contents;
	}
	
	function desInsert() {
		var textArea = document.getElementById("desFormTextArea");
		//alert(textArea);
		//console.log(textArea);
		var desContents = {
				desContents : textArea.value
		};
		desContentsJson = JSON.stringify(desContents);
		//console.log(desContentsJson);
		
		$.ajax({
			type : 'POST',
			url : "insertDescriptionAjax.do",
			contentType: "application/json; charset=UTF-8",
			dataType:"json",
			data : desContentsJson,
			success : (function(){
				console.log('ok');
			}),
			error : (function() {
				console.log("error");
			})
		});
		
		var desForm = document.getElementById("descrptionForm");
		desForm.style.display="none";//Form 사라지게 한다.
		
		return false;
	}

	function desFormShow() {
		var desForm = document.getElementById("descrptionForm");
		desForm.style.display="block";//Form 나타나게한다.
	}

	function replyUpdate() {
		//alert('ter!');
		var updatetextArea = document.getElementById("updateFormContents");
		var updateForm = document.getElementById("replyUpdateForm");
		
		var r_contents = updatetextArea.value;
		
		var r_no = updateForm.r_no.value;
		var info_no = updateForm.info_no.value;
		//console.log(r_no);
		var updateReply = {
				'r_contents':r_contents,
				'r_no':r_no,
				'info_no':info_no
		};
		
		console.log(updateReply);
		replyUpdateJson = JSON.stringify(updateReply);
		
		$.ajax({
			type : 'POST',
			url : "UpdateReplyAjax.do",
			contentType: "application/json; charset=UTF-8",
			async: false,
			dataType:"json",
			data : replyUpdateJson,
			success : (function(){console.log('ok');}),
			error : (function() {
				console.log("error");
			})
		});
		//console.log(replyUpdateJson);
		replyPrint();
		var updateForm = document.getElementById("replyUpdateForm");
		updateForm.style.display="none";
		
		return false;
	}

	function replyInsert() {
		//alert($('#r_contents').innerHTML());
		var r_contents = document.getElementById("r_contents").value;
		var tag_name = document.getElementById("autocomplete").value;
		
		
		var info_no = "1";
		//console.log(test);
		var reply = {
			'info_no':info_no,
			'r_contents': r_contents,
			't.info_no' : tag_name
		};
		replyJson = JSON.stringify(reply);
		console.log(replyJson);
		$('#r_contents').val('');
		
		$.ajax({
			type : 'POST',
			url : "insertReplyAjax.do",
			dataType:"json",
			data : replyJson,
			success : replyPrint,
			error : (function() {
				console.log("error");
			})
		});
		return false;
	}
	
	
})(jQuery)
