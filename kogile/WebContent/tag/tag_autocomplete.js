$(function() {
			$("#autocomplete").keypress(function(event) {
				//만약 64번키(@)를 누르면 자동완성기능 실행
				if (event.which == 64) {
					$("#autocomplete").autocomplete({
						source : function(request, response) { // request가 찾는 데이터인듯.
							//request.term = $("#autocomplete").val()
							$.ajax({
								type : 'post',
								url : "../tag/autoComplete.jsp",
								dataType : "json",
								data : {
									value : request.term
								},//이름을 가져가야 한다.
								success : function(data) {
									//서버에서 json 데이터 response 후 목록에 뿌려주기 위함
									response($.map(data, function(item) {
										return {
											label : item.data,
											value : item.data
										}
									}));
								},
								error : (function() {
									console.log("error");
								})
							});
						}
					});
				}
			});
		});
