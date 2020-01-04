<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*, DAO.*, controller.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그인 처리</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
	   
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg = null;
    	
		if(!id.equals("") && !pw.equals("")){
			pw = Encryption.Encrypting(Integer.toString(pw.hashCode()));
			
			if(SystemController.memberDao.checkID2(id))
				msg = "login.jsp?msg=0";
			else if(SystemController.memberDao.login(id,pw) == -1) 
				msg = "login.jsp?msg=-1";
			else{
				session.setAttribute("id", id);
				session.setAttribute("name", SystemController.memberDao.searchID(id).getName());
				session.setAttribute("type", SystemController.memberDao.searchID(id).getType());
				msg = "index.jsp";
			}
		}
		
		response.sendRedirect(msg);
		
	
	
	%>


</body>
</html>