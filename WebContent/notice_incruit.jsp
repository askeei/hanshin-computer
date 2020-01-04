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

  <title>취업공지사항</title>

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

<%@include file="top.jsp" %>

<section class="page-header sub_page" style="padding-top:300px;margin-top:0px">
   <div class="container">
      <div class="row">
         <div class="col-md-12">
            <div class="content">
               <h1 class="page-name">취업공지사항</h1>
               <ol class="breadcrumb">
                  <li><a href="#">Home</a></li>
                  <li class="active">취업공지사항</li>
               </ol>
            </div>
         </div>
      </div>
   </div>
</section>


<section class="about section-sm mt100" id="about">
<div class="container">
  
  <form method="post">
                <table class="table pf_list">
                
                  <thead>
                 	<tr>
                 	  <td colspan="6" class="pf_list_title"><h5>개시완료</h5></td>
                 	</tr>
                    <tr>
                      <th style="vertical-align:middle; width:10%;">번호</th>
                      <th style="vertical-align:middle; width:70%;">제목</th>
                      <th style="vertical-align:middle; width:10%;">날짜</th>
                      <th style="vertical-align:middle; width:10%;">작성자</th>

                    </tr>
                  </thead>
                  <tbody>
                  
                    <%
                    for(OpenExhibitionDTO a : SystemController.eDao.adminInquiryOpenExhibitionByOpened()){
                    
                    %>
                    <tr>
                      <td style="vertical-align:middle;"><%= a.getEno() %></td>
                      <td style="vertical-align:middle;"> 
                           <%= a.getName()%>
                      </td>                      
                      <td style="vertical-align:middle;"><%= a.getSdate() %></td>
                      <td style="vertical-align:middle;"><%= a.getId() %></td>
                      
                    </tr>
                    <%
                    
                    }%>
                    
                    <!-- 
                    <tr>
                      <td style="vertical-align:middle;">2</td>
                      <td style="vertical-align:middle;">공연이름공연이름공연이름공연이름</td>
                      <td style="vertical-align:middle;">오페라극장</td>
                      <td style="vertical-align:middle;">10,000</td>
                      <td style="vertical-align:middle;">~2018.06.11</td>

                      <td class="" style="vertical-align:middle; ">
                       
                        <button class="pf_list_btn">수정</button>
                      </td>
                      <td class="" style="vertical-align:middle; ">
                       
                        <button class="pf_list_btn">삭제</button>
                      </td>
                    </tr>
                     -->
                  
                    
                  </tbody>
                </table>
                
                
              </form>
</section>   <!-- End section -->

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