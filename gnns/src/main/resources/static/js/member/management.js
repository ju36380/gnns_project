$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});



function onLoadSet(){
	
	if($("#msg").val()!=""){
        alert($("#msg").val());
    }
    
}

window.onload = function() {
	if($("#currentPage").val()==""){
		page=1;
	}else{
		page=Number($("#currentPage").val());
	}
	
	fn_getManagement(page);
};

function fn_search(){ 	
	page=1;
	
	if(window.event.keyCode == 13){
		
	 	fn_getManagement(page);
	}
	$("#currentPage").val("1");
};

function fn_click(){ 	
	page=1;

 	fn_getManagement(page);
};


function fn_getManagement(page){
	let searchType=$("#searchSel").val();
	let keyword=$("#searchInp").val();
	let memberShip=$("#memberShip").val();
	
	$("#memberList").empty();
	$("#divPaging").empty();
	
	$.ajax({
		type: "POST",
		url  : "/member/getManagement",
		data :  {searchType:searchType, keyword:keyword, page:page, memberShip:memberShip},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_createList(resultData.memberList, searchType, keyword, page, memberShip);
			fn_createPaging(resultData.cnt, page);
			gPage = page;
		}
	});	
}



function fn_createList(data, arg2, arg3, arg4, arg5){
	console.log(data, arg2, arg3, arg4, arg5);
	let memHtml="";
	let memberType="";
	if(data.length>0){
		for(let i=0; i<data.length; i++){
			
			if(data[i].memType == 'chul'){
				memberType = "<font color=blue>[출하주]</font> ";
			}else{
				memberType = "<font color=red>[중도매인]</font> ";
			}
			
			memHtml += "<tr>";
			memHtml += "<td class='tc'><p class='txt_01'>"+data[i].rowNum+"</p></td>";
			
			url = "/member/managementView";
			memHtml += "<td class='tl'><a href='"+url+"?seq="+data[i].seq+"&searchType="+arg2+"&keyword="+arg3+"&page="+arg4+"&memberShip="+arg5+"' class='txt_01'>"+memberType+data[i].userNm+"</a></td>";

			memHtml += "<td class='tc'><p class='txt_01'>"+data[i].jumin+"</p></td>";
			memHtml += "<td class='tc'><p class='txt_01'>"+data[i].bizNo+"</p></td>";
			memHtml += "<td class='tc'><p class='txt_01'>"+data[i].telNum+"</p></td>";
			memHtml += "<td class='tc'><p class='txt_01'>"+data[i].mobNum+"</p></td>";
			if(data[i].aprvFlag == 'N'){
				memHtml += "<td class='tc'><p class='txt_01'>"+'보류'+"</p></td>";
			}else{
				memHtml += "<td class='tc'><p class='txt_01'>"+'승인'+"</p></td>";
			}
			
			memHtml += "</tr>";
		}
	}else{
		memHtml += "<tr>";
		memHtml += "<td class='tc' colspan='7'><p class='txt_01'>등록된 회원이 없습니다.</p></td>";
		memHtml += "</tr>";
	}
	$("#memberList").append(memHtml);
}


function fn_createPaging(arg1, arg2){
	let pagingDivId = "currentPage";
	let fncNm = "fn_getManagement";
	gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};


function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#manage_on");
	class_on.addClass('on');
}
