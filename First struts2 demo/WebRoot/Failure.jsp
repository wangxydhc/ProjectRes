<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<body>
		登录失败，错误的用户名：<s:property value="user.username"/><br>
		<a href="<%=request.getContextPath()%>/login.jsp">返回</a>
	this is : <%=request.getContextPath()%> 
	</body>
</html>
