let gPage=1;
let lastPage=5;
let totpage;
$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();

});

function gfn_createPaging(arg1, arg2, divId, fncNm){
	//페이지 수
	totpage = arg1.totPage;
	//기본 페이지수
	let defaultPageCnt =5;
	//페이징 HTML
	let pagingHtml = "";
	//페이징 시작 페이지
	let startPage = 1;
	let nextStartPage = arg2/5;
	let lastPage =5;
	if(nextStartPage>1){
		if(arg2%5==0){
			startPage = startPage+((nextStartPage-1)*5);
		}else{
			startPage = startPage+(Math.floor(nextStartPage)*5);
		}
		lastPage = defaultPageCnt*Math.ceil(nextStartPage);
	}else{
		lastPage = defaultPageCnt;
	}
	
	pagingHtml += "<a href='javascript:fn_prevPage("+fncNm+");' class='btn_page_prev'>이전</a>";
	for(startPage; startPage<=lastPage; startPage++){
		let clssOn = (startPage==arg2)?"btn_page on":"btn_page";
		if(totpage<startPage ){
		}else{
			pagingHtml += "<a href='#' onclick='javascript:"+fncNm+"("+startPage+")' class='"+clssOn+"'>"+startPage+"</a>";
		}
	}
	pagingHtml += "<a href='javascript:fn_nextPage("+fncNm+");' class='btn_page_next'>다음</a>";	
	
	$("#divPaging").append(pagingHtml);
	
	$(divId).val(arg2);
}

function fn_nextPage(fncNm){
	let nextPage = Number(gPage)+1;
	if(nextPage>totpage){
		alert("마지막 페이지 입니다.");
		return false;
	}
	fncNm(nextPage);
	gPage = nextPage;
}

function fn_prevPage(fncNm){
	let prevPage = Number(gPage)-1;
	if(prevPage<1){
		alert("첫번째 페이지 입니다.");
		return false;
	}
	fncNm(prevPage);
	gPage = prevPage;
}

function fn_isNull(arg1, arg2){
	if(arg1==""){
		alert(arg2+"(을)를 입력하지 않았습니다.");
		return false;
	}else{
		return true;
	}
}

function fn_getCmmnCode(url, callbackFunc, arg1){
	$.ajax({
		type: "POST",
		url  : url,
		data :  {cd : arg1},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			callbackFunc(resultData);
		}
	});	
}


function comma(num){
    let len, point, str; 
    let positive=true;
    positive = (num<0)?false:true;
    
    num = Math.abs(num) + ""; 
    point = num.length % 3 ;
    len = num.length; 
   
    str = num.substring(0, point); 
    while (point < len) { 
        if (str != "") str += ","; 
        str += num.substring(point, point + 3); 
        point += 3; 
    }
	str = (positive==true)?str:"\\"+str;
    return str;
}

function fn_login(){
	let frm = document.frm;
	frm.submit();
}

function onLoadSet(){
	if($("#msgUp").val()!=""){
        alert($("#msgUp").val());
    }
    
}
