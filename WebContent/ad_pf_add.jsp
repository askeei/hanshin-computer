<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>학부공지사항등록</title>

  <!-- Mobile Specific Meta-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/hanshin/images/favicon.ico" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="/hanshin/plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="/hanshin/plugins/bootstrap/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="/artcenter/plugins/slick-carousel/slick/slick.css"/>
  <link rel="stylesheet" type="text/css" href="/artcenter/plugins/slick-carousel/slick/slick-theme.css"/>
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="/hanshin/css/style.css">
  <style>
  
   .category-box {
    width: 48%;
    display: inline-block;
    margin: 4px;
    }
  
  </style>
   <script type="text/javascript">
   
   		var flag = false;
    
        function checkValue()
        {
            inputForm = eval("document.joinForm");
            if(!inputForm.name.value)
            {
                alert("공연이름을 입력하세요. ");    
                inputForm.id.focus();
                return false;
            }
            if(!inputForm.time.value)
            {
                alert("공연시간을 입력하세요. ");    
                inputForm.pw.focus();
                return false;
            }
            if(!inputForm.pwc.value)
            {
                alert("비밀번호확인을 입력하세요. ");    
                inputForm.pwc.focus();
                return false;
            }
        }
        

    </script>
</head>

<body id="body">

<%@include file="top.jsp" %>

<section class="page-header sub_page" style="padding-top:300px;margin-top:0px">			<!-- padding-top:300px -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">학부공지등록</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">학부공지등록</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="page-wrapper">
	<div class="contact-section">
		<div class="container">
			<div class="row">
				<!-- Contact Form -->
				<%
				String msg = request.getParameter("msg");
				
				if(msg == null){
				%>
				<div class="contact-form col-md-6 " >
					<form name="joinForm" method="post" action="ad_pf_addHandling.jsp" enctype="multipart/form-data" onsubmit="return checkValue()">
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공지제목</li>
								<li class="join_input">
									<div class="input-group subscription-form">
										<input type="text" placeholder="제목을 입력하세요" class="form-control" name="name" id="name">
									</div>
									
								</li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공지유형</li>
								
								<li class="join_input">
									<select name="type">
									  <option value="test">test</option>
									  <option value="notice">notice</option>
									  <option value="sos">sos</option>
									  <option value="Etc">Etc</option>
									</select>
								</li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">test</li>
								<li class="join_input"><input type="text" placeholder="test ex)->120" class="form-control" name="time" id="time"></li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">포스터</li>
								<li class="join_input"><input type="file" placeholder="첨부파일을 등록하세요." class="form-control" name="poster" id="poster"></li>
							</ul>
						</div>
						
						
						<div id="cf-submit" class="ad_btn_list">
							<input type="submit" class="btn btn-transparent ad_btn" value="공연등록">
							<input type="reset" class="btn btn-transparent ad_btn" value="다시입력" >
							<input type="reset" class="btn btn-transparent ad_btn" value="취소" onclick="javascript:location.href='ad_pf_list.jsp'">
						</div>						
						
					</form>
				</div>
				<!-- ./End Contact Form -->
				
				<% 
				} else {
					if(msg.equals("1")){
						out.println("<center><h2> ☆★ 공연이 등록되었습니다 ★☆ </h2></center>");
					}
					else{
						out.println("<center><h2> 다시 시도해주세요! </h2></center>");
					}
				}
				
				%>
				
			</div> <!-- end row -->
		</div> <!-- end container -->
	</div>
</section>

<%@include file="bottom.jsp" %>
    <!-- 
    Essential Scripts
    =====================================-->
    

    <!-- Main jQuery -->
    <script src="https://code.jquery.com/jquery-git.min.js"></script>
    <!-- Bootstrap 3.1 -->
    <script src="/artcenter/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- Instagram Feed Js -->
    <script src="/artcenter/plugins/instafeed.js/instafeed.min.js"></script>
    <!-- Slick Carousel -->
    <script src="/artcenter/plugins/slick-carousel/slick/slick.min.js"></script>
    <!-- Google Map js -->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBItRd4sQ_aXlQG_fvEzsxvuYyaWnJKETk&callback=initMap"></script>

    <!-- Main Js File -->
    <script src="/artcenter/js/script.js"></script>

  </body>
  </html>