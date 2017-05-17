<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="GB18030"%>
<%@page import="com.xy.registration.model.* "%>
<%@page import="com.xy.registration.service.* "%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String password=request.getParameter("password");
String password2=request.getParameter("password2");

User u=new User();
u.setPassword(password);
u.setUsername(username);
UserManager um=new UserManager();
boolean exist=um.exists(u);
if (exist){
	response.sendRedirect("registerFail.jsp");
	}
	else{
um.add(u);
response.sendRedirect("registerSuccess.jsp");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ÓÃ»§×¢²á</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
