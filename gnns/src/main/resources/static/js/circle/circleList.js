// 준혁(추가)
$(document).ready(function() {
	class_on();
//	now_date(); // 현날짜 출력.
});

function class_on(){ 
	let class_on = $("#circle_on");
	class_on.addClass('on');
}

function now_date(){ // 현재날짜 가져오기
	document.getElementById('nowDate').value = new Date().toISOString().substring(0, 10);
}


window.onload = function() {
	
	if($("#saleSeq").val()==""){
		saleSeq=0;
		
	}else{
		saleSeq=$("#saleSeq").val();
	}	
	fn_getSeq(saleSeq);
};

function fn_search(){ 
	
	if($("#saleSeq").val()==""){
		saleSeq=0;
	}else{
		saleSeq=$("#saleSeq").val();
	}
	fn_getSeq(saleSeq);
//	$("#currentPage").val("1");
};

function fn_en(){
	if(window.event.keyCode == 13){
		saleSeq=$("#saleSeq").val();
	 	fn_getSeq(saleSeq);
	}
	
}

function fn_getCircleList(saleSeq){
	
	let searchType=$("#nowDate").val(); // 날짜
	let searchSel=$("#searchSel").val(); // 매장
	let keyword=$("#dFarm").val(); // 생산자
	
	$("#circleSubject").empty();
	$("#circleContent").empty();
	$("#divPaging").empty();
	$.ajax({
		type: "POST",
		url  : "/circle/getCircleList",
		data :  {searchType : searchType, keyword:keyword, saleSeq:saleSeq, searchSel:searchSel},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData) {
			fn_createList(resultData.circleList, searchType, keyword, saleSeq);
		}
	});	
};

function fn_getSeq(saleSeq){
	let searchType=$("#nowDate").val(); // 날짜
	let searchSel=$("#searchSel").val(); // 매장
	let keyword=$("#dFarm").val(); // 생산자
	
	$.ajax({
		type: "POST",
		url  : "/circle/getCircleList",
		data :  {searchType : searchType, keyword:keyword, saleSeq:saleSeq, searchSel:searchSel},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData) {
			fn_saleSeq(resultData.nextSeq, resultData.preSeq, resultData.nowSeq, resultData.oneSeq);
		//	fn_createList(resultData.circleList, searchType, keyword, saleSeq);

		}
	});	
};

// 다음, 이전 원표번호
function fn_saleSeq(nextSeq, preSeq, nowSeq, oneSeq){
	
	let seqInput = document.getElementById("saleSeq");
	seqInput.value=null;
	
	if(preSeq !== undefined){
		$('input[name=preSaleSeq]').attr('value', preSeq[0].saleSeq); // 전원표
	}else{
		if(nowSeq != 0){
			$('input[name=preSaleSeq]').attr('value', nowSeq[0].saleSeq);	
		}
	}

	if(nowSeq !== undefined){
		if(nowSeq != 0){
			$('input[name=saleSeq]').attr('value', nowSeq[0].saleSeq); // 현재 원표
		}
	}else{
		$('input[name=saleSeq]').attr('value', oneSeq[0].saleSeq);
	}
	
	if(nextSeq !== undefined){
		if(nowSeq[0].saleSeq == nextSeq[0].saleSeq){
			if(nowSeq.length == 1){ // 데이터가 1개 밖에 없을시
				$('input[name=nextSaleSeq]').attr('value', nextSeq[0].saleSeq);
			}else{
				$('input[name=nextSaleSeq]').attr('value', nowSeq[1].saleSeq); // 다음원표
			}
		}else{
			$('input[name=nextSaleSeq]').attr('value', nextSeq[0].saleSeq); // 다음원표
		}
	}else{
		if(oneSeq != 0){
			$('input[name=nextSaleSeq]').attr('value', oneSeq[0].saleSeq);
		}
	}
	
	
	if(nowSeq !== undefined){
		if(nowSeq != 0){
			seqInput.value=nowSeq[0].saleSeq;
			fn_getCircleList(nowSeq[0].saleSeq);
		}else{
			fn_getCircleList(0);
		}
	}else{
		seqInput.value=oneSeq[0].saleSeq;
		fn_getCircleList(oneSeq[0].saleSeq);
	}
	
}

//조회된 목록 생성
function fn_createList(data, arg2, arg3, arg4){
	let tot_qty = 0; // 총 수량
	let listHtml="";
		listHtml += "<ul class='tt_head'>";
		listHtml += "<li class='col_views'>출하자</li>";
		listHtml += "<li class='col_views'>생산자</li>";
		listHtml += "<li class='col_views'>산지</li>";
		listHtml += "<li class='col_views'>품종</li>";
		listHtml += "<li class='col_views'>수량계</li>";
		listHtml += "</ul>";
		if(data.length > 0){
			for(let i=0; i<data.length; i++){
				tot_qty += data[i].dQty;
			}
			
			listHtml += "<ul class='tt_body'>";
			listHtml += "<li class='col_views'>"+data[0].chulName+"</li>";
			listHtml += "<li class='col_views'>"+data[0].dFarm+"</li>";
			listHtml += "<li class='col_views'>"+data[0].sanName+"</li>";
			listHtml += "<li class='col_views'>"+data[0].gmName+"</li>";
			listHtml += "<li class='col_views'>"+tot_qty+"</li>";
			listHtml += "</ul>";
			listHtml += "<input type='text' id='bigo' name='bigo' value='"+data[0].dBigo+"'>";
		}else{
			listHtml += "<li>데이터가 없습니다.</li>";
		}
		$("#circleSubject").append(listHtml);
		
		let contentHtml="";
		contentHtml += "<ul class='tt_head'>";
		contentHtml += "<li class='col_views'>품종</li>";
		contentHtml += "<li class='col_views'>중량</li>";
		contentHtml += "<li class='col_views'>포장</li>";
		contentHtml += "<li class='col_views'>등급</li>";
		contentHtml += "<li class='col_views'>과수</li>";
		contentHtml += "<li class='col_views'>수량</li>";
		contentHtml += "</ul>";
		if(data.length > 0){
			for(let i=0; i<data.length; i++){
				contentHtml += "<ul class='tt_body'>";
				contentHtml += "<li class='col_views'>"+data[i].gmName+"</li>";
				contentHtml += "<li class='col_views'>"+data[i].danQty+"</li>";
				contentHtml += "<li class='col_views'>"+data[i].dDan+"</li>";
				contentHtml += "<li class='col_views'>"+data[i].graName+"</li>";
				contentHtml += "<li class='col_views'>"+data[i].dKasu+"</li>";
				contentHtml += "<li class='col_views'>"+data[i].dQty+"</li>";
				contentHtml += "</ul>";
			}
			
			
			
		}
		$("#circleContent").append(contentHtml);
				
}

function fn_pre(){
	let preSaleSeq=$("#preSaleSeq").val();
	let nowSeq=$("#saleSeq").val();
	if(preSaleSeq == "" || preSaleSeq == nowSeq){
		alert("첫 원표 입니다.");
		return false;
	}else{
		fn_getSeq(preSaleSeq);
	}
	
}

function fn_next(){
	let nextSaleSeq=$("#nextSaleSeq").val();
	let nowSeq=$("#saleSeq").val();
	if(nextSaleSeq == "" || nextSaleSeq == nowSeq){
		alert("마지막 원표 입니다.");
		return false;
	}else{
		fn_getSeq(nextSaleSeq);
	}
	
}

function fn_hUp(){
	let hBigo = $("#bigo").val();
	
}






