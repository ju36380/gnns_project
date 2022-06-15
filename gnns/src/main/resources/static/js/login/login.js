/**
	login.js
 */
$(document).ready(function() {
	//화면 로딩시 초기 설정
	
});

function onLoadSet(){
    if($("#msg").val()!=""){
        alert($("#msg").val());
    }
    
    if($("#msgId").val()!=""){ // 21-10-13 추가 준혁(아이디 alert창)
		alert($("#msgId").val());
	}
	
	if($("#msgPass").val()!=""){ // 21-10-13 추가 준혁(비밀번호 찾기 - 정보 틀렸을 경우)
		alert($("#msgPass").val());
	}
	
	if($("#msgPassUp").val()!=""){ // 21-10-13 추가 준혁(비밀번호 설정 완료)
		alert($("#msgPassUp").val());
	}
}

function fn_key_press(){
    var keycode = event.keyCode;
    // enter 입력 시
    if(event.keyCode==13){
        fn_search();
    }
    
}

function fn_search(){
    if($("#idInput").val()==""){
        alert('아이디를 입력하세요');
        $("#idInput").focus();
        return;
    }
    
    if($("#pwInput").val()==""){
        alert('비밀번호를 입력하세요');
        $("#pwInput").focus();
        return;
    }
    
    fn_login();
}


function fn_login(){
	let frm = document.frm;
	frm.submit();
}
