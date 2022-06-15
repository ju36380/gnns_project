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
		$("#newPwChk").val("");
		passChkFlag=false;
		return false;
	}else{
		passChkFlag=true;
	}
	
}

function fn_passUpdate(){
	let frm = document.frm;
	
	frm.submit(); 
}