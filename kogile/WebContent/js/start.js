(function($) {
	$(function() {
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
			url : "detailPostAction.do",
			dataType : "JSON",
			cache : false,
			data : {
				p_no : p_no
			}
//		,
//			success : function(res){
//				var p_title =res[0].p_title;
//				var txt1 ='';
//				txt1 += p_title;
//				console.log(txt1);
//				$('#post_title').html(txt1);
//			}
		}).then(function(res){
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

})(jQuery)
