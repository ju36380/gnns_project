function fn_idSearch(){
	let frm = document.frm;
	
	if(frm.userNm.value == ""){
		alert("이름을 입력해주세요.");
		frm.userNm.focus();
		return false;
	}
	
	frm.submit(); 
}


