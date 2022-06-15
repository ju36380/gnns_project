let mCate1="";
let sCate1="";
let mCate2="";
let sCate2="";
let schStrDate="";
let schEndDate="";
let jsonData="";
let totPage;

$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();
});

function onLoadSet(){
	fn_setSearchDefaultData();
	fn_getMainCategory();
	fn_getPriceInfoList();
	fn_createExcelBtn();
	page=1;
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
	$('input[name=schStrDate]').val(getDate());
	$('input[name=schEndDate]').val(getDate());
}

function fn_search(){ 
	/*page=1;
	if(window.event.keyCode == 13){
	 	fn_searchPriceList(page);
	}
	$("#currentPage").val("1")*/
};

//대분류 코드 조회
function fn_getMainCategory(){
	fn_getCmmnCode("/price/getMainCategory", fn_getMainCategoryCallback, "");
}
//대분류 셀렉트 박스
function fn_getMainCategoryCallback(data){
	let mainCategoryHtml = "";
	let mainCategoryArea = $('select[name=mainCategory]');
	let subCategoryArea = $('select[name=subCategory]');
	mainCategoryHtml +="<option value=''>대분류</option>";
	for(let idx=0; idx<data.length; idx++){
		mainCategoryHtml += "<option value='"+data[idx].cd+"'>"+data[idx].cdNm+"</option>";
	}
	
	mainCategoryArea.append(mainCategoryHtml);
	let subCategoryHtml="";
	subCategoryHtml +="<option value=''>품목</option>";
	subCategoryArea.append(subCategoryHtml);
};

//대분류 변경 이벤트-품목 코드 조회
function fn_mainCategoryChange(arg){
	fn_getCmmnCode("/price/getSubCategory", fn_getSubCategoryCallback, arg);
}

//품목코드 조회 셀렉트박스 콜백
function fn_getSubCategoryCallback(data){
	//$("#subCategory").empty();
	let subCategoryHtml = "";
	let subCategoryArea = $('select[name=subCategory]');
	subCategoryArea.empty();
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			subCategoryHtml += "<option value='"+data[i].cd+"'>"+data[i].cdNm+"</option>";
		}
	}else{
		subCategoryHtml +="<option value=''>품목</option>";
	}
	subCategoryArea.append(subCategoryHtml);
}

