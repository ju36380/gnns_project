/**
	login.js
 */
/*function onLoadSet(){ 기존 코드
    var url = window.location.href;
    if(url.indexOf("wholesale")){
        $("#comment").text("중도매인만 접근 가능합니다.");
    }else if(url.indexOf("shipper")){
        $("#comment").text("출하주만 접근 가능합니다.");
    }
}*/




function onLoadSet(){ // 2022-01-06 준혁 수정
	var url = window.location.href;
    let acc = url.indexOf("wholesale");
    
    if(acc != -1){
        $("#comment").text("중도매인만 접근 가능합니다.");
    }else if(url.indexOf("shipper")){
        $("#comment").text("출하주만 접근 가능합니다.");
    }
}