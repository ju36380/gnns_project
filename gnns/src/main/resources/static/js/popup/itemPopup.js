$(document).ready(function() {
	//화면 로딩시 초기 설정
	onLoadSet();
});

function onLoadSet(){
    $('#stuffOutPop .p_close').click(function(){
        $('#stuffOutPop').css('display', 'none');
        $('body').css('overflow', 'auto');
    });
	
};

window.onload = function() {
	//$("#searchInp").val($("#paramVal").val());
};

function openItemPop(){
    $('#stuffOutPop').css('display', 'block');
    $('body').css('overflow', 'hidden');
}

function closeItemPop(){
    $('#stuffOutPop').css('display', 'none');
    $('body').css('overflow', 'auto');
}

function fn_popupCallback(pcode, pname){
    $('#stuffOut').val(pname);
    $('#itemCode').val(pcode);
    closeItemPop();
};
