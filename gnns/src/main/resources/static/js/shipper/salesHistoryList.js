let prevSaleSeq = "";
let nextSaleSeq = "";
let firstSaleSeq = "";
let gSaleSeq ="";

$(document).ready(function() {
	//화면 로딩시 초기 설정
});

function onLoadSet(){
	fn_setSearchDefaultData();
	fn_getSalesSeq("F", firstSaleSeq);
};

window.onload = function() {
	
};

function getDate(){
	let time = new Date();
	let year = time.getFullYear().toString();
	let month = ((time.getMonth() + 1)<10)?"0".concat(time.getMonth() + 1).toString():(time.getMonth() + 1).toString();
	let date = (time.getDate()<10)?"0".concat(time.getDate().toString()):time.getDate().toString();
	let toDate = year+"-"+month+"-"+date;
	return toDate;
}

function fn_setSearchDefaultData(){
	$('input[name=schDate]').val(getDate());
}

function fn_search(){ 
	fn_getSalesSeq("F", firstSaleSeq);
};

//첫번쨰 판매일련번호 조회
function fn_getSalesSeq(arg1, arg2){
	let schDate = $('input[name=schDate]').val();
	let saleSeq = "";
	$.ajax({
		type: "POST",
		url  : "/shipper/getSalesSeq",
		data :  {schDate : schDate, seqType:arg1, saleSeq:arg2},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
		
			saleSeq = resultData.salesSeq;
			if(arg1=="F"){
				if(saleSeq !=null){
					$("#saleList").empty();
					$("#sumList").empty();
					
					fn_getSalesHistoryList(saleSeq);
					gSaleSeq = saleSeq;	
				}else{
					$("#saleList").empty();
					$("#sumList").empty();
					
					let resultHtml ="";
					resultHtml += '<tr>';
			        resultHtml += '<td class="tc" colspan="8">등록된 시세 정보가 없습니다.</td>';
			        resultHtml += '</ul>';
					$("#saleList").append(resultHtml);
					
					let sumHtml ="";
					sumHtml+="<dl>";
				    sumHtml+="<dt>판매액</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    sumHtml+="<dl>";
				    sumHtml+="<dt>수수료</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    sumHtml+="<dl>";
				    sumHtml+="<dt>운임</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    sumHtml+="<dl>";
				    sumHtml+="<dt>하역비</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    sumHtml+="<dl>";
				    sumHtml+="<dt>기타공제액</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    sumHtml+="<dl>";
				    sumHtml+="<dt>차인잔액</dt>";
				    sumHtml+="<dd>0</dd>";
				    sumHtml+="</dl>";
				    
				    $("#sumList").append(sumHtml);
					
					
					return false;
				}
			}
			if(arg1=="N"){
				if(saleSeq!=null){
					nextSaleSeq = saleSeq;
					$("#nextBtn").empty();
					let buttonHtml = "<a href='#' onclick='javascript:fn_getNextSalesList()' class='btn_type_01 gray write'>다음</a>";
					$("#nextBtn").append(buttonHtml);
				}else{
					$("#nextBtn").empty();
				}
			}
			if(arg1=="P"){
				if(saleSeq!=null){
					prevSaleSeq = saleSeq;
					$("#prevBtn").empty();
					let buttonHtml = "<a href='#' onclick='javascript:fn_getPrevSalesList()' class='btn_type_01 gray write'>이전</a>";
					$("#prevBtn").append(buttonHtml);
				}else{
					$("#prevBtn").empty();
				}
			}
		}
	});
}

//판매내역 조회
function fn_getSalesHistoryList(arg){
	let schDate = $('input[name=schDate]').val();
	$.ajax({
		type: "POST",
		url  : "/shipper/salesHistoryList",
		data :  {saleSeq:arg, schDate : schDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getSalesHistoryListCallback(resultData, arg);
		}
	});
}
//판매내역 콜백
function fn_getSalesHistoryListCallback(data, arg){
    let salesPrice=0;
    let fees=0;
    let fare=0;
    let unloadingFee=0;
    let otherDeductions=0;
    let balance=0;
    let resultHtml ="";
    let sumHtml ="";
	

	if(data.length>0){
		for(let i=0; i<data.length; i++){
			resultHtml += '<tr>';
			resultHtml += '<td class="tc"><p class="txt_01">'+data[i].producer+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+data[i].breedName+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+parseFloat(Number(data[i].unitQty).toFixed(2))+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+data[i].unit+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+data[i].grade+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+parseFloat(Number(data[i].qty).toFixed(2))+'</p></td>'
			resultHtml += '<td class="tr"><p class="txt_01">'+comma(parseFloat(Number(data[i].unitPrice).toFixed(2)))+'</p></td>'
			resultHtml += '<td class="tc"><p class="txt_01">'+data[i].wholesaler+'</p></td>'
			resultHtml += '</tr>';
			
            salesPrice = salesPrice + data[i].salesPrice
			fees = fees + data[i].fees
			fare = fare + data[i].fare
			unloadingFee = unloadingFee + data[i].unloadingFee
			otherDeductions = otherDeductions + data[i].otherDeductions
			balance = balance + data[i].balance
		}
	}else{
		resultHtml += '<tr>';
		resultHtml += '<td class="tc" colspan="8">등록된 시세 정보가 없습니다.</td>';
		resultHtml += '</tr>';
	}
	sumHtml+="<dl>";
    sumHtml+="<dt>판매액</dt>";
    sumHtml+="<dd>"+comma(salesPrice)+"</dd>";
    sumHtml+="</dl>";
    sumHtml+="<dl>";
    sumHtml+="<dt>수수료</dt>";
    sumHtml+="<dd>"+comma(fees)+"</dd>";
    sumHtml+="</dl>";
    sumHtml+="<dl>";
    sumHtml+="<dt>운임</dt>";
    sumHtml+="<dd>"+comma(fare)+"</dd>";
    sumHtml+="</dl>";
    sumHtml+="<dl>";
    sumHtml+="<dt>하역비</dt>";
    sumHtml+="<dd>"+comma(unloadingFee)+"</dd>";
    sumHtml+="</dl>";
    sumHtml+="<dl>";
    sumHtml+="<dt>기타공제액</dt>";
    sumHtml+="<dd>"+comma(otherDeductions)+"</dd>";
    sumHtml+="</dl>";
    sumHtml+="<dl>";
    sumHtml+="<dt>차인잔액</dt>";
    sumHtml+="<dd>"+comma(balance)+"</dd>";
    sumHtml+="</dl>";
	
    $("#saleList").append(resultHtml);
	fn_getSalesSeq("P", gSaleSeq);
	fn_getSalesSeq("N", gSaleSeq);
	
	$("#sumList").append(sumHtml);
	
}

function fn_getNextSalesList(){
	fn_getSalesHistoryList(nextSaleSeq);
};

function fn_getPrevSalesList(){
	fn_getSalesHistoryList(prevSaleSeq);
}

function print() {
    let printHtml = $('#printArea').html();
    let sumListHtml = $('#sumList').html();
    
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
            +'<p>일자별 판매 내역서</p>'
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