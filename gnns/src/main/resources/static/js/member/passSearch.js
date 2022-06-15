function fn_passSearch(){
	let frm = document.frm;
	
	if(frm.userId.value == ""){
		alert("이름을 입력해주세요.");
		frm.userId.focus();
		return false;
	}
	
	if(frm.userNm.value == ""){
		alert("이름을 입력해주세요.");
		frm.userNm.focus();
		return false;
	}
	
	if(frm.mobNum.value == ""){
		frm.mobNum.value = "--"
	}
	
	frm.submit(); 
}