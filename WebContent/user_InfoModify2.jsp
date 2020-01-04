<%@page import="controller.Encryption"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DTO.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = Encryption.Encrypting(Integer.toString(request.getParameter("pw").hashCode()));
	String sex = request.getParameter("sex");
	String phone = request.getParameter("phone");

	
	if(controller.SystemController.memberDao.updateInfo(id, pw, sex, phone))
		response.sendRedirect("rt_member_modify.jsp?msg=1");
	else
		response.sendRedirect("rt_member_modify.jsp?msg=0");
	
%>

</body>
</html>