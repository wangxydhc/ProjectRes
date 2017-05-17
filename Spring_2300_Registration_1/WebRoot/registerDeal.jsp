<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String password=request.getParameter("password");
String password2=request.getParameter("password2");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/spring","root","");

String sqlQuery="select count(*) from user where username = ?";
PreparedStatement psQuery=conn.prepareStatement(sqlQuery);
psQuery.setString(1,username);
ResultSet rs=psQuery.executeQuery();
rs.next();
int count=rs.getInt(1);
if(count>0){
	response.sendRedirect("registerFail.jsp");
	psQuery.close();
	conn.close();
	return;
}

String sql="insert into user values(null,?,?)";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1,username);
ps.setString(2,password);
ps.executeUpdate();
ps.close();
conn.close();

response.sendRedirect("registerSuccess.jsp");
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
