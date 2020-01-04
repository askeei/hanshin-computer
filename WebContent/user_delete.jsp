<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 삭제</title>
</head>
<body>
<%

request.setCharacterEncoding("utf-8");

response.sendRedirect("rt_member_list.jsp?"+ SystemController.memberDao.deleteById(request.getParameter("id")));
%>
</body>
</html>