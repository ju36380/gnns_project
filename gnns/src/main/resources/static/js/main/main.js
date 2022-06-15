$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadMain();
});

function onLoadMain(){
	fn_getMainPriceInfo(); // 시세정보
	fn_getMainNotice(); // 공지사항
	fn_getMainPds(); // 자료실
}

function fn_getMainPriceInfo(){	
	$.ajax({
		type: "POST",
		url  : "/main/getMainPriceInfo",
        dataType : 'json',
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData) {
			fn_getMainPriceInfoCall(resultData.mainPrice);
		}
	});
}

function fn_getMainPriceInfoCall(data){
	let resultHtml = "";
	
    if(data.length>0){
        for(let i=0; i<data.length; i++){
            resultHtml += '<tr>';
            resultHtml += '<td>'+data[i].itemName+'</td>';
            resultHtml += '<td>'+data[i].breedName+'</p></td>';
            resultHtml += '<td>'+parseFloat(Number(data[i].unitQty).toFixed(2))+data[i].unit+'</td>';
            resultHtml += '<td>'+data[i].grade+'</td>';
            resultHtml += '<td>'+comma(data[i].lowPrice)+'</td>';
            resultHtml += '<td>'+comma(data[i].maxPrice)+'</td>';
            resultHtml += '<td>'+comma(data[i].avgPrice)+'</td>';
            resultHtml += '</tr>';
        }
    }else{
        resultHtml += '<tr>';
        resultHtml += '<td colspan="7">등록된 시세 정보가 없습니다.</td>';
        resultHtml += '</tr>';
    }
    $("#mainPrice").append(resultHtml);
}

function fn_getMainNotice(){
	$.ajax({
		type : "POST",
		url : "/main/getMainNotice",
		dataType : "json",
		success : function(data){
			fn_getMainNoticeCall(data.mainNotice);
		}
	});
}

function fn_getMainNoticeCall(data){
	let noticeHtml = "";
	
	if(data.length > 0){
		for(let i=0; i<data.length; i++){
			noticeHtml += '<tr>';
			noticeHtml += '<td><a href="notice/noticeView?notiSeq='+data[i].notiSeq+'">'+data[i].subject+'</a></td>';
			noticeHtml += '<td><a href="notice/noticeView?notiSeq='+data[i].notiSeq+'">'+data[i].regDttm+'</a></td>';
			noticeHtml += '</tr>';
		}
	}else{
		noticeHtml += '<tr>';
        noticeHtml += '<td colspan="2">등록된 공지사항이 없습니다.</td>';
        noticeHtml += '</tr>';
	}
	$("#mainNotice").append(noticeHtml);
}

function fn_getMainPds(){
	$.ajax({
		type : "POST",
		url : "/main/getMainPds",
		dataType : "json",
		success : function(data){
			fn_getMainPdsCall(data.mainPds);
		}
	});
}

function fn_getMainPdsCall(data){
	let pdsHtml = "";
	
	if(data.length > 0){
		for(let i=0; i<data.length; i++){
			pdsHtml += '<tr>';
			pdsHtml += '<td><a href="pds/pdsView?pdsSeq='+data[i].pdsSeq+'">'+data[i].subject+'</a></td>';
			pdsHtml += '<td><a href="pds/pdsView?pdsSeq='+data[i].pdsSeq+'">'+data[i].regDttm+'</a></td>';
			pdsHtml += '</tr>';
		}
	}else{
		pdsHtml += '<tr>';
        pdsHtml += '<td colspan="2">등록된 공지사항이 없습니다.</td>';
        pdsHtml += '</tr>';
	}
	$("#mainPds").append(pdsHtml);
}



