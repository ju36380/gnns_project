
$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
	fn_selected();
});

function onLoadSet(){
	if($("#currentPage").val()==""){
		page=1;
	}else{
		page=Number($("#currentPage").val());
	}
	fn_compostList(page);
};

window.onload = function() {
	
};


function fn_search(){ 
	page=1;
	if(window.event.keyCode == 13){
	 	fn_compostList(page);
	}
	$("#currentPage").val("1")
};

//부산물퇴비 지원 신청현황
function fn_compostList(page){
	let searchType = $("#searchSel").val();
	let keyword = $("#searchInp").val();
	$("#listArea").empty();
	$("#divPaging").empty();
	$.ajax({
		type: "POST",
		url  : "/compost/getCompostList",
		data :  {searchType : searchType, keyword:keyword, page:page},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_compostListCallback(resultData.compostList, searchType, keyword, page);
			fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});
}
//부산물 퇴비 신청내역
function fn_compostListCallback(data, arg1, arg2, arg3){
	let resultHtml = "";
	let compo = '/compost/compostView?seq=';
	resultHtml +="<table>"
	resultHtml +="<caption>일자별 낙찰명세서</caption>";
	resultHtml +="<colgroup><col width='10%'><col width='15%'><col width='20%'><col width='20%'><col width='20%'><col width='15%'></colgroup>";
	resultHtml +="<thead><tr><th scope='col'>No.</th><th scope='col'>이름</th><th scope='col'>출하품목</th><th scope='col'>휴대폰</th><th scope='col'>등록일시</th><th scope='col'>처리상태</th></tr></thead>";
	resultHtml +="<tbody>";
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			url = compo+data[i].seq+"&searchType="+arg1+"&keyword="+arg2+"&page="+arg3;
			
			resultHtml += '<tr onClick="location.href='+"'"+url+"'"+'" style="cursor:pointer;">';
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].rnum+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].name+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].breedNm+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].mobilePhone+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].regDttm+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].receiptStatus+"</p></td>";
			resultHtml += "</tr>";
			
		}
	}else{
		resultHtml += "<td class='tc' colspan='6'><p class='txt_01'>조회된 내역이 없습니다.</p></td>";
	}
	resultHtml +="</tbody>";
	resultHtml +="</table>";
	$("#listArea").append(resultHtml);
}

function fn_createPaging(arg1, arg2){
	let pagingDivId = "currentPage";
	let fncNm = "fn_compostList";
	gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};


function fn_click(){ 	
	page=1;

 	fn_compostList(page);
};

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#compost_on");
	class_on.addClass('on');
}

function fn_selected(){
	let sel_val = $("#searchSel").val();
	const seaPlac = document.querySelector('input');
	const seaVal = document.getElementById('searchInp');
	myPlaceholder = seaPlac.placeholder;
	if(sel_val == "all"){
		seaPlac.placeholder = '전체일 경우 검색 버튼을 클릭해주세요';
		seaVal.value = null;
		seaVal.readOnly = true;
	}else{
		seaPlac.placeholder = '검색어를 입력하세요';
		seaVal.readOnly = false;
	}
	
	
	
}