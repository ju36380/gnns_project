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

<title>�α���</title>

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
<script src="/static/js/login/login.js" defer></script>
</head>

<body> 
	<!-- warp(S) -->
	<div class="wrap">
		<div class="w_in">
		<!-- header(S) -->
		<div class="header">
			<div class="h_in">
				<div class="hi_top">
					<a href="#!" class="main_logo"><img src="/static/img/h_logo.png" alt="����ΰ�"></a>
					<div class="h_search_box">
						<div class="signin">
							<a href="#!">�α���</a>
							<a href="#!">ȸ������</a>
						</div>
					</div>
					<a href="#!" class="btn_mobile_menu btn_lnb"><img src="/static/img/menu_icon.png" alt="����ϸ޴���ư"></a>
				</div>
				<div class="hi_bottom">
					<ul class="nav">
						<div class="nav_bg"></div>  
						<li class="navi_set">  
							<div class="topnav"><a href="#!">ȸ��Ұ�</a></div>
							<ul class="subnav">  
								<li><a href="#!">�λ縻</a></li>  
								<li><a href="#!">ȸ�簳��</a></li> 
								<li><a href="#!">����</a></li>  
								<li><a href="#!">�������</a></li>  
								<li><a href="#!">CI�Ұ�</a></li>  
								<li><a href="#!">������</a></li>  
								<li><a href="#!">�൵</a></li>  
								<li><a href="#!">�濵����</a></li>  
							</ul>  
						</li>  

						<li class="navi_set">  
							<div class="topnav"><a href="#!">����������</a></div>
							<ul class="subnav">  
								<li><a href="#!">��Ż�</a></li>  
								<li><a href="#!">�ߵ�����</a></li> 
								<li><a href="#!">�Ÿ�������</a></li>  
							</ul>  
						</li> 
						
						<li class="navi_set">  
							<div class="topnav"><a href="#!">�ǽð� �ü�����</a></div>
							<ul class="subnav">  
								<li><a href="#!">�ǽð� �������</a></li>  
								<li><a href="#!">�ü����� ��ȸ</a></li> 
								<li><a href="#!">��������</a></li> 
							</ul>  
						</li> 

						<li class="navi_set">  
							<div class="topnav"><a href="#!">������ ��������</a></div>
							<ul class="subnav">  
								<li><a href="#!">�Ǹų���</a></li>  
								<li><a href="#!">�����޳���</a></li> 
								<li><a href="#!">��������</a></li>  
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">�ߵ����� �ŷ�����</a></div>
							<ul class="subnav">  
								<li><a href="#!">���ں� ��������</a></li>  
								<li><a href="#!">�Ⱓ�� �ŷ�����</a></li> 
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">��깰 ������ �˻�</a></div>
							<ul class="subnav">  
								<li><a href="#!">������ �˻��?</a></li>  
								<li><a href="#!">�˻�ü��</a></li> 
								<li><a href="#!">������</a></li>  
							</ul>  
						</li>
						<li class="navi_set">  
							<div class="topnav"><a href="#!">������</a></div>
							<ul class="subnav">  
								<li><a href="#!">��������</a></li>  
								<li><a href="#!">�Խ���</a></li> 
								<li><a href="#!">�ڷ��</a></li>  
							</ul>  
						</li>
						<li><a href="#!" class="btn_global"><img src="/static/img/menu_icon.png" alt="�۷ι��޴�"></a>	</li>
					</ul>
					
				</div>
				
			</div>
		</div>
		<!-- header(E) -->

			<!-- sub-contents(S) -->
			<div class="sub_contents log ">
				<div class="sub_in log">
					
					<!-- login(S) -->
					<div class="intro log">
						<h4 class="int_tit">ȸ�� �α���</h4>
						<p class="int_explain">ȸ�������� �Ͻ��� ������ ��ġ�ø� <span class="bold">�Ǹų����������޳�����
							������������ ���� ������ �������������ں� ����������
							�Ⱓ�� �ŷ�����</span> ���� �ߵ����� �ŷ������� ���� �� �ֽ��ϴ�.</p>
						<form name="frm" id="frm" action="/login/loginProc" method="post">
						<div class="member_info">
							<div class="m_blank">
								<label for="idInput">���̵�</label>
								<input type="text" id="idInput" name="memberId">
							</div>
							<div class="m_blank">
								<label for="pwInput">��й�ȣ</label>
								<input type="password" id="pwInput" name="passWd">
							</div>
						</div>
						</form>
						<a href="#!" class="btn_log" onclick="fn_login()">�α���</a>
						<ul class="etc_btn">
							<li><a href="#!">ȸ������</a></li>
							<li><a href="#!">���̵�ã��</a></li>
							<li><a href="#!">��й�ȣ ã��</a></li>
						</ul>
					</div>
					<!-- login(E) -->


				</div>
			</div>
			<!-- sub-contents(E) -->

		<!-- footer(S) -->
		<div class="footer"> 
			<div class="f_in">
				<a href="#!" class="f_logo"><img src="/static/img/f_logo.png"></a>
				<ul class="address">
					<li><span>�ּ�</span> ������ ������ ����� 60</li>
					<li><span>��ǥ��ȭ</span> 033-644-4654</li>
					<li><span>�ѽ�</span> 033-646-4860</li>
				</ul>
				<span class="copy">copyright��(��)������깰���Ž��� all right reserverd.</span>
			</div>

		</div>
		<!-- footer(E) -->

		
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
				  <li><a href="#none">�� ��������</a></li>
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