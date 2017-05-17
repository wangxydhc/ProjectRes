<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css"
href="<s:url value="/styles.css"/>">
<html>
<head>
<title>验证数据</title>
</head>
<body>
<br/>
	<li>用bean建实例并赋参数</li>
	<s:bean name="org.xmh.demo.Dog" var="dog"><s:param name="name" value="'LittleBlack'"></s:param>
	<li>取参数：<s:property value="name"></s:property></s:bean>
	<li>取出存好的值<s:property value="name"></s:property>
	<li>拿出纸<s:property value="#dog.name"/>
	<li>include实验<s:set var="_include" value="'/page.html'"/><s:include value="/page.html"></s:include></li>
	<s:debug></s:debug>
	<s:fielderror fieldName="fielderror.test" theme="simple"></s:fielderror>
	<s:set var="para" value="#parameters.age[0]"></s:set>
	<s:if test="#para<0">wrong age</s:if>
	<s:elseif test="#parameters.age[0]<150">too young</s:elseif>
	<s:else>age=<s:property value="#parameters.age[0]"></s:property></s:else>
	<s:iterator value="{'adf','fd','f','wer','dsd'}" var="y"><s:property value="#y.toUpperCase()"/>|<s:property/> \</s:iterator>
</body>
</html>