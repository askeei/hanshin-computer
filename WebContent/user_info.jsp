<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*, DTO.*"%>
    
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>마이페이지</title>

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
  <script>
  function checkValue()
        {
            inputForm = eval("document.userInfo");
          
            if(!inputForm.pw.value)
            {
                alert("비밀번호를 입력하세요. ");    
                inputForm.pw.focus();
                return false;
            }
            if(!inputForm.pwc.value)
            {
                alert("비밀번호확인을 입력하세요. ");    
                inputForm.pwc.focus();
                return false;
            }
            if(inputForm.pw.value != inputForm.pwc.value)
            {
                alert("동일한 비밀번호를 입력하세요. ");    
                inputForm.pwc.focus();
                return false;
            }
			inputForm.pwc.disabled = true;
        }
  </script>
</head>

<body id="body">

<%@include file="top.jsp"%>

<section class="page-header sub_page" style="padding-top:300px;margin-top:0px">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">회원정보수정</h1>
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li>mypage</li>
						<li class="active">회원정보수정</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>

<%
	String id = session.getAttribute("id").toString();

	MemberDTO m = controller.SystemController.memberDao.searchID(id);
	
%>

<section class="page-wrapper">
	<div class="contact-section">
		<div class="container">
			<div class="row">
				<!-- Contact Form -->
				<div class="contact-form col-md-6 " >
					<form name="userInfo" id="contact-form" method="post" action="user_InfoModify.jsp" onsubmit="return checkValue()">
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">이름</li>
								<li class="join_input"><%= m.getName() %><input type="hidden" placeholder="이름을 입력하세요." class="form-control" name="name" id="name" value="<%= m.getName() %>"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">아이디</li>
								<li class="join_input"><%= id %><input type="hidden" placeholder="ID를 입력하세요" class="form-control" name="id" id="id" value="<%= id %>"></li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">비밀번호</li>
								<li class="join_input"><input type="password" placeholder="비밀번호를 입력하세요." class="form-control" name="pw" id="pw"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">비밀번호<br>확인</li>
								<li class="join_input"><input type="password" placeholder="위와 같은 비밀번호를 입력하세요." class="form-control" name="pwc" id="pwc"></li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">성별</li>
								<li>

								<input type="radio" id="sex" name="sex" value="남" checked>남
                       			<input type="radio" id="sex" name="sex" value="여" >여
								</li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">핸드폰번호</li>
								<li class="join_input"><input type="text" value="<%= m.getPhone() %>" class="form-control" name="phone" id="phone">
								<input type="hidden" name="type" value="<%= m.getType() %>">
							</ul>	
						</div>
						<div class="mypage_tab">
							<ul id="cf-submit">
								<li><input type="reset" id="" class="btn btn-transparent mypage_btn" value="다시입력"></li>
								<li><input type="submit" id="contact-submit" class="btn btn-transparent mypage_btn" value="Submit"></li>
							</ul>
						</div>		


					</form>
				</div>
				<!-- ./End Contact Form -->
				
				<% String msg = request.getParameter("msg");
					if(msg!=null && msg.equals("1"))
						out.print("<script>alert('회원정보 수정이 완료되었습니다!')</script>");
					else if(msg!=null && msg.equals("0"))
						out.print("<script>alert('다시 시도해주세요!')</script>");
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