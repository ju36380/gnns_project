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
									<span class="t_sub">21���� ��깰 ������ ���ο� ��,</span>
									<span class="t_point">������깰���Ž���</span>�� <em></em>����������մϴ�!
								</h2>
								<div class="mc_01_wrap">
									<div class="mc_01_tit_box">
										<div class="fl">
											<h4 class="mc_01_tit">�ǽð� �ü�����</h4>
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
													<th>ǰ��</th>
													<th>ǰ��</th>
													<th>�ܷ�/����</th>
													<th>���</th>
													<th>������</th>
													<th>�ְ�</th>
													<th>��հ�</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>
												<tr>
													<td>����</td>
													<td>����(�Ϲ�)</td>
													<td>10kg</td>
													<td>Ư</td>
													<td>17,700</td>
													<td>50,000</td>
													<td>38,850</td>
												</tr>										
											</tbody>
										</table>
									</div>
									<a href="#!" class="btn_more">������</a>
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
											<li class="on"><a href="#!">��������</a></li>
											<li><a href="#!">��Ȳ�Ӻ�</a></li>
										</ul>
									</div>
									<div class="fr">
										<a href="#!" class="btn_tab_more">+ ������</a>
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
														<td><a href="#!">2020�� �����͹ٿ�ó������� ������</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">��깰 �������� ������ ���� ��Ż� ����ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽð���ȸ �ǽ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(��)������깰���Ž��� ���� ����ȳ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(��)������깰���Ž��� ���� ����ȳ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">��깰 �������� ������ ���� ��Ż� ����ȸ �ǽ�</a></td>
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
														<td><a href="#!">�ڷγ�19 ��ȸ�� �Ÿ��α� 2.5�ܰ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">��깰 �������� ������ ���� ��Ż� ����ȸ �ǽ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">(��)������깰���Ž��� ���� ����ȳ�</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">���� ��ġ �����絿��</a></td>
														<td><a href="#!">2021.04.28</a></td>
													</tr>
													<tr>
														<td><a href="#!">2020�� �����͹ٿ�ó������� ������ </a></td>
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

		
		<!-- ����ϸ޴�(S) -->
		<div id="lnb" class="mobile_menu">
			<!-- <div class="dim"></div> -->

			<div class="mm_top">
				<div class="m_log">
					<a href="#!">�α���</a>
					<a href="#!">ȸ������</a>
				</div>
				<a href="#!" class="m_btn_close"><img src="/static/img/m_lnb_close.png" alt="�����lnb�ݱ��ư"></a>
			</div>
			
			<ul class="lnb_box">
			  <li><a href="#none">ȸ��Ұ�</a>
				<ul>
				  <li><a href="#none">�� �λ縻</a></li>
				  <li><a href="#none">�� ȸ�簳��</a></li>
				  <li><a href="#none">�� ����</a></li>
				  <li><a href="#none">�� �������</a></li>
				  <li><a href="#none">�� CI�Ұ�</a></li>
				  <li><a href="#none">�� ������</a></li>
				  <li><a href="#none">�� �൵</a></li>
				  <li><a href="#none">�� �濵����</a></li>
				</ul>
			  </li>
			  
			  <li><a href="#none">����������</a>
				<ul>
				  <li><a href="#none">�� ��Ż�</a></li>
				  <li><a href="#none">�� �ߵ�����</a></li>
				  <li><a href="#none">�� �Ÿ�������</a></li>
				</ul>
			  </li>
			  <li><a href="#none">�ǽð� �ü�����</a>
				<ul>
				  <li><a href="#none">�� �ǽð� �������</a></li>
				  <li><a href="#none">�� �ü����� ��ȸ</a></li>
				  <li><a href="#none">�� ��������</a></li>
				</ul>
			  </li>
			  <li><a href="#none">������ ��������</a>
				<ul>
				  <li><a href="#none">�� �Ǹų���</a></li>
				  <li><a href="#none">�� �����޳���</a></li>
				  <li><a href="#none">�� ��������</a></li>
				</ul>
			  </li>
			  <li><a href="#none">�ߵ����� �ŷ�����</a>
				<ul>
				  <li><a href="#none">�� ���ں� ��������</a></li>
				  <li><a href="#none">�� �Ⱓ�� �ŷ�����</a></li>
				</ul>
			  </li>
			  <li><a href="#none">��깰 ������ �˻�</a>
				<ul>
				  <li><a href="#none">�� �ȼ��� �˻��?</a></li>
				  <li><a href="#none">�� �˻�ü��</a></li>
				  <li><a href="#none">�� ������</a></li>
				</ul>
			  </li>
			  <li><a href="#none">������</a>
				<ul>
				  <li><a href="/notice/noticeList">�� ��������</a></li>
				  <li><a href="#none">�� �Խ���</a></li>
				  <li><a href="#none">�� �ڷ��</a></li>
				</ul>
			  </li>
			</ul>
		  </div>
		  <!-- ����ϸ޴�(E) -->
		</div>
	</div>
	<!-- wrap(E) -->		
</body>
</html>


