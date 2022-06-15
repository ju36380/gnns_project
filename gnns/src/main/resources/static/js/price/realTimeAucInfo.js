window.onload = function() {
	fn_getFruitList();
	fn_getVegeList();
};


function fn_getFruitList(){
	
	$.ajax({
		type: "POST",
		url  : "/price/getFruitList",
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData) {
			fn_createList(resultData.priceFruitList);
		}
	});	
}


function fn_createList(data){ // 2021-11-26 준혁(추가 수정)
	let fruitHtmlA="";
	let fruitHtmlB="";
	let fruitHtmlC="";
	let fruitHtmlD="";
	let fruitHtml="";
	let gubnA = 1;
	let gubnB = 1;
	let gubnC = 1;
	
	if(data.length>0){
		fruitHtmlA += "<tr>";
		fruitHtmlA += "<td width='41' rowspan='2' align='center' bgcolor='E8C192'><strong><font color='#993300'>낙찰</font></strong></td>";
		fruitHtmlA += "<td width='111' height='30' align='center' bgcolor='F1E2BA'><font color='#000000'>생산자</font></td>";
		fruitHtmlA += "<td width='102' align='center' bgcolor='F1E2BA'><font color='#000000'>품종</font></td>";
		fruitHtmlA += "<td width='71' align='center' bgcolor='F1E2BA'><font color='#000000'>중량(kg)</font></td>";
		fruitHtmlA += "<td width='47' align='center' bgcolor='F1E2BA'><font color='#000000'>등급</font></td>";
		fruitHtmlA += "<td width='69' align='center' bgcolor='F1E2BA'><font color='#000000'>수량(개)</font></td>";
		fruitHtmlA += "<td width='72' align='center' bgcolor='F1E2BA'><font color='#000000'>낙찰가(원)</font></td>";
		fruitHtmlA += "<td width='68' align='center' bgcolor='F1E2BA'><font color='#000000'>비고</font></td>";
		fruitHtmlA += "</tr>";
		
		fruitHtmlB += "<tr>";
		fruitHtmlB += "<td width='41' rowspan='2' align='center' bgcolor='DF90C4'><strong><font color='#990066'>진행</font></strong></td>";
		fruitHtmlB += "<td width='173' height='30' align='center' bgcolor='EACEDD'><font color='#000000'>출하주</font></td>";
		fruitHtmlB += "<td width='83' align='center' bgcolor='EACEDD'><font color='#000000'>생산자</font></td>";
		fruitHtmlB += "<td width='115' align='center' bgcolor='EACEDD'><font color='#000000'>품종</font></td>";
		fruitHtmlB += "<td width='63' align='center' bgcolor='EACEDD'><font color='#000000'>중량(kg)</font></td>";
		fruitHtmlB += "<td width='47' align='center' bgcolor='EACEDD'><font color='#000000'>등급</font></td>";
		fruitHtmlB += "<td width='60' align='center' bgcolor='EACEDD'><font color='#000000'>수량(개)</font></td>";
		fruitHtmlB += "</tr>";
	
		fruitHtmlC += "<tr>";
		fruitHtmlC += "<td width='41' rowspan='2' align='center' bgcolor='B2CBAA'><strong><font color='#006666'>대기</font></strong></td>";
		fruitHtmlC += "<td width='173' height='30' align='center' bgcolor='D9E3CC'><font color='#000000'>출하주</font></td>";
		fruitHtmlC += "<td width='83' align='center' bgcolor='D9E3CC'><font color='#000000'>생산자</font></td>";
		fruitHtmlC += "<td width='114' align='center' bgcolor='D9E3CC'><font color='#000000'>품종</font></td>";
		fruitHtmlC += "<td width='64' align='center' bgcolor='D9E3CC'><font color='#000000'>중량(kg)</font></td>";
		fruitHtmlC += "<td width='48' align='center' bgcolor='D9E3CC'><font color='#000000'>등급</font></td>";
		fruitHtmlC += "<td width='59' align='center' bgcolor='D9E3CC'><font color='#000000'>수량(개)</font></td>";
		fruitHtmlC += "</tr>";
	
		fruitHtmlD += "<tr>";
		fruitHtmlD += "<td width='41' rowspan='4' align='center' bgcolor='#B0D6E1'><strong><font color='#003366'>생산자</font></strong></td>";
		fruitHtmlD += "<td width='242' height='30' align='center' bgcolor='#DEEBEB'><font color='#000000'>출하주</font></td>";
		fruitHtmlD += "<td width='112' align='center' bgcolor='#DEEBEB'><font color='#000000'>생산자</font></td>";
		fruitHtmlD += "<td width='116' align='center' bgcolor='#DEEBEB'><font color='#000000'>품종</font></td>";
		fruitHtmlD += "<td width='73' align='center' bgcolor='#DEEBEB'><font color='#000000'>수량(개)</font></td>";
		fruitHtmlD += "</tr>";
		
		for(let i=0; i<data.length; i++){
			var ing = 'N';
			if(data[i].gubn == 'A' && gubnA == 1){
				fruitHtmlA += "<tr>";
				fruitHtmlA += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].danQty+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].grade+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].cost.toLocaleString()+"</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "</tr>";
				gubnA++;
			}else if(gubnA == 1){
				fruitHtmlA += "<tr>";
				fruitHtmlA += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'>0</td>";
				fruitHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlA += "</tr>";
				gubnA++;
			}
			if(data[i].gubn == 'B' && gubnB == 1){
				fruitHtmlB += "<tr>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].chulName+"</font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].farm+"</font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].good+"</font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].danQty+"</font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].grade+"</font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].qty+"</font></strong></td>";
				fruitHtmlB += "</tr>";
				gubnB++;
				ing = 'Y';
			}else if(data[i].gubn != 'B' && gubnB == 1 && data[i].gubn != 'A'){
				fruitHtmlB += "<tr>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "</tr>";
				gubnB++;
			}
			if(data[i].gubn == 'B' && gubnB == 2 && ing == 'N'){
				fruitHtmlC += "<tr>";
				fruitHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].chulName+"</td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].danQty+"</td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].grade+"</td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				fruitHtmlC += "</tr>";
				gubnB++;
			}else if(data[i].gubn != 'B' && gubnB == 2){
				fruitHtmlC += "<tr>";
				fruitHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "</tr>";
				gubnB++;
			}
			if(data[i].gubn == 'C' && gubnC < 4){
				fruitHtmlD += "<tr>";
				fruitHtmlD += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].chulName+"</td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				fruitHtmlD += "</tr>";
				gubnC++;
			}			
		}// for문 끝

		for(let c=0; c<3; c++){ // 데이터 없을 시 공백 만들어주는 for 문
			if(gubnB < 2){
				fruitHtmlB += "<tr>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				fruitHtmlB += "</tr>";
				gubnB++;				
			}
			if(gubnB == 2){
				fruitHtmlC += "<tr>";
				fruitHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlC += "</tr>";
				gubnB++;
			}
			if(gubnC < 4){
				fruitHtmlD += "<tr>";
				fruitHtmlD += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				fruitHtmlD += "</tr>";
				gubnC++;
			}
		}
		
		$("#fru_sold").append(fruitHtmlA);
		$("#fru_pro").append(fruitHtmlB);
		$("#fru_wait").append(fruitHtmlC);
		$("#fru_wor").append(fruitHtmlD);
	}else{
		fruitHtml += "<tr>";
		fruitHtml += "<td class='tc' colspan='8'><p class='txt_01'>현재 과일부 전자경매가 실시되지 않고 있습니다.</p></td>";
		fruitHtml += "</tr>";
		
		$("#fru_table").append(fruitHtml);
	}
}


