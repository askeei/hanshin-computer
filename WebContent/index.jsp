<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, main.*, DAO.*, controller.*, DTO.*, java.util.Vector"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="author" content="Seok Kyung An">

  <title>한신대학교 컴퓨터공학부</title>

  <!-- Mobile Specific Meta-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/hanshin/images/favicon.ico" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="/hanshin/plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="/hanshin/plugins/bootstrap/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="/hanshin/plugins/slick-carousel/slick/slick.css"/>
  <link rel="stylesheet" type="text/css" href="/hanshin/plugins/slick-carousel/slick/slick-theme.css"/>
  <script src="http://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g=" crossorigin="anonymous">
  </script>
  <script type="text/javascript" src="http://kenwheeler.github.io/slick/slick/slick.min.js"></script>
  <script type="text/javascript">
	 $(document).ready(function () {
		$('.slider-item').slick({
			autoplay : true,
			dots: true,
			speed : 1000 /* 이미지가 슬라이딩시 걸리는 시간 */,
			infinite: true,
			autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,
			arrows: true,
			slidesToShow: 1,
			slidesToScroll: 1,
			fade: true
		});
	});
  </script>
  
  
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="/hanshin/css/style.css">
  <style>
  
   .category-box {
    width: 48%;
    display: inline-block;
    margin: 4px;
    }
  
  </style>
  
  
</head>
<body id="body">

<jsp:include page="top.jsp"></jsp:include>

<%@include file="center.jsp" %>
	
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
