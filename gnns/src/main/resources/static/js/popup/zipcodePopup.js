$(document).ready(function() {
    //화면 로딩시 초기 설정
    onLoadSet();
});

function onLoadSet(){
    $('#jusoPop .p_close').click(function(){
        $('#jusoPop').css('display', 'none');
        $('body').css('overflow', 'auto');
    });
    
};

window.onload = function() {
    //$("#searchInp").val($("#paramVal").val());
};

function openJusoPop(){
    $('#jusoPop').css('display', 'block');
    $('body').css('overflow', 'hidden');
}

function closeJusoPop(){
    $('#jusoPop').css('display', 'none');
    $('body').css('overflow', 'auto');
}


function fn_getJuso(searchType){
    
    if(searchType=="enter"){
        if(window.event.keyCode != 13){
            return;
        }
        
        $("#currentPage").val(1);
        
        gPage=1;
    }
    
    let searchKey = document.form.keyword;
    
    if(searchKey===''){
        alert('검색할 동을 입력하세요');
        return;
    }
    
    // 적용예 (api 호출 전에 검색어 체크)   
    if (!checkSearchedWord(document.form.keyword)) {
        return ;
    }
    
    fn_getAddr($("#currentPage").val());
};

function fn_getAddr(page){
    $("#currentPage").val(page);
    gPage=page;

    let resultHtml="";    
    
    $.ajax({
         url :"https://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"  //인터넷망
        ,type:"post"
        ,data:$("#form").serialize()
        ,dataType:"jsonp"
        ,crossDomain:true
        ,success:function(jsonStr){
            var errCode = jsonStr.results.common.errorCode;
            var errDesc = jsonStr.results.common.errorMessage;
            if(errCode != "0"){
                alert(errCode+"="+errDesc);
            }else{
                if(jsonStr != null){
                    $("#divPaging").empty();
                    $("#jusoPopResult").empty();
                    if(jsonStr.results.juso.length>0){
                        resultHtml += '<ul class="p_s_r_list">';
                        jsonStr.results.juso.forEach (function (el, index) {
                            resultHtml += '<li><a href="#!" onclick="fn_jusoCallback(\''+el.zipNo+'\' ,\''+el.roadAddr +'\')"><span class="add_num">'+el.zipNo+'</span><span class="name">'+ el.roadAddr + '</span></a></li>';              
                        });
                        resultHtml += '</ul>';
                    }else{
                        resultHtml += '<p class="p_s_no_result">검색된 주소가 없습니다.</p>';
                    }
                    
                    fn_createPaging(jsonStr.results.common.totalCount, jsonStr.results.common.currentPage);
                    
                    $("#jusoPopResult").append(resultHtml);
                }
            }
        }
        ,error: function(xhr,status, error){
            alert("에러발생");
        }
    });
};

function fn_jusoCallback(zipCode, addr){
    $('#zipCode').val(zipCode);
    $('#address').val(addr);
    closeJusoPop();
};

function fn_createPaging(arg1, arg2){
    let pagingDivId = "currentPage";
    let fncNm = "fn_getAddr";
    gfn_createPaging(arg1, arg2, pagingDivId, fncNm);
};

/*
모의 해킹 테스트 시 검색API를 호출하시면 IP가 차단 될 수 있습니다. 
주소검색API를 제외하시고 테스트 하시기 바랍니다.
*/
/*도로명주소 API 호출시 검색어에 특수문자 또는 OR, INSERT, UNION 등 SQL예약어가 포함될 경우
보안장비가 SQL INJECTION공격으로 간주하여 해당 IP를 차단시킬 수 있습니다.
사용자분들은 API호출시 검색어 필터링를 적용하여 주시기 바랍니다.*/

//특수문자, 특정문자열(sql예약어의 앞뒤공백포함) 제거
//특수문자, 특정문자열(sql예약어의 앞뒤공백포함) 제거
function checkSearchedWord(obj){
    if(obj.value.length >0){
        //특수문자 제거
        var expText = /[%=><]/ ;
        if(expText.test(obj.value) == true){
            alert("특수문자를 입력 할수 없습니다.") ;
            obj.value = obj.value.split(expText).join(""); 
            return false;
        }
        
        //특정문자열(sql예약어의 앞뒤공백포함) 제거
        var sqlArray = new Array(
            //sql 예약어
            "OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC",
                     "UNION",  "FETCH", "DECLARE", "TRUNCATE" 
        );
        
        var regex;
        for(var i=0; i<sqlArray.length; i++){
            regex = new RegExp( sqlArray[i] ,"gi") ;
            
            if (regex.test(obj.value) ) {
                alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
                obj.value =obj.value.replace(regex, "");
                return false;
            }
        }
    }
    return true ;
}
