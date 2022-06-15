
let url = "/safety/safetyAdminList";
$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});

function onLoadSet(){
	$("#contentesHide").hide();
	
	fn_getAttachementFile();
	fn_createBtn();
}

function fn_search(){
	let frm = document.frm;
	frm.submit();
}

function getUrlParams() {
	var params = {};
	window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) { params[key] = value; });
	return params.boardSeq;
};


function fn_getAttachementFile(){
	let url = "/safety/getAttachementFile";
	$.ajax({
		type: "POST",
		url  : url,
		data :  {boardSeq : getUrlParams()},
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			let data = resultData;
			fn_createFileArea(data);
		}
	});	
}

function fn_createFileArea(data){
	let contentsHtml = "";
	contentsHtml+=$("#contentesHide").text();
	/*$("#contentsArea").append(contentsHtml);*/
	
	
	let fileHtml ="";
	fileHtml +="<tr>";
	fileHtml +="<th>첨부파일</th>";
	fileHtml +="<td colspan='2'>";
	if(data.attchementFile=="" || data.attchementFile==null){
	}else{
		if(data.exeType=="docx"){
			exeType="doc";
		}else{
			exeType = data.exeType.toLowerCase();
		}
		fileHtml += "<a href='/file/download?filePath=safety&fileSeq="+getUrlParams()+"'class='txt_down "+exeType+"'>"+data.attchementFile+"</a>";
	}
	fileHtml +="</td>";
	fileHtml +="</tr>";
	$("#fileName").val()
	$("#fileArea").append(fileHtml);
	
}


function fn_createBtn(){
	let buttonHtml ="";
	buttonHtml += "<a href='"+url+"?page="+$('#page').val()+"&searchType="+$('#searchType').val()+"&keyword="+$('#keyword').val()+"' class='btn_type_01 gray list'>목록</a>";
	$("#divBtn").append(buttonHtml);
};

function fn_noticeList(){
	let frm = document.noticeListForm;
	let searchType = $("#searchType").val();
	let keyword  = $("#keyword").val();
	let page  = $("#page").val();
	frm.action="/safety/safetyAdminList?page="+page+"&searchType="+searchType+"&keyword="+keyword;
	frm.submit();
}

function fn_uploadFile(obj){
		var $imgTarget = $(obj).closest(".fileArea").find(".file-view");
		
		if(obj.files[0] === undefined) {
			return false;
		}

		// 선택한 파일의 mime type
		var mimeType = obj.files[0].type.split("/")[0];
		
		var fileExt = obj.files[0].type.split("/")[1];
		
		/*if(fileExtList.indexOf(fileExt) == -1) {
			alert("gif, jpg, png 파일만 업로드 가능합니다.");
			return false;
		}*/
		
	/*	if(!fileSizeCheck(obj, 1)) {
			return false;
		}*/
		
		var formData = new FormData();
		formData.append("fileObj", $(obj)[0].files[0]);
		formData.append("kind", "image");
		
		$.ajax({
			type: "post",
			url: "/ajax/fileUpload.do",
			processData: false,
			contentType: false,
			data: formData,
			success: function(result){
				
				//미리보기
				if (obj.files && obj.files[0]) {
				    var reader = new FileReader();
				    
				    reader.onload = function(e) {
				    	$imgTarget.attr("src", e.target.result);
				    }
				    
				    $(obj).closest(".fileArea").find(".close-view").show();
				    reader.readAsDataURL(obj.files[0]); // convert base64 string
				}
				
				var fileKind = "";
				if($(obj).hasClass("representImage")) {
					//대표이미지
					fileKind = "represent";
				}
				
				if($(obj).hasClass("addImage")) {
					//추가이미지
					fileKind = "addImage";
				}
				
				//파일 업로드 후 처리
				setFileData(obj, result.fileList[0].file_seq, fileKind, result.fileList[0].ori_file_nm, result.fileList[0].file_ctrl_id);
				
			}
		});
	}
	
function fileSizeCheck(obj, fileSize) {
	var file = obj.files;
	
	if(file[0].size > 1024 * 1024 * fileSize){
		alert(fileSize + "mb 이상의 파일은 업로드가 불가합니다.");
		return false;
	}
	
	return true;
}

function safetyDel(){
	if(confirm("삭제하시겠습니까?") == true){
		var seq=$("#seqNum").val();
		window.location="/safety/safetyAdminDelete?boardSeq="+seq;
	}else{
		return false;
	
	}
}
	

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#safety_on");
	class_on.addClass('on');
}