<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>컴퓨터공학부 오시는길</title>

  <!-- Mobile Specific Meta-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/hanshin/images/favicon.ico" />  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="plugins/slick-carousel/slick/slick.css"/>
  <link rel="stylesheet" type="text/css" href="plugins/slick-carousel/slick/slick-theme.css"/>
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="css/style.css">
  <style>
  
   .category-box {
    width: 48%;
    display: inline-block;
    margin: 4px;
    }
  
  </style>
</head>

<body id="body">

<%@include file="top.jsp"%>

<section class="page-header sub_page" style="padding-top:300px;margin-top:0px">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">오시는길</h1>
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li class="active">안내</li>
						<li class="active">오시는길</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="page-wrapper location">
	<div class="contact-section">
		<div class="container">
			<div class="row">
				<h2 class="loca_title">컴퓨터공학부 오시는길</h2>
				
				
				<table style="width:100%; margin-top:50px;"class="loca_table">
					<thead>
						<tr>
							<th style="text-align:center;">대중교통</th>
							<th style="text-align:center;">승용차</th>
						</tr>
					</thead>
					<tfoot>

					</tfoot>
					<tbody>
						<tr>
							<td style="border-right: 1px solid #ccc;">
								<ul>
									<li><h4>지하철</h4>
										<ul>
											<li><span  class="loca_blue">1호선</span>
												<ul>
													<li class="loca_blue">병점역 2번 출구</li>
													<li>2번출구 버스정류장에서 마을버스(55, 56) 이용</li>	
													
												</ul>
											</li>
											
										</ul>
									</li>
									<li class="mt50"><h4>버스</h4>
										<ul>
											<li><span class="loca_green">시내버스</span>
												<ul>
													<li class="loca_blue">8번</li>
													<li>병점사거리(36753)에서  탑승 ‘양산제일교회’(24394)에서 하차 후 도보 이동</li>
													<li>※ 병점사거리 환승가능 버스 : <br>일반버스 20번, 20-1번, 201번, 202번, 300-1번, 301번, 5-1번, 7번, 710번,<br> 
													300번, 100번, 27번, 27-2번, 직행 1550-1번</li>
												</ul>
											</li>
											<li class="mt20"><span class="loca_red">직행</span>
												<ul>
													<li class="loca_red">1550-1</li>
													<li>광역버스 : 학교-강남역(1550-1)<br>
													한신대학교 기숙사 앞 승강장에서 승하차</li>
												</ul>
											</li>
											
										</ul>
									</li>
								</ul>
							</td>
							<td style="vertical-align: top; padding-left: 35px;">
								<ul>
									<li><h4>고속도로</h4>
										<ul>
											<li>
												<ul>
													<li class="color_777 mt30">
													<span>수원 IC (13.9km, 약 27분)</span><br>
													수원 IC 출구 좌회전 → 오산천2길 좌회전 → 서령로 좌회전 →315번 지방도 고가도로 →<br>
													박지성길 오산/동탄/병점 방면 좌회전 → 북태안길 우측방향 → 점역/동탄 방면 좌회전 →<br>
													효행길 84번 지방도 고가도로 → 한신대길 좌회전 → 한신대학교도착
													<li class="color_777 mt20"><span>기흥(동탄) IC (8.7km, 약 14분)</span><br>
													기흥(동탄) IC 출구 → 오산/용인 방면 지하차도 → 수원/능동마을방면 우측 → 지하차도 옆길 → <br>
													315번 지방도 능리교차로 좌회전 → 병점 방면 → 효행길 84번 지방도 고가도로 → 한신대길 좌회전 → 한신대학교도착
													</li>
													<li class="color_777 mt20"><span>북오산 IC (9.2km, 약 14분)</span><br>
													북오산IC 출구 → 성호중고길 우회전 → 동부대로 우회전 → 대원로 좌회전 → 중앙대로 1번국도 →<br>
													세마대사거리에서 정남 방면 좌회전 → 양산로 우회전 → 한신대길 좌회전 → 한신대학교도착
													</li>	
													<li class="color_777 mt20"><span>안녕 IC (4.9km, 약 10분)</span><br>
													ⓛ 과천ㆍ의왕고속도로 진입 → 400번 봉담동탄고속도로 진입 → 동탄ㆍ정남 방면 → <br>
													17번 평택화성고속도로 동화성ㆍ평택방면 우측방향 → 동화성ㆍ안녕방면 좌측방향 → <br>
													안녕IC → 84번 우측방향 → 한신대길 우회전 → 한신대학교도착<br>
													② 서해안고속도로 진입 → 40번 평택제천고속도로 음성ㆍ경부고속도로 방면 우측 → <br>
													17번 평택화성고속도로 동화성ㆍ평택방면 우측방향 → 동화성ㆍ안녕방면 좌측방향 → <br>
													안녕IC → 84번 우측방향 → 한신대길 우회전 → 한신대학교도착
													</li>		
												</ul>
											</li>
										</ul>
									</li>
									<li><h4 class="mt50">일반대로</h4>
										<ul>
											<li class="mt30"><span>국도</span>
												<ul>
													<li class="color_777">
														1번 국도 (서울, 시흥, 안양, 군포, 의왕 방면) 경수로 1번 국도 동수원사거리 오산방면으로 직진 →<br>
														권선지하차도 → 비행장도로 → 병점지하차도 옆길 →315번 지방도 화성시청/정남 방면으로 우회전 → <br>
														효행길 84번 지방도 고가도로 → 한신대길 좌회전 → 한신대학교도착
													</li>
												</ul>
											</li>
											
										</ul>
									</li>
								</ul>
							</td>
						</tr>
					</tbody>

				</table>

				
				<!-- Contact Details -->
				<div class="contact-details col-md-6 mt50" >
					<iframe src="https://www.google.com/maps/embed?pb=!1m23!1m12!1m3!1d3178.319434253289!2d127.02524741570674!3d37.19264157986963!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m8!3e3!4m0!4m5!1s0x357b4145da33c3f9%3A0x9f929c6e93d822ce!2z6rK96riw64-EIOyYpOyCsOyLnCDslpHsgrDrj5kgMjY0IO2VnOyLoOuMgO2Vmeq1kCA2MOyjvOuFhOq4sOuFkOq0gA!3m2!1d37.1926416!2d127.02743609999999!5e0!3m2!1sko!2skr!4v1541078825950" width="100%" height="500px" frameborder="0" style="border:0" allowfullscreen></iframe>

					<ul class="contact-short-info" >
						<li>
							<i class="tf-ion-ios-home"></i>
							<span>한신대학교[오산캠퍼스] 경기도 오산시 한신대길 137 (양산동) (우) 18101</span>
						</li>
						<li>
							<i class="tf-ion-android-phone-portrait"></i>
							<span>Phone: 031-379-0045</span>
						</li>
						
						<li>
							<i class="tf-ion-android-mail"></i>
							<span>Email: dkstjrrud@naver.com</span>
						</li>
					</ul>
					<!-- Footer Social Links -->
					<div class="social-icon">
						<ul>
							<li><a class="fb-icon" href="#"><i class="tf-ion-social-facebook"></i></a></li>
							<li><a href="#"><i class="tf-ion-social-twitter"></i></a></li>
						</ul>
					</div>
					<!--/. End Footer Social Links -->
				</div>
				<!-- / End Contact Details -->
			</div> <!-- end row -->
		</div> <!-- end container -->
	</div>
</section>
	
<%@include file="bottom.jsp"%>
    <!-- 
    Essential Scripts
    =====================================-->
    

    <!-- Main jQuery -->
    <script src="https://code.jquery.com/jquery-git.min.js"></script>
    <!-- Bootstrap 3.1 -->
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- Instagram Feed Js -->
    <script src="plugins/instafeed.js/instafeed.min.js"></script>
    <!-- Slick Carousel -->
    <script src="plugins/slick-carousel/slick/slick.min.js"></script>
    <!-- Google Map js -->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBItRd4sQ_aXlQG_fvEzsxvuYyaWnJKETk&callback=initMap"></script>

    <!-- Main Js File -->
    <script src="js/script.js"></script>
    


  </body>
  </html>