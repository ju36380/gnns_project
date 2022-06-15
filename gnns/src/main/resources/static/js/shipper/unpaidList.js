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
	
};


//초기 조회조건 설정
function fn_setSearchDefaultData(){
	$('input[name=schDate]').val(getDate());
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
	$("#unpaidList").empty(); 
	fn_getUnpaidList();
};

//미지급내역조회
function fn_getUnpaidList(){
	let schDate = $('input[name=schDate]').val();
	$.ajax({
		type: "POST",
		url  : "/shipper/getUnpaidList",
		data :  {schDate : schDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getUnpaidListCallback(resultData);
		}
	});
}
//미지급내역 콜백
function fn_getUnpaidListCallback(data, arg){
	let resultHtml ="";
	let sumSettlementAmt = 0;
	let sumPayment = 0;
	let sumBalance =0;
	
	resultHtml +="<table>"
	resultHtml +="<caption>미지급내역 테이블</caption>"
	resultHtml +="<colgroup><col width='25%'><col width='25%'><col width='25%'><col width='25%'></colgroup>";
	resultHtml +="<thead><tr><th scope='col'>생산자</th><th scope='col'>정산액</th><th scope='col'>지불액</th><th scope='col'>현잔액</th></tr></thead>";
	resultHtml +="<tbody>"
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			resultHtml += "<tr>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].producer+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].settlementAmount)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].payment)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].balance)+"</p></td>";
			resultHtml += "</tr>";
			sumSettlementAmt +=Number(data[i].settlementAmount);
			sumPayment += Number(data[i].payment);
			sumBalance += Number(data[i].balance);
		}
	}else{
		resultHtml += "<td class='tc' colspan='4'><p class='txt_01'>미지급 내역이 없습니다.</p></td>";
	}
	resultHtml +="</tbody>";
	resultHtml +="<tfoot>";
	resultHtml +="<tr>";
	resultHtml +="<th class='tc'>합계</th>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumSettlementAmt)+"</p></td>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumPayment)+"</p></td>";
	resultHtml +="<td class='tr'><p class='txt_01 bold'>"+comma(sumBalance)+"</p></td>";
	resultHtml +="</tr>";
	resultHtml +="</tfoot>";
	
	$("#unpaidList").append(resultHtml);
}

function print() {
    let printHtml = $('#unpaidList').html();
    
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
            +'<p>일자별 미지급 내역서</p>'
            +'</div>'
            +'<ul class="member_about mt30">'
            +'<li><span>일자:</span><span>'+$("#schDate").val()+'</span></li>'
            +'<li><span>출하주:</span><span>'+$("#spanUserNm").text()+'</span></span></li>'
            +'</ul>'
            +'<div class="title_box mt10" >'
            +'<div class="fr">'
            +'<span class="txt_unit">(단위:원)</span>'
            +'</div>'
            +'</div>'
            +'<div class="table_type_01 mt10">'
    );
    win.document.write(printHtml);
    win.document.write('</div>');
    win.document.write('</div></div></div></div></div></body></html>');
    win.document.close();
    win.focus();
    
    setTimeout(function() {
        win.print();
        win.close();
      }, 1000);
    
}