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
	$("#listArea").empty(); 
	$("#sumArea").empty();
	fn_getBidSuccessList();
};

//낙찰 내역 조회
function fn_getBidSuccessList(){
	let schDate = $('input[name=schDate]').val();
	$('#bidDate').text(schDate);
	
	$.ajax({
		type: "POST",
		url  : "/wholesale/getBidSuccessList",
		data :  {schDate : schDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getBidSuccessListCallback(resultData.bidSucList);
		}
	});
}
//미지급내역 콜백
function fn_getBidSuccessListCallback(data){
	let resultHtml = "";
	let sumQty =0;
	let sumSalesPrice = 0;
	resultHtml +="<table>"
	resultHtml +="<caption>일자별 낙찰명세서</caption>"
	resultHtml +="<colgroup><col width='*%'><col width='*%'><col width='15%'><col width='15%'><col width='*%'><col width='*%'><col width='*%'><col width='*%'></colgroup>";
	resultHtml +="<thead><tr><th scope='col'>원표번호</th><th scope='col'>생산자</th><th scope='col'>품종</th><th scope='col'>단량</th><th scope='col'>등급/과수</th>";
	resultHtml +="<th scope='col'>수량</th><th scope='col'>단가</th><th scope='col'>판매액</th></tr></thead>";
	resultHtml +="<tbody>"
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			resultHtml += "<tr>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].originNumber+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].producer+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].breedName+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].unitQty+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+data[i].grade+"</p></td>";
			resultHtml += "<td class='tc'><p class='txt_01'>"+comma(data[i].qty)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].unitPrice)+"</p></td>";
			resultHtml += "<td class='tr'><p class='txt_01'>"+comma(data[i].salesPrice)+"</p></td>";
			resultHtml += "</tr>";
			sumQty += data[i].qty;
			sumSalesPrice += data[i].salesPrice;
		}
	}else{
		resultHtml += "<td class='tc' colspan='8'><p class='txt_01'>해당 자료가 없습니다.</p></td>";
	}
	resultHtml +="</tbody>";
	resultHtml +="<tfoot>";
	resultHtml +="<tr>";
	resultHtml +="<th class='tc' colspan='5'>합계</th>";
	resultHtml +="<td class='tc'><p class='txt_01 bold'>"+comma(sumQty)+"</p></td>";
	resultHtml +="<td class='tr' colspan='2'><p class='txt_01 bold'>"+comma(sumSalesPrice)+"</p></td>";
	resultHtml +="</tr>";
	resultHtml +="</tfoot>";
	
	$("#listArea").append(resultHtml);
	let sumHtml ="";
	if(data.length>0){
		sumHtml +="<dl> <dt>전일미수</dt> <dd>"+comma(data[0].prevdayAccRecv)+"</dd> </dl>";
		sumHtml +="<dl> <dt>금일판매</dt> <dd>"+comma(sumSalesPrice)+"</dd> </dl>";
		sumHtml +="<dl> <dt>금일입금</dt> <dd>"+comma(data[0].todayDeposit)+"</dd> </dl>";
		sumHtml +="<dl> <dt>금일미수</dt> <dd>"+comma(data[0].todayAccRecv)+"</dd> </dl>";
		
	}else{
		sumHtml +="<dl> <dt>전일미수</dt> <dd>0</dd> </dl>";
		sumHtml +="<dl> <dt>금일판매</dt> <dd>0</dd> </dl>";
		sumHtml +="<dl> <dt>금일입금</dt> <dd>0</dd> </dl>";
		sumHtml +="<dl> <dt>금일미수</dt> <dd>0</dd> </dl>";
	}	
	$("#sumArea").append(sumHtml);
	
}

function print() {
    let printHtml = $('#listArea').html();
    let sumListHtml = $('#sumArea').html();
    
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
            +'<p>일자별 낙찰명세서</p>'
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
    win.document.write('</div><div class="chart">');
    win.document.write(sumListHtml);
    win.document.write('</div></div></div></div></div></div></body></html>');
    win.document.close();
    win.focus();
    
    setTimeout(function() {
        win.print();
        win.close();
      }, 1000);
    
}