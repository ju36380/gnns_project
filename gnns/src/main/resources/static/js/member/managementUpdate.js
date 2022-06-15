$(document).ready(function() {
	class_on();
});

function fn_submit(){
	let frm = document.frm;
	
	if(isNaN(frm.shipperCd.value)){
		alert('출하주 코드는 숫자만 입력해주세요.');
		frm.shipperCd.focus();
		return false;
	}
	frm.submit();
}

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#manage_on");
	class_on.addClass('on');
}