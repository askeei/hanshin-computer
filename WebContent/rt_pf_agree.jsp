<%@page import="DTO.OpenPerformanceDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지 수정 처리</title>
</head>
<body>
	<%

request.setCharacterEncoding("UTF-8");
String msg = null;

SystemController.pDao.updateOpened(Integer.parseInt(request.getParameter("pno")));


response.sendRedirect("rt_pf_list.jsp");

%>


</body>
</html>