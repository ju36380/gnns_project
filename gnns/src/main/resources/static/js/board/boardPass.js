$(document).ready(function() {
	//화면 로딩시 초기 설정
});

function onLoadSet(){
	if($("#msg").val()!=""){
        alert($("#msg").val());
    }
}

function fn_boardRegist(){
	let frm = document.frm;
	if(!fn_vaildaitonCheck()) return false;
	frm.submit(); 
}

function fn_vaildaitonCheck(){
	let passWd = $('input[name=passWd]');
	if(fn_isNull(passWd.val(), "비밀번호")==false){
		passWd.focus();
		return false;
	}
	
	return true;
}

