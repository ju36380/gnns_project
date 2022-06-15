$(document).ready(function() {
	//화면 로딩시 초기 설정
	class_on();
});


function fn_pdsRegist(){
	let frm = document.frm;
	if(!fn_vaildaitonCheck()) return false;
	fn_lastFileDel();
	frm.submit(); 
}

function fn_vaildaitonCheck(){
	if(fn_isNull($("#title").val(), "제목")==false){
		$("#title").focus();
		return false;
	}
	
	if(fn_isNull($("#subject").val(), "내용")==false){
		$("#subject").focus();
		return false;
	}
	return true;
}


function uploadFile(obj){
	let $imgTarget =$(obj).closest("file_upload").find(".btn_file_close");
	if(obj.files[0] === undefined) {
		return false;
	}
	$("#hide").val(2);
	
	let mimeType = obj.files[0].type.split("/")[0];
		
	let fileExt = obj.files[0].type.split("/")[1];
	let fileName = $(obj)[0].files[0].name;
	let formData = new FormData();
	formData.append("fileObj", $(obj)[0].files[0]);
	formData.append("kind", "image");
	formData.append("filePath", "pds");
	
	$.ajax({
			type: "post",
			url: "/file/fileUpload",
			processData: false,
			contentType: false,
			data: formData,
			success: function(result){
				let data=result.fileList;
				fn_fileUploadCallback(fileName);
				console.log(data);
				//파일 업로드 후 처리
				//setFileData(obj, result.fileList[0].file_seq, fileKind, result.fileList[0].ori_file_nm, result.fileList[0].file_ctrl_id);
			}
		});
};



function fn_fileUploadCallback(arg1){
	$("#fileName").val(arg1);
	let fileHtml = "<input type='hidden' value='"+arg1+"' name='attchementFile'>";
	
	$("#uploadFileArea").empty();
	$("#uploadFileArea").append(fileHtml);
}

function fn_deleteFile(){  // 2021-11-18 준혁(추가)
	let formData = new FormData();
	
	formData.append("seq", $("#pdsSeq").val());
	formData.append("fileName", $("#delFile").val());
	formData.append("filePath", "pds");
	formData.append("hide", $("#hide").val());
	
	$.ajax({
		type: "post",
		url: "/file/fileDelete",
		enctype: "multipart/form-data",
		processData: false,
		contentType: false,
		data : formData,
		success: function(data){
		}
	});
}

function fn_save(){ // 2021-11-18 준혁(추가)
	$("#old_file").hide(); // hide
	$("#hide").val(1);
	$("#pre_file").val('');
}

function fn_lastFileDel(){ // 2021-11-18 준혁(추가)
	let hide = $("#hide").val();
	if(hide != "2"){
		fn_deleteFile();
	}
}

function class_on(){ // 2021-11-19 준혁(추가)
	let class_on = $("#pds_on");
	class_on.addClass('on');
}