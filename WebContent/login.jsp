<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, main.*, DAO.*, controller.*, DTO.*, java.util.Vector"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
	<%
		request.setCharacterEncoding("euc-kr"); 
	%>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>컴퓨터공학부 - 로그인</title>

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
    
        function checkValue()
        {
            inputForm = eval("document.loginForm");
            if(!inputForm.id.value)
            {
                alert("아이디를 입력하세요. ");    
                inputForm.id.focus();
                return false;
            }
            if(!inputForm.pw.value)
            {
                alert("비밀번호를 입력하세요. ");    
                inputForm.pw.focus();
                return false;
            }
            inputForm.id.focus();
        }
    </script>

</head>

<body id="body">

<!-- Start Top Header Bar -->
<div class="header_area">

<section class="page-wrapper">
	<div class="contact-section">
		<div class="container">
			<div class="row">
				<!-- Contact Form -->
				<div class="contact-form col-md-6 " >
					<form name="loginForm" id="contact-form" method="post" action="loginHandling.jsp" role="form" onsubmit="return checkValue()">
						<div class="login_logo mt50">
							<a href="index.jsp"><img src="/hanshin/images/logo.jpg" alt="예술의 전당" style="width:40%;"></a>
						</div>
						<div class="form-group mt70" style="text-align:center;">
							<ul class="join_list">
								<li class="login_field">아이디</li>
								<li class="login_input"><input type="text" placeholder="ID를 입력하세요" class="form-control" name="id" id="id" autofocus></li>
							</ul>
						</div>
						
						<div class="form-group" style="text-align:center;">
							<ul class="join_list">
								<li class="login_field">비밀번호</li>
								<li class="login_input"><input type="password" placeholder="비밀번호를 입력하세요." class="form-control" name="pw" id="pw"></li>
							</ul>
						</div>
						
						<div class="login_area">
							<div id="cf-submit">
								<input type="submit" id="contact-submit" class="oin_btn" value="로그인" style="width:50%;">
							</div>
							
						</div>	
										
					</form>
					<div style="text-align:center;">
						<a href="join.jsp" style="color:#fff;"><button class="join_btn" onclick="join.jsp" style="border-radius:10px;">회원가입</button></a>
					</div>
					
				</div>
				<!-- ./End Contact Form -->
				
				<%
				String msg=request.getParameter("msg");
	            
	            if(msg!=null && msg.equals("0")) 
	            {
	            	out.print("<script>alert('아이디가 존재하지 않습니다!')</script>");
	            }
	            else if(msg!=null && msg.equals("-1"))
	            {    
	            	out.print("<script>alert('비밀번호가 다릅니다!')</script>");
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