<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*, DTO.*, java.util.Vector, 
    java.text.SimpleDateFormat, java.util.Date, java.util.Locale"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>예술의 전당 - 개시 공연 수정</title>

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
  <script src="https://code.jquery.com/jquery-git.min.js"></script>
  <style>
  
   .category-box {
    width: 48%;
    display: inline-block;
    margin: 4px;
    }
  
  </style>
  
   <script type="text/javascript">
   $(document).ready(function(){
	   var startDate = new Date($('#sdate').val());
	   var endDate = new Date($('#edate').val());

	   if (startDate > endDate){
	   	alert('날짜 범위를 확인하세요!');
	   }
		});
   
   		var flag = false;
    
        function checkValue()
        {
            inputForm = eval("document.joinForm");
            
            if(!inputForm.stime.value)
            {
                alert("시작시간을 입력하세요. ");    
                inputForm.pwc.focus();
                return false;
            }
            if(inputForm.sdate.value >= inputForm.edate.value){
            	alert("날짜 범위를 확인하세요! ");
            	return false;
            }
            if(!inputForm.priceSeatR.value)
            {
                alert("R석 가격을 입력하세요. ");    
                inputForm.priceSeatR.focus();
                return false;
            }
            if(!inputForm.priceSeatS.value)
            {
                alert("S석 가격을 입력하세요. ");    
                inputForm.priceSeatS.focus();
                return false;
            }
            if(!inputForm.priceSeatA.value)
            {
                alert("S석 가격을 입력하세요. ");    
                inputForm.priceSeatA.focus();
                return false;
            }
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
					<h1 class="page-name">개시 공연 수정</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">개시 공연 수정</li>
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
				request.setCharacterEncoding("utf-8");
				String msg = request.getParameter("msg");
				
				String name = request.getParameter("name");
				
				
				if(msg == null){
				%>
				<div class="contact-form col-md-6 " >
					<form name="joinForm" method="post" action="rt_pf_modifyHandling_op.jsp" role="form" onsubmit="return checkValue()">
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연이름</li>
								<li class="join_input">
									<div class="input-group subscription-form">
										<input type="text" class="form-control" name="name" id="name" value="<%= name%>" readonly>
									</div>
									
								</li>
							</ul>
						</div>
						
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연장</li>
								
								<li class="join_input">
									<select name="place">
									<%
									for(StagePerformanceDTO s : SystemController.pDao.totalInquiryStagePerformance()){
									
									%>
									  <option value="<%= s.getPlace() %>"><%= s.getPlace() %></option>

									  <% }
									  
									Date d = new Date();
									
									SimpleDateFormat today = new SimpleDateFormat(); 
									today = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA); 
									today.format(d);
									  %>
									</select>
								</li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연시작일</li>
								<li class="join_input"><input type="date" id="sdate" name="sdate" value="<%=today.format(d) %>"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">공연종료일</li>
								<li class="join_input"><input type="date" id="edate" name="edate" value="<%=today.format(d) %>"></li>
							</ul>
						</div>
						<div class="form-group">
							<ul class="join_list">
								<li class="join_field">시작시간</li>
								<li class="join_input"><input type="text" placeholder="공연시간을 분으로 입력하여 수정하세요. ex)18:00" class="form-control" name="stime" id="stime"></li>
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
						
						<input type="hidden" name="id" value="<%=session.getAttribute("id") %>">
						
						<input type="hidden" name="opened" value="<%=SystemController.pDao.inquiryPerformanceOP(name).getOpened()%>">
						
						<div id="cf-submit" class="ad_btn_list">
							<input type="submit" class="btn btn-transparent ad_btn" value="수정하기">
							<input type="reset" class="btn btn-transparent ad_btn" value="다시입력" >
							<input type="reset" class="btn btn-transparent ad_btn" value="취소" onclick="javascript:location.href='ad_pf_list.jsp'">
						</div>						
						
					</form>
				</div>
				<!-- ./End Contact Form -->
				
				<% 
				} else {
					if(msg.equals("1")){
						out.println("<center><h2> ☆★ 공연 정보가 수정되었습니다 ★☆ </h2></center>");
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