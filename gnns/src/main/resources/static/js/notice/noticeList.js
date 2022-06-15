let articleType = (window.location.href.indexOf("notice")>0)?"1":"3";
let url="";
$(document).ready(function() {
	//화면 로딩시 초기 설정
});


window.onload = function() {
	if($("#currentPage").val()==""){
		page=1;
	}else{
		page=Number($("#currentPage").val());
	}
	if(articleType=="1"){
		$("#nTitle").text("공지사항");
	}else{
		$("#nTitle").text("유통정보");
	}
	fn_getNoticeList(page);
};

function fn_search(){ 
	page=1;
	if(window.event.keyCode == 13){
	 	fn_getNoticeList(page);
	}
	$("#currentPage").val("1")
};


function fn_getNoticeList(page){
	let searchType=$("#searchSel").val();
	let keyword=$("#searchInp").val();
	$("#noticeList").empty();
	$("#divPaging").empty();
	
	$.ajax({
		type: "POST",
		url  : "/notice/getNoticeList",
		data :  {searchType : searchType, keyword:keyword, page:page,articleType:articleType},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_createList(resultData.noticeList, searchType, keyword, page);
			fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});	
}

function fn_createList(data, arg2, arg3, arg4){
	let notiHtml="";
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			notiHtml += "<tr>";
			notiHtml += "<td class='tc'><p class='txt_01'>"+data[i].rowNum+"</p></td>";
			if(articleType=="3"){
			
			}
			url = (articleType=="1")?"/notice/noticeView":"/price/distributionView";
			notiHtml += "<td class='tl'><a href='"+url+"?notiSeq="+data[i].notiSeq+"&searchType="+arg2+"&keyword="+arg3+"&page="+arg4+"' class='txt_01'>"+data[i].subject+"</a></td>";

			if(data[i].exeType!=""){
				notiHtml += "<td class='tc'><a href='/file/download?filePath=notice&fileSeq="+data[i].notiSeq+"'class='ico_down "+data[i].exeType+"'></a></td>";
			}else{
				notiHtml += "<td class='tc'></td>";
			}

			notiHtml += "<td class='tc'><p class='txt_01'>"+data[i].readCnt.toLocaleString()+"</p></td>";
			notiHtml += "<td class='tc'><p class='txt_01'>"+data[i].regId+"</p></td>";
			notiHtml += "<td class='tc'><p class='txt_01'>"+data[i].regDttm+"</p></td>";
			notiHtml += "</tr>";
		}
	}else{
		notiHtml += "<tr>";
		notiHtml += "<td class='tc' colspan='6'><p class='txt_01'>등록된 공지사항이 없습니다.</p></td>";
		notiHtml += "</tr>";
	}
	$("#noticeList").append(notiHtml);
}


function fn_createPaging(arg1, arg2){
	let pagingDivId = "currentPage";
	let fncNm = "fn_getNoticeList";
	gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};
