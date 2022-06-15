/**
	login.js
 */
let passChkFlag=false; 
$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();
});
/*$("#newPw").focusout(function() {
	alert("z");
	fn_passwordCheck();
});*/

function onLoadSet(){
	
}



function fn_idCheck(){
	let memberId = $("#newId").val();
	if(memberId=="admin"){
		alert("해당 아이디로 가입할 수 없습니다.");
		return false;
	}
	$.ajax({
		type: "POST",
		url  : "/member/idCheck",
		data :  {memberId : memberId},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			if(resultData>0){
				alert("입력한 아이디는 이미 사용중입니다.");
				$("#newId").val("");
				$("#newId").focus();
				return false;
			}else{
				alert($("#newId").val()+"(은)는 사용 가능한 아이디입니다.");
			}
		}
	});	
};

function fn_passwordCheck(){
	let newPw = $("#newPw").val();
	if(!/^[a-zA-Z0-9]{4,10}$/.test(newPw)){
        alert("비밀번호는 숫자와 영문자 조합으로 4~10자리를 사용해야 합니다.");  
        $("#newPw").val("");
        passChkFlag=false;
        return false;
    }
    let chk_num = newPw.search(/[0-9]/g);
    let chk_eng = newPw.search(/[a-z]/ig);
    if(chk_num<0 || chk_eng<0){
        alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
        $("#newPw").val("");
        passChkFlag=false;
        return false;
    }
    passChkFlag=true;
};

function fn_passwordCheckVaildation(){
	let newPwChk = $("#newPwChk").val();
	let newPw = $("#newPw").val();
	if(newPw != newPwChk){
		alert("비밀번호가 일치하지 않습니다.");
		passChkFlag=false;
		return false;
	}else{
		passChkFlag=true;
	}
	
}

function fn_memberRegist(){
	let frm = document.frm;
	//if(!fn_vaildaitonCheck()) return false;
	frm.submit(); 
}