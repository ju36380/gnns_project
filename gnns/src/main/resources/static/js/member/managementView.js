$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});

function onLoadSet(){
	
    if($("#msgView").val()!=""){
        alert($("#msgView").val());
    }
    
}

function fn_delete(){
	if(confirm("삭제하시겠습니까?") == true){
		var seq=$("#seqNum").val();
		window.location="/member/managermentDelete?seq="+seq;
	}else{
		return false;
	}
	
}
	
function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#manage_on");
	class_on.addClass('on');
}
