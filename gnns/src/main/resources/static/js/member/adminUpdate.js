$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});

function fn_key_press(){
    var keycode = event.keyCode;
    // enter 입력 시
    if(event.keyCode==13){
        fn_update();
    }
    
}

function fn_update(){
	let frm = document.frm;
	
	if(frm.pwInput.value == ""){
		alert("비밀번호를 입력해주세요.");
		frm.pwInput.focus();
		return false;
	}
	
	frm.submit(); 
}

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#admin_on");
	class_on.addClass('on');
}