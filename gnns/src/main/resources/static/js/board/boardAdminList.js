$(document).ready(function() {
	class_on();
});

function onLoadSet(){
	
	if($("#msg").val()!=""){
        alert($("#msg").val());
    }
};

window.onload = function() {
	if($("#currentPage").val()==""){
		page=1;
	}else{
		page=Number($("#currentPage").val());
	}
	fn_getBoardList(page);
};

function fn_search(){ 
	page=1;
	if(window.event.keyCode == 13){
	 	fn_getBoardList(page);
	}
	$("#currentPage").val("1")
};

function fn_getBoardList(page){
	let searchType=$("#searchSel").val();
	let keyword=$("#searchInp").val();
	$("#boardList").empty();
	$("#divPaging").empty();
	$.ajax({
		type: "POST",
		url  : "/board/getBoardAdminList",
		data :  {searchType : searchType, keyword:keyword, page:page},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData) {
			fn_createList(resultData.boardAdminList, searchType, keyword, page);
			fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});	
};

//조회된 목록 생성
function fn_createList(data, arg2, arg3, arg4){
	let listHtml="";
		listHtml += "<ul class='tt_head'>";
		listHtml += "<li class='col_num'>번호</li>";
		listHtml += "<li class='col_title'>제목</li>";
		listHtml += "<li class='col_file'>파일</li>";
		listHtml += "<li class='col_views'>조회수</li>";
		listHtml += "<li class='col_writer'>작성자</li>";
		listHtml += "<li class='col_day'>작성일</li>";
		listHtml += "</ul>";
		if(data.length>0){
			for(let i=0; i<data.length; i++){
				listHtml += "<ul class='tt_body'>";
				listHtml += "<li class='col_num'><p class='num'>"+data[i].rowNum+"</p></li>";
				if(data[i].reLevel>0){
					listHtml += "<li class='col_title'><a href='/board/boardAdminView?boardSeq="+data[i].boardSeq+"&searchType="+arg2+"&keyword="+arg3+"&page="+arg4+"' class='txt_01 reple'>"+data[i].subject+"</a></li>";
				}else{
					listHtml += "<li class='col_title'><a href='/board/boardAdminView?boardSeq="+data[i].boardSeq+"&searchType="+arg2+"&keyword="+arg3+"&page="+arg4+"' class='txt_01'>"+data[i].subject+"</a></li>";
				}
				if(data[i].exeType=="" || data[i].exeType==null){
					listHtml += "<li class='col_file'><p class='ico_down'></p></li>";
				}else{
					let exeType="";
					if(data[i].exeType=="docx"){
						exeType= "doc";
					}else{
						exeType=(data[i].exeType==""||data[i].exeType==null)?"":data[i].exeType.toLowerCase();
					}
					listHtml += "<li class='col_file'><a href='/file/download?filePath=board&fileSeq="+data[i].boardSeq+"' class='ico_down "+exeType+"'></a></li>"
				}
				listHtml += "<li class='col_views'><p class='views'><span>조회수</span>"+data[i].readCnt.toLocaleString()+"</p></li>";
				listHtml += "<li class='col_writer'><p class='writer'>"+data[i].regId+"</p></li>";
				listHtml += "<li class='col_day'><p class='upload_day'>"+data[i].regDttm+"</p></li>";
				listHtml += "</ul>";
			}
		}else{
			listHtml += "<ul class='tt_body'>";
			listHtml += "등록된 내용이 없습니다.";
			listHtml += "</ul>";
		}
		$("#boardList").append(listHtml);
}


function fn_createPaging(arg1, arg2){
	let pagingDivId = "currentPage";
	let fncNm = "fn_getBoardList";
	gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#board_on");
	class_on.addClass('on');
}
