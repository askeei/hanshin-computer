<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.*, DTO.*"%>
    
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.io.*" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연 등록 처리</title>
</head>
<body>
<%
//request.setCharacterEncoding("utf-8");
String savePath = request.getServletContext().getRealPath("images");

//파일 크기 15MB로 제한
int sizeLimit = 1024*1024*15;

//↓ request 객체,               ↓ 저장될 서버 경로,       ↓ 파일 최대 크기,    ↓ 인코딩 방식,       ↓ 같은 이름의 파일명 방지 처리
//(HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
//아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

	

	String msg = null;
	PerformanceDTO p = new PerformanceDTO();
	
	p.setName(multi.getParameter("name"));
	p.setType(multi.getParameter("type"));
	p.setTime(Integer.parseInt(multi.getParameter("time")));
	p.setId(session.getAttribute("id").toString());

	String fileName = multi.getFilesystemName("poster");

	if(SystemController.pDao.performanceAdd(p))
		msg="ad_pf_add.jsp?msg=1";
	else
		msg="ad_pf_add.jsp?msg=0";
	
	response.sendRedirect(msg);
%>
</body>
</html>