<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복체크</title>
</head>
<body>
	<%
		String check = null;
		String id = request.getParameter("id");
		if(controller.SystemController.memberDao.checkID(id)){
			out.print("<script>alert('이미 사용중인 ID입니다.')</script>");
		}
		else{
			out.print("<script>alert('사용 가능한 ID입니다.')</script>");
		}
			out.print("<script>close()</script>");
	%>
</body>
</html>