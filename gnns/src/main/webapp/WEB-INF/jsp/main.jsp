<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<html lang="en">
<head>
<meta charset="euc-kr">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="content-type" content="text/html; charset=euc-kr"/>
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>main</title>

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
			<!-- main-contents(S) -->
			<div class="main_contents">
				<div class="mc_in">
					

					<!-- MAIN CONTENT-01(S) -->
					<div class="mc_in_cont_01">

						<!-- main-slide(S) -->
						<div class="main_slide">
							<!-- Swiper -->
							<div class="swiper-container">
								<div class="swiper-wrapper">
								<div class="swiper-slide web"><a href="#!"><img src="/static/img/images/slide-img-01.jpg"></a></div>
								<div class="swiper-slide web"><a href="#!"><img src="/static/img/images/slide-img-02.jpg"></a></div>
								<div class="swiper-slide web"><a href="#!"><img src="/static/img/images/slide-img-03.jpg"></a></div>
								<div class="swiper-slide web"><a href="#!"><img src="/static/img/images/slide-img-04.jpg"></a></div>
								<div class="swiper-slide mobile"><a href="#!"><img src="/static/img/images/slide-img-01_mobile.jpg"></a></div>
								<div class="swiper-slide mobile"><a href="#!"><img src="/static/img/images/slide-img-02_mobile.jpg"></a></div>
								<div class="swiper-slide mobile"><a href="#!"><img src="/static/img/images/slide-img-03_mobile.jpg"></a></div>
								<div class="swiper-slide mobile"><a href="#!"><img src="/static/img/images/slide-img-04_mobile.jpg"></a></div>
								</div>
								<!-- Add Pagination -->
								<div class="swiper-pagination"></div>
								<!-- Add Arrows -->
								<div class="swiper-button-next"></div>
								<div class="swiper-button-prev"></div>
							</div>			
						</div>
						<script>
							var swiper = new Swiper('.swiper-container', {
							  speed: 1000,	
							  slidesPerView: 1,
							  spaceBetween: 0,
							  loop: true,
							  autoplay: {
								delay: 3000,
								disableOnInteraction: false,
							  },	
							  pagination: {
								el: '.swiper-pagination',
								clickable: true,
							  },
							  navigation: {
								nextEl: '.swiper-button-next',
								prevEl: '.swiper-button-prev',
							  },
							});
						</script>
						<!-- main-slide(E) -->		
						
						
						<div class="main_data">
							<div class="md_in">
								<h2 class="mc_comment">
									<span class="t_sub">21세기 농산물 유통의 새로운 모델,</span>
									<span class="t_point">강릉농산물도매시장</span>이 <em></em>새로이출발합니다!
								</h2>
								<div class="mc_01_wrap">
									<div class="mc_01_tit_box">
										<div class="fl">
											<h4 class="mc_01_tit">실시간 시세정보</h4>
										</div>
									</div>
									<div class="main_data_table">
										<table>
											<colgroup>
												<col style="width:15%;">
												<col style="width:20%;">
												<col style="width:13%;">
												<col style="width:13%;">
												<col style="width:13%;">
												<col style="width:13%;">
												<col style="width:13%;">
											</colgroup>
											<thead>
												<tr>
													<th>품목</th>
													<th>품종</th>
													<th>단량/단위</th>
													<th>등급</th>
													<th>최저가</th>
													<th>최고가</th>
													<th>평균가</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>생강</td>
													<td>생강(일반)</td>
													<td>10kg</td>
													<td>특</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>										
											</tbody>
										</table>
									</div>
									<a href="#!" class="btn_more">더보기</a>
								</div>
							</div>
						</div> 
					</div>
					<!-- MAIN CONTENT-01(E) -->

					<!-- MAIN CONTENT-02(S) -->
					<div class="mc_in_cont_02">
						<div class="fl">
							<ul class="mc_step">
								<li>
									<a href="#!">
										<span class="ms_web">
											<img src="/static/img/mc_step_01.png">
											<img src="/static/img/mc_step_01_on.png">
										</span>
										<span class="ms_m">
											<img src="/static/img/mc_step_01_m.png">
											<img src="/static/img/mc_step_01_m_on.png">
										</span>
									</a>
								</li>
								<li>
									<a href="#!">
										<span class="ms_web">
											<img src="/static/img/mc_step_02.png">
											<img src="/static/img/mc_step_02_on.png">
										</span>
										<span class="ms_m">
											<img src="/static/img/mc_step_02_m.png">
											<img src="/static/img/mc_step_02_m_on.png">
										</span>
									</a>
								</li>
								<li>
									<a href="#!">
										<span class="ms_web">
											<img src="/static/img/mc_step_03.png">
											<img src="/static/img/mc_step_03_on.png">
										</span>
										<span class="ms_m">
											<img src="/static/img/mc_step_03_m.png">
											<img src="/static/img/mc_step_03_m_on.png">
										</span>
									</a>
								</li>
							</ul>
						</div>
						<div class="fr">
							<div class="mc_notice">
								<div class="mc_n_title">
									<div class="fl">
										<ul class="mc_tab">
											<li class="on"><a href="#!">공지사항</a></li>
											<li><a href="#!">시황속보</a></li>
										</ul>
									</div>
									<div class="fr">
										<a href="#!" class="btn_tab_more">+ 더보기</a>
									</div>
								</div>
								<ul class="mc_tab_conts">
									<li>
										<div class="notice_table">
											<table>
												<colgroup>
													<col style="width:80%">
													<col style="width:20%">
												</colgroup>
												<thead>
													<tr>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td><a href="#!">2020년 데이터바우처지원사업 우수사례</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">농산물 부정유통 근절을 위한 경매사 간담회 실시간담회 실시간담회 실시간담회 실시간담회 실시간담회 실시간담회 실시간담회 실시간담회 실시</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(주)강릉농산물도매시장 설날 휴장안내</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(주)강릉농산물도매시장 설날 휴장안내</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">농산물 부정유통 근절을 위한 경매사 간담회 실시</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
												</tbody>
											</table>
										</div>
									</li>
									<li>
										<div class="notice_table">
											<table>
												<colgroup>
													<col style="width:80%">
													<col style="width:20%">
												</colgroup>
												<thead>
													<tr>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td><a href="#!">코로나19 사회적 거리두기 2.5단계</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">농산물 부정유통 근절을 위한 경매사 간담회 실시</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(주)강릉농산물도매시장 설날 휴장안내</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">양파 김치 기부행사동참</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">2020년 데이터바우처지원사업 우수사례 </a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
												</tbody>
											</table>
										</div>										
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- MAIN CONTENT-02(E) -->

				</div>
			</div>
			<!-- main-contents(E) -->

		
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
				  <li><a href="/notice/noticeList">· 공지사항</a></li>
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


