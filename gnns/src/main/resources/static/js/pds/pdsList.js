$(document).ready(function() {
	//화면 로딩시 초기 설정
});

window.onload = function() {
	if($("#currentPage").val()==""){
		page=1;
	}else{
		page=Number($("#currentPage").val());
	}
	fn_getPdsList(page);
};

function fn_search(){ 
	page=1;
	if(window.event.keyCode == 13){
	 	fn_getPdsList(page);
	}
	$("#currentPage").val("1")
};


function fn_getPdsList(page){
	let searchType=$("#searchSel").val();
	let keyword=$("#searchInp").val();
	$("#pdsList").empty();
	$("#divPaging").empty();
	$.ajax({
		type: "POST",
		url  : "/pds/getPdsList",
		data :  {searchType : searchType, keyword:keyword, page:page},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_createList(resultData.pdsList, searchType, keyword, page);
			fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});	
}

function fn_createList(data, arg2, arg3, arg4){
	let pdsHtml="";
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			pdsHtml += "<tr>";
			pdsHtml += "<td class='tc'><p class='txt_01'>"+data[i].rowNum+"</p></td>";
			pdsHtml += "<td class='tl'><a href='/pds/pdsView?pdsSeq="+data[i].pdsSeq+"&searchType="+arg2+"&keyword="+arg3+"&page="+arg4+"' class='txt_01'>"+data[i].subject+"</a></td>";

			if(data[i].exeType!=""){
				pdsHtml += "<td class='tc'><a href='/file/download?filePath=pds&fileSeq="+data[i].pdsSeq+"'class='ico_down "+data[i].exeType+"'></a></td>";
			}else{
				pdsHtml += "<td class='tc'></td>";
			}

			pdsHtml += "<td class='tc'><p class='txt_01'>"+data[i].readCnt.toLocaleString()+"</p></td>";
			pdsHtml += "<td class='tc'><p class='txt_01'>"+data[i].regId+"</p></td>";
			pdsHtml += "<td class='tc'><p class='txt_01'>"+data[i].regDttm+"</p></td>";
			pdsHtml += "</tr>";
		}
	}else{
		pdsHtml += "<tr>";
		pdsHtml += "<td class='tc' colspan='5'><p class='txt_01'>등록된 공지사항이 없습니다.</p></td>";
		pdsHtml += "</tr>";
	}
	$("#pdsList").append(pdsHtml);
}


function fn_createPaging(arg1, arg2){
	let pagingDivId = "currentPage";
	let fncNm = "fn_getPdsList";
	gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};
