<%@page import="DTO.OpenPerformanceDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연 수정 처리</title>
</head>
<body>
	<%

request.setCharacterEncoding("UTF-8");
String msg = null;


if(SystemController.pDao.updateAll(request.getParameter("type"), Integer.parseInt(request.getParameter("time")), request.getParameter("name")))
	msg="ad_pf_modify.jsp?msg=1";
else
	msg="ad_pf_modify.jsp?msg=0";

response.sendRedirect(msg);

%>


</body>
</html>