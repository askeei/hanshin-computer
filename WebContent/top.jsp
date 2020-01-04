<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/hanna.css" />



</head>
<body id="body">
<!-- Start Top Header Bar -->
<div class="header_area">
<section class="top-header">
	<div class="container" style="padding-top:15px; padding-bottom:5px;">
		<div class="row">
			<div class="col-md-4 col-xs-12 col-sm-4">
				
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Site Logo -->
				<div class="logo text-center">
					<a href="index.jsp">
						<img src="/hanshin/images/logo.jpg" alt="한신대학교컴퓨터공학부">
					</a>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
			<!-- Cart -->
		<ul class="top-menu text-right list-inline" style="font-family:'Hanna', sans-serif;">
		
		<%
			if(session.getAttribute("type") == null){
				out.print("<li class='dropdown search dropdown-slide'>");
				out.print("<a href='login.jsp'>로그인</a></li>");
				out.print("<li class='dropdown search dropdown-slide'>");
				out.print("<a href='join.jsp'>회원가입</a></li>");
			}
			else if(session.getAttribute("type").equals(2)){
				out.print("<li class='dropdown search dropdown-slide'>");
				out.print("반갑습니다! <a href='user_info.jsp' style='color:#2457BD;'><ins>");
				out.print(session.getAttribute("name")+"</ins></a> 님");
				out.print("</li><li class='dropdown search dropdown-slide'>");
				out.print("<a href='logout.jsp'><ins>로그아웃</ins></a></li>");
			}
			else if(session.getAttribute("type").equals(1)){
				out.print("<li class='dropdown search dropdown-slide'>");
				out.print("반갑습니다! admin관리자 <a href='user_info.jsp' style='color:#2457BD;'><ins>");
				out.print(session.getAttribute("name")+"</ins></a> 님");
				out.print("</li><li class='dropdown search dropdown-slide'>");
				out.print("<a href='logout.jsp'><ins>로그아웃</ins></a></li>");
			}
			else if(session.getAttribute("type").equals(0)){
				out.print("<li class='dropdown search dropdown-slide'>");
				out.print("환영합니다! 회원  <a href='user_info.jsp' style='color:#2457BD;'><ins>");
				out.print(session.getAttribute("name")+"</ins></a> 님");
				out.print("</li><li class='dropdown search dropdown-slide'>");
				out.print("<a href='logout.jsp'><ins>로그아웃</ins></a></li>");
			}
		
		
		%>

	        </ul><!-- / .nav .navbar-nav .navbar-right -->
			</div>
		</div>
	</div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
	<nav class="navbar navigation" style="padding:0px;">
	    <div class="container">
	      <div class="navbar-header">
	      	<h2 class="menu-title">Main Menu</h2>
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	          <span class="sr-only">Toggle navigation</span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>

	      </div><!-- / .navbar-header -->

	      <!-- Navbar Links -->
	      <div id="navbar" class="navbar-collapse collapse text-center">
	        <ul class="nav navbar-nav">
	          <!-- 학부소개 -->
	          <li class="dropdown dropdown-slide">
	            <a href="introduction.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">학부소개 <span class="tf-ion-ios-arrow-down"></span></a>
	            <ul class="dropdown-menu">
					<li><a href="introduction.jsp">학부소개</a></li>
					<li><a href="curriculum.jsp">교육과정</a></li>
					<li><a href="subject.jsp">교과목소개</a></li>
					<li><a href="professors.jsp">교수진소개</a></li>
					<li><a href="lab.jsp">연구실소개</a></li>
					<li><a href="facility.jsp">시설소개</a></li>
					<li><a href="history.jsp">학부연혁</a></li>
	            </ul>
	          </li><!-- / 학부소개 -->

	          <!-- 학부소식 -->
	          <li class="dropdown dropdown-slide">
	            <a href="exhibition.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">학부소식 <span class="tf-ion-ios-arrow-down"></span></a>
	            <ul class="dropdown-menu">
					<li><a href="notice.jsp">학부공지사항</a></li>
					<li><a href="notice_incruit.jsp">취업공지사항</a></li>
	            </ul>
	          </li><!-- / 학부소식 -->
	          
				
				
				
			<%
			
			out.print("<li class='dropdown dropdown-slide'>");
			out.print("<a href='#' class='dropdown-toggle' data-toggle='dropdown' data-hover='dropdown' data-delay='350' role='button' aria-haspopup='true' aria-expanded='false'>안내 <span class='tf-ion-ios-arrow-down'></span></a>");
			out.print("<ul class='dropdown-menu'>");
			out.print("<li><a href='location.jsp'>오시는길</a></li>");
			out.print("<li><a href='contact.jsp'>문의사항</a></li></ul></li>");
			
				if(session.getAttribute("type") == null){
				}
				else if (session.getAttribute("type").equals(2)){
		               out.print("<li class='dropdown full-width dropdown-slide'>");
		               out.print("<a href='#' class='dropdown-toggle' data-toggle='dropdown' data-hover='dropdown' data-delay='350' role='button' aria-haspopup='true' aria-expanded='false'>관리 <span class='tf-ion-ios-arrow-down'></span></a>");
		               
		               out.print("<div class='dropdown-menu'>");
		               out.print("<div class='row'>");
		               
		               out.print("<div class='col-sm-3 col-xs-12' >");
		            		   out.print("<a href='#'>");
		            				   out.print("	<img class='img-responsive' src='images/p3.jpg' alt='menu image' />");
		            						   out.print("</a>");
		            								   out.print("</div>");
		               
		               
		               
		               out.print("<div class='col-sm-3 col-xs-12'><ul>");
		               out.print("<li class='dropdown-header'>공지 관리</li>");
		               out.print("<li role='separator' class='divider'></li>");
		               out.print("<li><a href='rt_pf_list.jsp'>학부공지 조회</a></li>");
		               out.print("<li><a href='rt_ex_list.jsp'>취업공지 조회</a></li></ul></div>");
		       
		               
		               out.print("<div class='col-sm-3 col-xs-12'><ul>");
		               out.print("<li class='dropdown-header'>회원 관리</li>");
		               out.print("<li role='separator' class='divider'></li>");
		               out.print("<li><a href='rt_member_list.jsp'>조회</a></li>");
		               out.print("<li><a href='rt_member_add.jsp'>관리자등록</a></li></ul></div>");

				}
				else if (session.getAttribute("type").equals(1)){
					out.print("<li class='dropdown full-width dropdown-slide'>");
					out.print("<a href='#' class='dropdown-toggle' data-toggle='dropdown' data-hover='dropdown' data-delay='350' role='button' aria-haspopup='true' aria-expanded='false'>관리 <span class='tf-ion-ios-arrow-down'></span></a>");
					
					%>
					<!--  
					<div class="dropdown-menu">
		              	<div class="row">
			                <div class="col-sm-3 col-xs-12" style="width:35%;">
			                	<ul>
									<li class="dropdown-header">공연 관리</li>
									<li role="separator" class="divider"></li>
									<li><a href="#">조회</a></li>
									<li><a href="#">등록</a></li>
			                	</ul>
			                </div>
	
			                <div class="col-sm-3 col-xs-12" style="width:35%;">
			                	<ul>
									<li class="dropdown-header">전시 관리</li>
									<li role="separator" class="divider"></li>
									<li><a href="#">조회</a></li>
									<li><a href="#">등록</a></li>
			                	</ul>
			                </div>
			                <div class="col-sm-3 col-xs-12" style="width:35%;">
			                	<ul>
									<li class="dropdown-header">장소 관리</li>
									<li role="separator" class="divider"></li>
									<li><a href="#">조회</a></li>
									<li><a href="#">등록</a></li>
			                	</ul>
			                </div>
			                <div class="col-sm-3 col-xs-12" style="width:35%;">
			                	<ul>
									<li class="dropdown-header">회원 관리</li>
									<li role="separator" class="divider"></li>
									<li><a href="#">조회</a></li>
									<li><a href="#">관리자 등록</a></li>
			                	</ul>
			                </div>     
		              	</div>
	            	</div>-->
					
					
					<div class="dropdown-menu">
		              	<div class="row">
		              	
		              		<div class="col-sm-3 col-xs-12" >
			                	<a href="shop.html">
				                	<img class="img-responsive" src="images/p3.jpg" alt="menu image" />
			                	</a>
			                </div>
			                <!-- Introduction -->
			                <div class="col-sm-3 col-xs-12" style="width:35%;">
			                	<ul>
									<li class="dropdown-header">학부공지사항</li>
									<li role="separator" class="divider"></li>
									<li><a href="ad_pf_list.jsp">조회</a></li>
									<li><a href="ad_pf_add.jsp">등록</a></li>
			                	</ul>
			                </div>
	
			                <!-- Contact -->
			                
		              	</div><!-- / .row -->
	            	</div><!-- / .dropdown-menu -->
	            
	            <%

					out.print("</li>");
					
	           
				}
				else if (session.getAttribute("type").equals(0)){

					
					out.print("<li class='dropdown'>");
					
					out.print("</li>");
					
					//out.print("<a class='btn btn--success btn--floating box-shadow-wide' href='performance.jsp'>");
					//out.print("<span class='btn__text'>예매하기!</span></a>");
				}
			%>

	        </ul><!-- / .nav .navbar-nav -->

	      	</div><!--/.navbar-collapse -->
	    </div><!-- / .container -->
	</nav>
</section>
</div>
	

	

</body>
</html>