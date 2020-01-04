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

  <title>예술의 전당 - 전시등록수정</title>

  <!-- Mobile Specific Meta-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/artcenter/images/sac_ci_favicon.png" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="/artcenter/plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="/artcenter/plugins/bootstrap/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="/artcenter/plugins/slick-carousel/slick/slick.css"/>
  <link rel="stylesheet" type="text/css" href="/artcenter/plugins/slick-carousel/slick/slick-theme.css"/>
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="/artcenter/css/style.css">
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
            if(!inputForm.name.value)
            {
                alert("이름을 입력하세요. ");    
                inputForm.name.focus();
                return false;
            }
            if(!inputForm.phone.value)
            {
                alert("핸드폰 번호를 입력하세요. ");    
                inputForm.phone.focus();
                return false;
            }
            if(!flag)//!document.joinForm.id.readOnly
            {
            	alert("아이디 중복체크를 해주세요. ");    
                inputForm.id.focus();
                return false;
            }
        }
        
        function checkId()
        {
        	if(!document.joinForm.id.value){
        		alert("아이디를 입력하세요. ");
        		document.id.value.focus();
        		return false;
        	}
        	
        	url = "checkId.jsp?id=" + document.joinForm.id.value;
        	open(url,"", 'left='+(screen.availWidth-500)/2 + ',top='+(screen.availHeight-300)/2 + ', width=500px,height=150px');
        	flag = true;
        }
        
        function ch(obj){
        	flag = false;
        	//obj.style.backgroundColor = 'yellow';
        }

    </script>
</head>

<body id="body">

<%@include file="top.jsp" %>

<section class="page-header" style="padding-top:300px;margin-top:0px">			<!-- padding-top:300px -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">전시등록수정</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">전시등록수정</li>
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
					<form name="joinForm" method="post" action="joinHandling.jsp" role="form" onsubmit="return checkValue()">
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">전시이름</li>
								<li class="join_input">
									<div class="input-group subscription-form">
										<input type="text" placeholder="전시이름을 입력하여 수정하세요" class="form-control" name="name" id="name" onchange="ch(this)">
									</div>
									
								</li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">장르</li>
								
								<li class="join_input">
									<select name="genre">
									  <option value="art">Art</option>
									  <option value="Photo">Photo</option>
									  <option value="Caligraphy">Caligraphy</option>
									  <option value="Etc">Etc</option>
									</select>
								</li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">주최자</li>
								<li class="join_input"><input type="text" placeholder="주최자를 입력하세요." class="form-control" name="sponsor" id="sponsor"></li>
							</ul>
						</div>
						
						
						
						<div id="cf-submit" class="ad_btn_list">
							<input type="submit" class="btn btn-transparent ad_btn" value="전시수정">
							<input type="reset" class="btn btn-transparent ad_btn" value="다시입력" >
						</div>						
						
					</form>
				</div>
				<!-- ./End Contact Form -->
				
				<% 
				} else {
					if(msg.equals("1")){
						out.println("<center><h2> ☆★ 회원가입이 되신것을 축하드립니다 ★☆ </h2></center>");
					}
					else{
						out.println("<center><h2> 다시 가입해주세요! </h2></center>");
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