<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html lang="en">
<head>
<meta charset="euc-kr">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="content-type" content="text/html; charset=euc-kr"/>
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>게시판</title>

<!-- CSS(S) -->
<link rel="stylesheet" type="text/css" href="/static/css/reset.css">
<link rel="stylesheet" type="text/css" href="/static/css/font.css">
<link rel="stylesheet" type="text/css" href="/static/css/common.css">
<link rel="stylesheet" type="text/css" href="/static/css/main.css">
<link rel="stylesheet" type="text/css" href="/static/css/swiper.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/sub.css">
<link rel="stylesheet" type="text/css" href="/static/css/jquery-ui.css">
<!-- CSS(E) -->

<!-- SCRIPT(S) -->
<script type="text/javascript" src="/static/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/static/js/swiper.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-ui.js"></script>
<script type="text/javascript" src="/static/js/script.js"></script>
<!-- SCRIPT(E) -->

</head>

<body> 
	<!-- warp(S) -->
	<div class="wrap">
		<div class="w_in">
		<!-- header(S) -->
		<div class="header">
			<div class="h_in">
				<div class="hi_top">
					<a href="#!" class="main_logo"><img src="/static/img/h_logo.png" alt="헤더로고"></a>
					<div class="h_search_box">
						<div class="signin">
							<a href="#!">로그인</a>
							<a href="#!">회원가입</a>
						</div>
					</div>
					<a href="#!" class="btn_mobile_menu btn_lnb"><img src="/static/img/menu_icon.png" alt="모바일메뉴버튼"></a>
				</div>
				<div class="hi_bottom">
					<ul class="nav">
						<div class="nav_bg"></div>  
						<li class="navi_set">  
							<div class="topnav"><a href="#!">회사소개</a></div>
							<ul class="subnav">  
								<li><a href="#!">인사말</a></li>  
								<li><a href="#!">회사개요</a></li> 
								<li><a href="#!">연혁</a></li>  
								<li><a href="#!">사업실적</a></li>  
								<li><a href="#!">CI소개</a></li>  
								<li><a href="#!">조직도</a></li>  
								<li><a href="#!">약도</a></li>  
								<li><a href="#!">경영공시</a></li>  
							</ul>  
						</li>  

						<li class="navi_set">  
							<div class="topnav"><a href="#!">유통종사자</a></div>
							<ul class="subnav">  
								<li><a href="#!">경매사</a></li>  
								<li><a href="#!">중도매인</a></li> 
								<li><a href="#!">매매참가인</a></li>  
							</ul>  
						</li> 
						
						<li class="navi_set">  
							<div class="topnav"><a href="#!">실시간 시세정보</a></div>
							<ul class="subnav">  
								<li><a href="#!">실시간 경매정보</a></li>  
								<li><a href="#!">시세정보 조회</a></li> 
								<li><a href="#!">유통정보</a></li> 
							</ul>  
						</li> 

						<li class="navi_set">  
							<div class="topnav"><a href="#!">출하주 정산정보</a></div>
							<ul class="subnav">  
								<li><a href="#!">판매내역</a></li>  
								<li><a href="#!">미지급내역</a></li> 
								<li><a href="#!">실적집계</a></li>  
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">중도매인 거래정보</a></div>
							<ul class="subnav">  
								<li><a href="#!">일자별 낙찰명세서</a></li>  
								<li><a href="#!">기간별 거래원장</a></li> 
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">농산물 안전성 검사</a></div>
							<ul class="subnav">  
								<li><a href="#!">안정성 검사란?</a></li>  
								<li><a href="#!">검사체계</a></li> 
								<li><a href="#!">감사결과</a></li>  
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">고객마당</a></div>
							<ul class="subnav">  
								<li><a href="#!">공지사항</a></li>  
								<li><a href="#!">게시판</a></li> 
								<li><a href="#!">자료실</a></li>  
							</ul>  
						</li>
						<li><a href="#!" class="btn_global"><img src="/static/img/menu_icon.png" alt="글로벌메뉴"></a></li>
					</ul>
					
				</div>
				
			</div>
		</div>
		<!-- header(E) -->

			<!-- sub-contents(S) -->
			<div class="sub_contents common">
			<!-- sub상단(S) -->
			<div class="sub_top">
				<h2 class="sub_title">공지사항</h2>

				<!-- 네비게이션(S) -->
				<div class="nav_box">
					<div class="nav_in">
						<a href="#!" class="btn_home"><img src="/static/img/btn_home.png" alt="네비게이션홈버튼"></a>
						<ul class="nav_depth_box">
							<li class="btn_nav_depth_01">
								<a href="#!">depth-01<span class="nav_arrow"><img src="/static/img/nav_arrow.png" alt="네비화살표"></span></a>
								<ul class="nav_depth_box_02">
									<li class="btn_nav_depth_02"><a href="#!">depth_01-01</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_01-02</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_01-03</a></li>
								</ul>
							</li>
							<li class="btn_nav_depth_01">
								<a href="#!">depth-02<span class="nav_arrow"><img src="/static/img/nav_arrow.png" alt="네비화살표"></span></a>
								<ul class="nav_depth_box_02">
									<li class="btn_nav_depth_02"><a href="#!">depth_02-01</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_02-02</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_02-03</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_02-04</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_02-05</a></li>
								</ul>
							</li>
							<li class="btn_nav_depth_01">
								<a href="#!">depth-03<span class="nav_arrow"><img src="/static/img/nav_arrow.png" alt="네비화살표"></span></a>
								<ul class="nav_depth_box_02">
									<li class="btn_nav_depth_02"><a href="#!">depth_03-01</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_03-02</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_03-03</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_03-04</a></li>
									<li class="btn_nav_depth_02"><a href="#!">depth_03-05</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<!-- 네비게이션(E) -->
			</div>
			<!-- sub상단(E) -->
				<div class="sub_in">
					
					<!-- 검색조건창(S) -->
					<div class="search_box">
						<select id="searchSel">
							<option>제목</option>
							<option>내용</option>
						</select>
						<label for="searchSel"></label>
						<input type="text" id="searchInp" placeholder="검색어를 입력하세요"><label for="searchInp"></label>
						<a href="#!" class="btn_search">검색</a>
					</div>
					<!-- 검색조건창(E) -->

					<!-- 테이블(S) -->
					<div class="table_type_01 mt50">
					<table>
						<caption>자료갱신 일시</caption>
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
							<col width="12%">
							<col width="12%">
							<col width="12%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">파일</th>
								<th scope="col">조회수</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody> 
						<c:forEach var="item" items="${noticeList}" varStatus="status">
							<tr>
								<td class="tc"><p class="txt_01"><c:out value="${item.notiSeq}"/></p></td>
								<td class="tl"><a href="/notice/noticeView?notiSeq=${item.notiSeq}" class="txt_01"><c:out value="${item.subject}"/></a></td>
								<td class="tc"><a href="#!" class="ico_down doc"></a></td>
								<td class="tc"><p class="txt_01"><c:out value="${item.readCnt}"></c:out></p></td>
								<td class="tc"><p class="txt_01"><c:out value="${item.regNm}"></c:out></p></td>
								<td class="tc"><p class="txt_01"><c:out value="${item.regDttm}"></c:out></p></td>
								<input type="hidden" value="${item.notiSeq}"/>
							</tr>
						</c:forEach>	
							<tr>
								<td class="tc"><p class="txt_01">30<p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down doc"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down pdf"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down hwp"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down xls"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down ppt"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down gif"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down png"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">강릉농산물도매시장 홈페이지를 새롭게 오픈하였습니다.</a></td>
								<td class="tc"><a href="#!" class="ico_down jpg"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01">매주 월~토요일 (주6일)</a></td>
								<td class="tc"><a href="#!" class="ico_down etc"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
							<tr>
								<td class="tc"><p class="txt_01">30</p></td>
								<td class="tl"><a href="#!" class="txt_01 reple">강릉농산물도매시장 홈페이지를 새롭게 오픈하였습니다.</a></td>
								<td class="tc"><a href="#!" class="ico_down etc"></a></td>
								<td class="tc"><p class="txt_01">187</p></td>
								<td class="tc"><p class="txt_01">관리자</p></td>
								<td class="tc"><p class="txt_01">2021.06.25</p></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 테이블(E) -->

				<!-- 버튼(S) -->
				<div class="btn_box">
					<div class="fr">
						<a href="#!" class="btn_type_01 gray write">글쓰기</a>
					</div>
				</div>
				<!-- 버튼(E) -->

				<!-- 페이지박스(S) -->
				<div class="paging_box">
					<a href="#!" class="btn_page_prev">이전</a>
					<a href="#!" class="btn_page on">1</a>
					<a href="#!" class="btn_page">2</a>
					<a href="#!" class="btn_page">3</a>
					<a href="#!" class="btn_page">4</a>
					<a href="#!" class="btn_page">5</a>
					<a href="#!" class="btn_page_next">다음</a>
				</div>
				<!-- 페이지박스(E) -->				

				</div>
			</div>
			<!-- sub-contents(E) -->

		<!-- footer(S) -->
		<div class="footer"> 
			<div class="f_in">
				<a href="#!" class="f_logo"><img src="/static/img/f_logo.png"></a>
				<ul class="address">
					<li><span>주소</span> 강원도 강릉시 유산로 60</li>
					<li><span>대표전화</span> 033-644-4654</li>
					<li><span>팩스</span> 033-646-4860</li>
				</ul>
				<span class="copy">copyrightⓒ(주)강릉농산물도매시장 all right reserverd.</span>
			</div>

		</div>
		<!-- footer(E) -->

		
		<!-- 모바일메뉴(S) -->
		<div id="lnb" class="mobile_menu">
			<!-- <div class="dim"></div> -->

			<div class="mm_top">
				<div class="m_log">
					<a href="#!">로그인</a>
					<a href="#!">회원가입</a>
				</div>
				<a href="#!" class="m_btn_close"><img src="/static/img/m_lnb_close.png" alt="모바일lnb닫기버튼"></a>
			</div>
			
			<ul class="lnb_box">
			  <li><a href="#none">회사소개</a>
				<ul>
				  <li><a href="#none">· 인사말</a></li>
				  <li><a href="#none">· 회사개요</a></li>
				  <li><a href="#none">· 연혁</a></li>
				  <li><a href="#none">· 사업실적</a></li>
				  <li><a href="#none">· CI소개</a></li>
				  <li><a href="#none">· 조직도</a></li>
				  <li><a href="#none">· 약도</a></li>
				  <li><a href="#none">· 경영공시</a></li>
				</ul>
			  </li>
			  
			  <li><a href="#none">유통종사자</a>
				<ul>
				  <li><a href="#none">· 경매사</a></li>
				  <li><a href="#none">· 중도매인</a></li>
				  <li><a href="#none">· 매매참가인</a></li>
				</ul>
			  </li>
			  <li><a href="#none">실시간 시세정보</a>
				<ul>
				  <li><a href="#none">· 실시간 경매정보</a></li>
				  <li><a href="#none">· 시세정보 조회</a></li>
				  <li><a href="#none">· 유통정보</a></li>
				</ul>
			  </li>
			  <li><a href="#none">출하주 정산정보</a>
				<ul>
				  <li><a href="#none">· 판매내역</a></li>
				  <li><a href="#none">· 미지급내역</a></li>
				  <li><a href="#none">· 실적집계</a></li>
				</ul>
			  </li>
			  <li><a href="#none">중도매인 거래정보</a>
				<ul>
				  <li><a href="#none">· 일자별 낙찰명세서</a></li>
				  <li><a href="#none">· 기간별 거래원장</a></li>
				</ul>
			  </li>
			  <li><a href="#none">농산물 안전성 검사</a>
				<ul>
				  <li><a href="#none">· 안성성 검사란?</a></li>
				  <li><a href="#none">· 검사체계</a></li>
				  <li><a href="#none">· 감사결과</a></li>
				</ul>
			  </li>
			  <li><a href="#none">고객마당</a>
				<ul>
				  <li><a href="#none">· 공지사항</a></li>
				  <li><a href="#none">· 게시판</a></li>
				  <li><a href="#none">· 자료실</a></li>
				</ul>
			  </li>
			</ul>
		  </div>
		  <!-- 모바일메뉴(E) -->
		</div>
	</div>
	<!-- wrap(E) -->		


</body>
</html>


