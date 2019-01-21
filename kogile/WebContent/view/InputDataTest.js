/**
 * 입력값 검증 테스트.
 */
window.onload = init;
function init() {
	//alert('hello!');
	var test = document.getElementById("KakaoRegFormSub");
	console.log(test);
	test.onclick = FormInputCk;
}

//submit의 부모(form)을 가져온다.
function FormInputCk() {
	var form = this.parentNode;
	var inputs = form.getElementsByTagName("input");
	for(var index = 0; index < inputs.length; index++) {
		var type = inputs[index].getAttribute("name");
		
		switch (type) {
		case "name":
			console.log("name!!!!!");
			var res1 = nameTest(inputs[index].value);
			if(res1){
				break;
			}else {
				return false;
			}
		case "password":
			console.log("password!!!!!");
			var res2 = pwTest(inputs[index].value);
			if(res2){
				break;
			}else {
				return false;
			}
			
		case "email":
			console.log("email!!!!!");
			var res3 = emailTest(inputs[index].value);
			if(res3){
				break;
			}else {
				return false;
			}
		default:
			break;
		}
	}
	return true;
}

function pwTest(password) {
	
	if(password.length < 8 || password.length > 20) {
		alert("8자리~ 20자리 이내로 입력해 주세요.");
		return false;
	}
	if(password.search(/\s/) != -1) {
		alert("비밀번호에 공백을 입력 할 수 없습니다.");
		return false;
	}
	var num = password.search(/[0-9]/g); //숫자의 위치. 없으면 -1
	var eng = password.search(/[a-z]/ig); //영문자의 위치. 없으면 -1.
	var spe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);//특수문자의 위치. 없으면 -1.

	if(num < 0 || eng < 0 || spe < 0){
		alert("영문,숫자,특수문자를 1자이상 혼합하여 입력해 주세요.");
		return false;
	}
	
	return true;
}
function emailTest(email) {
	
	if(email.length < 0) {
		alert("이메일을 입력해 주세요.");
		return false;
	}
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(email.match(regExp) == null) {
		alert("올바른 이메일을 입력해 주세요.");
		return false;
	}
	return true;
}
function nameTest(name) {
	
	if(name.length < 2 || name.length > 20) {
		alert("이름은 2자이상 20자 이하여야 합니다.");
		return false;
	}
	var spe = name.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(spe >= 0) {
		alert("이름에는 특수문자를 입력 할 수 없습니다.");
		return false;
	}
	return true;	
}