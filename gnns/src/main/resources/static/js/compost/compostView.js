$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});


function onLoadSet(){
	
    if($("#msgView").val()!=""){
        alert($("#msgView").val());
    }
    
}

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#compost_on");
	class_on.addClass('on');
}