function fn_searchPriceList(){
	fn_getPriceInfoList(page);
}
function fn_getPriceInfoList(page){
	let mCate = $('select[name=mainCategory]').val();
	let sCate = $('select[name=subCategory]').val();
	
	if(mCate=='' || mCate==null){
		mCate1="00";
		mCate2="99";
	}else{
		mCate1 = mCate2 = mCate; 
	}
	if(sCate=='' || sCate==null){
		sCate1="0000";
		sCate2="9999";
	}else{
		sCate1 = sCate2 = sCate;
	}
	schStrDate = $('input[name=schStrDate]').val();
	schEndDate = $('input[name=schEndDate]').val();
	if(schEndDate.replaceAll("-","")<schStrDate.replaceAll("-","")){
		alert("조회 종료일이 시작일보다 이전입니다.");
		$('input[name=schEndDate]').focus();
		return false;
	}
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
	
	$.ajax({
		type: "POST",
		url  : "/price/getPriceInfoList",
		data :  {mCate1 : mCate1, mCate2:mCate2, sCate1:sCate1, sCate2:sCate2, schStrDate:schStrDate, schEndDate:schEndDate},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_getPriceInfoListCallBack(resultData.priceList, page);
			//fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});
};

function fn_getPriceInfoListCallBack(data, page){
	let resultHtml = "";
	$("#priceList").empty();
	$("#divPaging").empty();
	//한페이지 조회건수
	let defaultRowCount = 10;
	let startPage = 1;
	let startRow = (defaultRowCount*(page-1));
	totPage = Math.ceil(data.length/10);
	let lastRowCount = data.length%10;
	
	resultHtml += "<ul class='tt_head'>";
	resultHtml += "<li class='col_itmNm'>품목</li>";
	resultHtml += "<li class='col_breedNm'>품종</li>";
	resultHtml += "<li class='col_unitQty'>단량</li>";
	resultHtml += "<li class='col_unit'>단위</li>";
	resultHtml += "<li class='col_grade'>등급</li>";
	resultHtml += "<li class='col_lowPrice'>최저가</li>";
	resultHtml += "<li class='col_maxPrice'>최고가</li>";
	resultHtml += "<li class='col_avgPrice'>평균가</li>";
	resultHtml += "</ul>";
	if(data.length>0){
		
		let loopCnt = (totPage==page)?lastRowCount:10
		for(let i=startRow; i<startRow+loopCnt; i++){
			resultHtml += "<ul class='tt_body'>";
			resultHtml += "<li class='col_itmNm'>"+data[i].itemName+"</li>";
			resultHtml += "<li class='col_breedNm'>"+data[i].breedName+"</li>";	
			resultHtml += "<li class='col_unitQty'>"+parseFloat(Number(data[i].unitQty).toFixed(2)) +"</li>";
			resultHtml += "<li class='col_unit'>"+data[i].unit+"</li>";
			resultHtml += "<li class='col_grade'>"+data[i].grade+"</li>";
			resultHtml += "<li class='col_lowPrice'>"+comma(data[i].lowPrice)+"</li>";
			resultHtml += "<li class='col_maxPrice'>"+comma(data[i].maxPrice)+"</li>";
			resultHtml += "<li class='col_avgPrice'>"+comma(data[i].avgPrice)+"</li>";
			resultHtml += "</ul>";
		}
	}else{
		resultHtml += "<ul class='tt_body'>";
		resultHtml += "<li class='col_no_data'>등록된 시세 정보가 없습니다.</li>"
		resultHtml += "</ul>";
	}
	
	$("#priceList").append(resultHtml);
	
	if(data.length>0){
		//페이징 시작 페이지
		let nextStartPage = page/5;
		let lastPage =5;
		let defaultPageCnt=5;
		if(nextStartPage>1){
			if(page%5==0){
				startPage = startPage+((nextStartPage-1)*5);
			}else{
				startPage = startPage+(Math.floor(nextStartPage)*5);
			}
			lastPage = defaultPageCnt*Math.ceil(nextStartPage);
		}else{
			lastPage = defaultPageCnt;
		}
		
		let pagingHtml="";
		pagingHtml += "<a href='javascript:fn_prevPricePage();' class='btn_page_prev'>이전</a>";
		for(startPage; startPage<=lastPage; startPage++){
			let clssOn = (startPage==page)?"btn_page on":"btn_page";
			if(totPage<startPage){
			}else{
				pagingHtml += "<a href='#' onclick='javascript:fn_getPriceInfoList("+startPage+")' class='"+clssOn+"'>"+startPage+"</a>";
			}
		}
		pagingHtml += "<a href='javascript:fn_nextPricePage();' class='btn_page_next'>다음</a>";	
		
		$("#divPaging").append(pagingHtml);
	}
	gPage = page;
	jsonData = data;
	fn_createExcelBtn();
}

function fn_nextPricePage(){
	let nextPage = Number(gPage)+1;
	if(nextPage>totPage){
		alert("마지막 페이지 입니다.");
		return false;
	}
	fn_getPriceInfoList(nextPage);
	gPage = nextPage;
}
	
	
function fn_prevPricePage(){
	let prevPage = Number(gPage)-1;
	if(prevPage<1){
		alert("첫번째 페이지 입니다.");
		return false;
	}
	fn_getPriceInfoList(prevPage);
	gPage = prevPage;
}

function fn_excelDownLoad(){
	let frm = document.frm;
	frm.submit();
}

function fn_createExcelBtn(){
	$("#divBtn").empty();
	let buttonHtml = "<a href='/excel/download?mCate1="+mCate1+"&mCate2="+mCate2+"&sCate1="+sCate1+"&sCate2="+sCate2+"&schStrDate="+schStrDate+"&schEndDate="+schEndDate+"' class='btn_type_02 xls'>엑셀다운</a>";
	$("#divBtn").append(buttonHtml);
};