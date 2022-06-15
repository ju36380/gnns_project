let prevSaleSeq = "";
let nextSaleSeq = "";
let firstSaleSeq = "";
let gSaleSeq ="";
$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();
});

function onLoadSet(){
	fn_setSearchDefaultData();
	fn_search();
};

window.onload = function() {
	//window.print();
};


//초기 조회조건 설정
function fn_setSearchDefaultData(){
	$('input[name=schStrDate]').val(getDate());
	$('input[name=schEndDate]').val(getDate());
}

	//초기 현재일자로 셋팅
function getDate(){
	let time = new Date();
	let year = time.getFullYear().toString();
	let month = ((time.getMonth() + 1)<10)?"0".concat(time.getMonth() + 1).toString():(time.getMonth() + 1).toString();
	let date = (time.getDate()<10)?"0".concat(time.getDate().toString()):time.getDate().toString();
	let toDate = year+"-"+month+"-"+date;
	return toDate;
}

//조회버튼 클릭
function fn_search(){
	//생성된 리스트 제거
	$("#listArea").empty(); 
	$("#sumArea").empty();
	fn_getPeriodList();
};

//기간별 거래 원장 조회
function fn_getPeriodList(){
	let schStrDate = $('input[name=schStrDate]').val();
	let schEndDate = $('input[name=schEndDate]').val();
	if(schStrDate==""){
		alert("조회 시작일을 입력하지 않았습니다.");
		$('input[name=schStrDate]').focus();
		return false;
	}
	if(schEndDate==""){
		alert("조회 종료일을 입력하지 않았습니다.");
		$('input[name=schEndDate]').focus();
		return false;
	}
	
	$('#bidDate').text(schStrDate+" ~ "+schEndDate);
	$.ajax({
		type: "POST",
		url  : "/wholesale/getPeriodList",
		data :  {schStrDate : schStrDate, schEndDate:schEndDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getPeriodListCallback(resultData.bidSucList);
		}
	});
}
//미지급내역 콜백
function fn_getPeriodListCallback(data){
	let resultHtml = "";
	let sumQty =0;
	let sumSalesPrice = 0;
	let sumDeposit =0;
	resultHtml +="<table>"
	resultHtml +="<caption>기간별 거래원장</caption>"
	resultHtml +="<colgroup><col width='20%'><col width='*%'><col width='*%'><col width='*%'><col width='*%'></colgroup>";
	resultHtml +="<thead><tr><th scope='col'>일자</th><th scope='col'>전일미수금</th><th scope='col'>판매액</th><th scope='col'>입금액</th><th scope='col'>외상미수금</th>";
	resultHtml +="<tbody>"
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			resultHtml += "<tr>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].saleDate+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].lastdayRecv)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].salesPrice)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].deposit)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].creditRecv)+"</p></td>";
			resultHtml += "</tr>";
			sumQty += data[i].qty;
			sumSalesPrice += data[i].salesPrice;
			sumDeposit += data[i].deposit
		}
	}else{
		resultHtml += "<td class='tc' colspan='5'><p class='txt_01'>조회된 내역이 없습니다.</p></td>";
	}
	resultHtml +="</tbody>";
	resultHtml +="<tfoot>";
	resultHtml +="<tr>";
	resultHtml +="<th class='tc' colspan='2'>합계</th>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumSalesPrice)+"</p></td>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumDeposit)+"</p></td>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumSalesPrice-sumDeposit)+"</p></td>";
	resultHtml +="</tr>";
	resultHtml +="</tfoot>";
	
	$("#listArea").append(resultHtml);
}

function print() {
    let printHtml = $('#listArea').html();
    
    let win = window.open('','_blonk','fullscreen');
    win.document.write('<html><head>'
            +'<link rel="stylesheet" type="text/css" href="/static/css/reset.css">'
            +'<link rel="stylesheet" type="text/css" href="/static/css/font.css">'
            +'<link rel="stylesheet" type="text/css" href="/static/css/common.css">'
            +'<link rel="stylesheet" type="text/css" href="/static/css/sub.css">'
            +'</head><body>'
            +'<div class="content">'
            +'<div class="wrap">'
            +'<div class="w_in">'
            +'<div class="sub_contents" style="margin-top: 20px;">'
            +'<div class="sub_in" >'
            +'<div class="tit_comment">'
            +'<p>중도매인 기간별 거래원장</p>'
            +'</div>'
            +'<ul class="member_about mt30">'
            +'<li><span>일자 : </span><span>'+$("#bidDate").text()+'</span></li>'
            +'<li><span>중도매인(매참인)번호 : </span><span>'+$("#salerCd").text()+'</span></span></li>'
            +'<li><span>이름 : </span><span>'+$("#spanUserNm").text()+'</span></span></li>'
            +'</ul>'
            +'<div class="title_box mt10" >'
            +'<div class="fr">'
            +'<span class="txt_unit">(단위:원)</span>'
            +'</div>'
            +'</div>'
            +'<div class="table_type_01 mt10">'
    );
    win.document.write(printHtml);
    win.document.write('</div></div></div></div></div></div></body></html>');
    win.document.close();
    win.focus();
    
    setTimeout(function() {
        win.print();
        win.close();
      }, 1000);
    
}