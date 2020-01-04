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

SystemController.pDao.deleteOpenPerformance(request.getParameter("name"));

OpenPerformanceDTO op = new OpenPerformanceDTO();

op.setName(request.getParameter("name"));
op.setPlace(request.getParameter("place"));
op.setSdate(request.getParameter("sdate"));
op.setEdate(request.getParameter("edate"));
op.setStime(request.getParameter("stime"));
op.setPriceSeatR(Integer.parseInt(request.getParameter("priceSeatR")));
op.setPriceSeatS(Integer.parseInt(request.getParameter("priceSeatS")));
op.setPriceSeatA(Integer.parseInt(request.getParameter("priceSeatA")));
op.setId(session.getAttribute("id").toString());
op.setOpened(Integer.parseInt(request.getParameter("opened")));

if(SystemController.pDao.openPerformanceAdd(op))
	msg="rt_pf_modify_op.jsp?msg=1";
else
	msg="rt_pf_modify_op.jsp?msg=0";

response.sendRedirect(msg);

%>


</body>
</html>