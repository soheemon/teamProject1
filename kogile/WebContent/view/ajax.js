
$(function() {
	replyPrint();
	$('#Replysubmit').click(replyInsert);
	$('#updateSubmit').click(replyUpdate);
	$('#desATag').click(desFormShow);
	//$('replyUpdateForm').click();
	$('#descriptionSubmit').click(desInsert);
});

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
	
	var p_no = "1";
	var info_no = "1";
	//console.log(test);
	var reply = {
		'p_no':p_no,
		'info_no':info_no,
		'r_contents': r_contents,
		't.info_no' : tag_name
	};
	replyJson = JSON.stringify(reply);
	console.log(replyJson);
	
	$.ajax({
		type : 'POST',
		url : "insertReplyAjax.do",
		contentType: "application/json; charset=UTF-8",
		dataType:"json",
		data : replyJson,
		success : replyPrint,
		error : (function() {
			console.log("error");
		})
	});
	return false;
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
//	console.log(replyArr);
	for(var index = 0; index < replyArr.length; index++){
		var reply = replyArr[index];
		//console.log(reply);
		printData(reply);
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
//하나의 객체를 받아서 화면에 뿌려줍니다.
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
//r_no를 받아서
//서버에 데이터를 요청하고(Ajax)
//수정폼에 데이터를 넣어준다.
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