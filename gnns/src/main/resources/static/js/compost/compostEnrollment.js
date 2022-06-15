let prevSaleSeq = "";
let nextSaleSeq = "";
let firstSaleSeq = "";
let gSaleSeq ="";
$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();
});

function onLoadSet(){
};

window.onload = function() {
	
};

															
function fn_breedNmSearch(searchType){
	if(window.event.keyCode == 13){
	 	fn_getItem(searchType);
	}
}

function fn_getItem(searchType){
    let pumName = "";
    if(searchType==='popup'){
        pumName =$("#stuffOut").val();
    }else{
        pumName =$("#searchInput").val();
    }
    
    if(pumName===''){
        alert('검색할 품목을 입력하세요');
        return;
    }
	
	
	let resultHtml="";
	$.ajax({
		type: "POST",
		url  : "/popup/getItemList",
		data :  {pumName : pumName, searchType:'popup'},
		dataType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
		    $("#stuffOutPopResult").empty();
			if(resultData.itemList.length>0){
			    resultHtml += '<ul class="p_s_r_list">';
			    resultData.itemList.forEach (function (el, index) {
			        resultHtml += '<li><a href="#!" onclick="fn_popupCallback(\''+el.pumCode+'\' ,\''+el.pumName+'\')"><span class="name">'+el.pumName+'</span></a></li>';		        });
			    resultHtml += '</ul>';
			}else{
			    resultHtml += '<p class="p_s_no_result">검색된 품목이 없습니다.</p>';
			}
			
			$("#stuffOutPopResult").append(resultHtml);
			
			if(searchType==='popup'){
			    $("#searchInput").val(pumName);
			    openItemPop();
		    }
		}
	});
};


function fn_searchZipCodeOpen(){
    openJusoPop();
}

function fn_compostRegist(){
    let frm = document.frm;
    if(!fn_vaildaitonCheck()) return false;
    frm.submit(); 
}

function fn_vaildaitonCheck(){
    let name = $('input[name=name]');
    if(fn_isNull(name.val(), "이름")==false){
        name.focus();
        return false;
    }
    let phoneNum = $('input[name=phoneNum]');
    if(fn_isNull(phoneNum.val(), "전화번호")==false){
        phoneNum.focus();
        return false;
    }
    let mobilePhone = $('input[name=mobilePhone]');
    if(fn_isNull(mobilePhone.val(), "휴대폰번호")==false){
        mobilePhone.focus();
        return false;
    }
    
    let zipCode = $('input[name=zipCode]');
    if(fn_isNull(zipCode.val(), "주소")==false){
        zipCode.focus();
        return false;
    }
    
    let year = $('#year');
    if(fn_isNull(year.val(), "사용일시(년)")==false){
        year.focus();
        return false;
    }
    
    let month = $('#month');
    if(fn_isNull(month.val(), "사용일시(월)")==false){
        month.focus();
        return false;
    }
    
    let tenDays = $('#tenDays');
    if(fn_isNull(tenDays.val(), "사용일시(순)")==false){
        tenDays.focus();
        return false;
    }
    
    
    
    let breedCode = $('input[name=breedCode]');
    if(fn_isNull(breedCode.val(), "출하품목")==false){
        breedCode.focus();
        return false;
    }
    
    let shipmentIssue = $('#shipmentIssue');
    if(fn_isNull(shipmentIssue.val(), "필요량")==false){
        shipmentIssue.focus();
        return false;
    }
    
    let reservationDate = year.val()+(month.val()<10?"0"+month.val():month.val())+tenDays.val();
    
    $('#reservationDate').val(reservationDate);
    
    
    return true;
}

