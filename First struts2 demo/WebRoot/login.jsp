 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <body>
  	path  /   request.getContextPath() : <%=path %> <br>
  	basePath : <%=basePath%> 
    <form action="login.action" method="get">
		用户名：<input type="text" name="user.username"><br>
		密码：<input type="password" name="user.password"><br>
		<input type="submit" value="login">
		</form>

  </body>
