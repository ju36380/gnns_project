$(document).ready(function() {
	//화면 로딩시 초기 설정
	
});

function onLoadSet(){
    
    if($("#msg").val()!=""){
        alert($("#msg").val());
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
    
    fn_adminLogin();
}


function fn_adminLogin(){
	let frm = document.frm;
	frm.submit();
}