function fn_getVegeList(){
	
	$.ajax({
		type: "POST",
		url  : "/price/getVegeList",
		dataType: "json", // text, html , json
        error: function (xhr, ajaxOptions, thrownError) {
        },
		success: function(resultData, textStatus) {
			fn_createVegeList(resultData.priceVegeList);
		}
	});	
}

function fn_createVegeList(data){ // 2021-11-26 준혁(추가 수정)
	let vegeHtmlA="";
	let vegeHtmlB="";
	let vegeHtmlC="";
	let vegeHtmlD="";
	let vegeHtml="";
	let gubnA = 1;
	let gubnB = 1;
	let gubnC = 1;
	
	if(data.length>0){
		
		vegeHtmlA += "<tr>";
		vegeHtmlA += "<td width='41' rowspan='2' align='center' bgcolor='E8C192'><strong><font color='#993300'>낙찰</font></strong></td>";
		vegeHtmlA += "<td width='111' height='30' align='center' bgcolor='F1E2BA'><font color='#000000'>생산자</font></td>";
		vegeHtmlA += "<td width='102' align='center' bgcolor='F1E2BA'><font color='#000000'>품종</font></td>";
		vegeHtmlA += "<td width='71' align='center' bgcolor='F1E2BA'><font color='#000000'>중량(kg)</font></td>";
		vegeHtmlA += "<td width='47' align='center' bgcolor='F1E2BA'><font color='#000000'>등급</font></td>";
		vegeHtmlA += "<td width='69' align='center' bgcolor='F1E2BA'><font color='#000000'>수량(개)</font></td>";
		vegeHtmlA += "<td width='72' align='center' bgcolor='F1E2BA'><font color='#000000'>낙찰가(원)</font></td>";
		vegeHtmlA += "<td width='68' align='center' bgcolor='F1E2BA'><font color='#000000'>비고</font></td>";
		vegeHtmlA += "</tr>";

		vegeHtmlB += "<tr>";
		vegeHtmlB += "<td width='41' rowspan='2' align='center' bgcolor='DF90C4'><strong><font color='#990066'>진행</font></strong></td>";
		vegeHtmlB += "<td width='173' height='30' align='center' bgcolor='EACEDD'><font color='#000000'>출하주</font></td>";
		vegeHtmlB += "<td width='83' align='center' bgcolor='EACEDD'><font color='#000000'>생산자</font></td>";
		vegeHtmlB += "<td width='115' align='center' bgcolor='EACEDD'><font color='#000000'>품종</font></td>";
		vegeHtmlB += "<td width='63' align='center' bgcolor='EACEDD'><font color='#000000'>중량(kg)</font></td>";
		vegeHtmlB += "<td width='47' align='center' bgcolor='EACEDD'><font color='#000000'>등급</font></td>";
		vegeHtmlB += "<td width='60' align='center' bgcolor='EACEDD'><font color='#000000'>수량(개)</font></td>";
		vegeHtmlB += "</tr>";

		vegeHtmlC += "<tr>";
		vegeHtmlC += "<td width='41' rowspan='2' align='center' bgcolor='B2CBAA'><strong><font color='#006666'>대기</font></strong></td>";
		vegeHtmlC += "<td width='173' height='30' align='center' bgcolor='D9E3CC'><font color='#000000'>출하주</font></td>";
		vegeHtmlC += "<td width='83' align='center' bgcolor='D9E3CC'><font color='#000000'>생산자</font></td>";
		vegeHtmlC += "<td width='114' align='center' bgcolor='D9E3CC'><font color='#000000'>품종</font></td>";
		vegeHtmlC += "<td width='64' align='center' bgcolor='D9E3CC'><font color='#000000'>중량(kg)</font></td>";
		vegeHtmlC += "<td width='48' align='center' bgcolor='D9E3CC'><font color='#000000'>등급</font></td>";
		vegeHtmlC += "<td width='59' align='center' bgcolor='D9E3CC'><font color='#000000'>수량(개)</font></td>";
		vegeHtmlC += "</tr>";

		vegeHtmlD += "<tr>";
		vegeHtmlD += "<td width='41' rowspan='4' align='center' bgcolor='#B0D6E1'><strong><font color='#003366'>생산자</font></strong></td>";
		vegeHtmlD += "<td width='242' height='30' align='center' bgcolor='#DEEBEB'><font color='#000000'>출하주</font></td>";
		vegeHtmlD += "<td width='112' align='center' bgcolor='#DEEBEB'><font color='#000000'>생산자</font></td>";
		vegeHtmlD += "<td width='116' align='center' bgcolor='#DEEBEB'><font color='#000000'>품종</font></td>";
		vegeHtmlD += "<td width='73' align='center' bgcolor='#DEEBEB'><font color='#000000'>수량(개)</font></td>";
		vegeHtmlD += "</tr>";
		
		
		for(let i=0; i<data.length; i++){
			var ing = 'N';
			if(data[i].gubn == 'A' && gubnA == 1){
				vegeHtmlA += "<tr>";
				vegeHtmlA += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].danQty+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].grade+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>"+data[i].cost.toLocaleString()+"</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "</tr>";
				gubnA++;
			}else if(gubnA == 1){
				vegeHtmlA += "<tr>";
				vegeHtmlA += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'>0</td>";
				vegeHtmlA += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlA += "</tr>";
				gubnA++;
			}
			if(data[i].gubn == 'B' && gubnB == 1){
				vegeHtmlB += "<tr>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].chulName+"</font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].farm+"</font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].good+"</font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].danQty+"</font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].grade+"</font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'>"+data[i].qty+"</font></strong></td>";
				vegeHtmlB += "</tr>";
				gubnB++;
				ing = 'Y';
			}else if(data[i].gubn != 'B' && gubnB == 1 && data[i].gubn != 'A'){
				vegeHtmlB += "<tr>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "</tr>";
				gubnB++;
			}
			if(data[i].gubn == 'B' && gubnB == 2 && ing == 'N'){
				vegeHtmlC += "<tr>";
				vegeHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].chulName+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].danQty+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].grade+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				vegeHtmlC += "</tr>";
				gubnB++;
			}else if(data[i].gubn != 'B' && gubnB == 2){
				vegeHtmlC += "<tr>";
				vegeHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "</tr>";
				gubnB++;
			}
			if(data[i].gubn == 'C' && gubnC < 4){
				vegeHtmlD += "<tr>";
				vegeHtmlD += "<td height='25' align='center' bgcolor='#FFFFFF'>"+data[i].chulName+"</td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				vegeHtmlD += "</tr>";
				gubnC++;
			}else if(data[i].gubn=='C'){
				vegeHtmlC += "<tr>";
				vegeHtmlC += "<td height='25' align='center' bgcolor='FFFFFF'>"+data[i].chulName+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].farm+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].good+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].danQty+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].grade+"</td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'>"+data[i].qty+"</td>";
				vegeHtmlC += "</tr>";
			}
		} // for 문
		
		for(let v=0; v<3; v++){ // 데이터 없을 시 공백 만들어주는 for 문
			if(gubnB < 2){
				vegeHtmlB += "<tr>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "<td height='30' align='center' bgcolor='#FFFFFF'><strong><font color='#000000'></font></strong></td>";
				vegeHtmlB += "</tr>";
				gubnB++;				
			}
			if(gubnB == 2){
				vegeHtmlC += "<tr>";
				vegeHtmlC += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlC += "</tr>";
				gubnB++;
			}
			if(gubnC < 4){
				vegeHtmlD += "<tr>";
				vegeHtmlD += "<td height='25' align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlD += "<td align='center' bgcolor='#FFFFFF'></td>";
				vegeHtmlD += "</tr>";
				gubnC++;
			}
		}
		
		$("#vage_sold").append(vegeHtmlA);
		$("#vage_pro").append(vegeHtmlB);
		$("#vege_wait").append(vegeHtmlC);
		$("#vege_wor").append(vegeHtmlD);
		
	}else{
		vegeHtml += "<tr>";
		vegeHtml += "<td class='tc' colspan='8'><p class='txt_01'>현재 채소부 전자경매가 실시되지 않고 있습니다.</p></td>";
		vegeHtml += "</tr>";
		
		$("#vege_table").append(vegeHtml);
	}
}

setTimeout ('location.reload();',10 * 1000); // 2021-11-25 준혁(추가) 몇 초후 페이지 리로드