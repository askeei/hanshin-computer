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

  <title>학부공지개시수정</title>

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

<section class="page-header sub_page" style="padding-top:300px;margin-top:0px">			<!-- padding-top:300px -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">개시학부공지수정</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">개시학부공지수정</li>
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
								<li class="join_field">공연번호</li>
								<li class="join_input">1<input type="hidden" placeholder="공연시간을 분으로 입력하세요. ex)2시간->120" class="form-control" name="pno" id="pno"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연이름</li>
								<li class="join_input">
									<div class="input-group subscription-form">
										<input type="text" placeholder="공연이름을 입력하세요" class="form-control" name="name" id="name" onchange="ch(this)">
									</div>
									
								</li>
							</ul>
						</div>
						
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연시작일</li>
								<li class="join_input"><input type="text" placeholder="공연시작일을 입력하여 수정하세요. ex)18.06.09" class="form-control" name="edate" id="edate"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연종료일</li>
								<li class="join_input"><input type="text" placeholder="공연종료일을 입력하여 수정하세요. ex)18.06.10" class="form-control" name="edate" id="edate"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">시작시간</li>
								<li class="join_input"><input type="text" placeholder="공연시간을 분으로 입력하여 수정하세요. ex)18:00" class="form-control" name="time" id="time"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">장소</li>
								<li class="join_input"><input type="text" placeholder="공연장소를 입력하여 수정하세요. " class="form-control" name="place" id="place"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">R석가격</li>
								<li class="join_input"><input type="text" placeholder="R석가격  ex)100000" class="form-control" name="priceSeatR" id="priceSeatR"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">S석가격</li>
								<li class="join_input"><input type="text" placeholder="S석가격  ex)100000" class="form-control" name="priceSeatS" id="priceSeatS"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">A석가격</li>
								<li class="join_input"><input type="text" placeholder="A석가격  ex)100000" class="form-control" name="priceSeatA" id="priceSeatA"></li>
							</ul>
						</div>
			
						<div id="cf-submit" class="ad_btn_list">
							<input type="submit" class="btn btn-transparent ad_btn" value="수정하기">
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