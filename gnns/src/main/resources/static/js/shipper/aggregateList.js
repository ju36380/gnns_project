let prevSaleSeq = "";
let nextSaleSeq = "";
let firstSaleSeq = "";
let gSaleSeq ="";
$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet_aggre();
});

function onLoadSet_aggre(){
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
	$("#aggregateList").empty(); 
	$("#aggregateSum").empty();
	fn_getAggregateList();
};

//미지급내역조회
function fn_getAggregateList(){
	let schStrDate = $('input[name=schStrDate]').val();
	let schEndDate = $('input[name=schEndDate]').val();
	let shipperCode='00996';
	$.ajax({
		type: "POST",
		url  : "/shipper/getAggregateList",
		data :  {schStrDate : schStrDate, schEndDate:schEndDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getAggregateListCallback(resultData);
		}
	});
}
//미지급내역 콜백
function fn_getAggregateListCallback(data){
	let sumSalesPrice=0;
	let sumFees=0;
	let sumFare=0;
	let sumUnloadingFee=0;
	let sumOtherDeductions =0;
	let sumBalance=0;
	
	let resultHtml ="";
	if(data.length>0){
		for(let i=0; i<data.length; i++){
		    resultHtml += '<tr>';
            resultHtml += '<td class="tc"><p class="txt_01">'+data[i].producer+'</p></td>'
            resultHtml += '<td class="tc"><p class="txt_01">'+comma(data[i].volume)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].salesPrice)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].fees)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].fare)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].unloadingFee)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].otherDeductions)+'</p></td>'
            resultHtml += '<td class="tr"><p class="txt_01">'+comma(data[i].balance)+'</p></td>'
            resultHtml += '</tr>';
            
			sumSalesPrice += Number(data[i].salesPrice);
			sumFees +=Number(data[i].fees);
			sumFare	+=Number(data[i].fare);
			sumUnloadingFee +=Number(data[i].unloadingFee);
			sumOtherDeductions +=Number(data[i].otherDeductions);
			sumBalance +=Number(data[i].balance);
		}
	}else{
	    resultHtml += '<tr>';
        resultHtml += '<td class="tc" colspan="8">등록된 정보가 없습니다.</td>';
        resultHtml += '</tr>';
	}
	
	$("#aggregateList").append(resultHtml);
	
	let sumHtml = "";
	sumHtml +="<dl>";
	sumHtml +="<dt>판매액</dt>";
	sumHtml +="<dd>"+comma(sumSalesPrice)+"</dd>";
	sumHtml +="</dl>";
	sumHtml +="<dl>";
	sumHtml +="<dt>수수료</dt>";
	sumHtml +="<dd>"+comma(sumFees)+"</dd>";
	sumHtml +="</dl>";
	sumHtml +="<dl>";
	sumHtml +="<dt>운임</dt>";
	sumHtml +="<dd>"+comma(sumFare)+"</dd>";
	sumHtml +="</dl>";
	sumHtml +="<dl>";
	sumHtml +="<dt>하역비</dt>";
	sumHtml +="<dd>"+comma(sumUnloadingFee)+"</dd>";
	sumHtml +="</dl>";
	sumHtml +="<dl>";
	sumHtml +="<dt>기타공제액</dt>";
	sumHtml +="<dd>"+comma(sumOtherDeductions)+"</dd>";
	sumHtml +="</dl>";
	sumHtml +="<dl>";
	sumHtml +="<dt>차인금액</dt>";
	sumHtml +="<dd>"+comma(sumBalance)+"</dd>";
	sumHtml +="</dl>";
	$("#aggregateSum").append(sumHtml);
}

function print() {
    let printHtml = $('#printArea').html();
    let sumListHtml = $('#aggregateSum').html();
    
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
            +'<p>출하주 생산자별 실적집계</p>'
            +'</div>'
            +'<ul class="member_about mt30">'
            +'<li><span>일자:</span><span>'+$("#schStrDate").val()+'</span><span class="hyphen">~</span><span>'+$("#schEndDate").val()+'</span></li>'
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