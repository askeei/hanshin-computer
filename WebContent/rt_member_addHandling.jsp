<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*, DAO.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>admin계정 추가 처리</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String msg = null;
		
		DTO.MemberDTO member = new DTO.MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPw(Encryption.Encrypting(Integer.toString((request.getParameter("pw").hashCode()))));
		member.setName(request.getParameter("name"));
		member.setSex(request.getParameter("sex"));
		member.setPhone(request.getParameter("phone"));
		member.setType(1);
		   
		if(SystemController.memberDao.memberRegist(member))
			msg="rt_member_add.jsp?msg=1";
		else
			msg="rt_member_add.jsp?msg=0";
		
		response.sendRedirect(msg);
		
	%>


</body>
</html>