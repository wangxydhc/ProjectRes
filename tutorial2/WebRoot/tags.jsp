<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css"
href="<s:url value="/styles.css"/>">
<html>
<head>
<title>��֤����</title>
</head>
<body>
<br/>
	<li>��bean��ʵ����������</li>
	<s:bean name="org.xmh.demo.Dog" var="dog"><s:param name="name" value="'LittleBlack'"></s:param>
	<li>ȡ������<s:property value="name"></s:property></s:bean>
	<li>ȡ����õ�ֵ<s:property value="name"></s:property>
	<li>�ó�ֽ<s:property value="#dog.name"/>
	<li>includeʵ��<s:set var="_include" value="'/page.html'"/><s:include value="/page.html"></s:include></li>
	<s:debug></s:debug>
	<s:fielderror fieldName="fielderror.test" theme="simple"></s:fielderror>
	<s:set var="para" value="#parameters.age[0]"></s:set>
	<s:if test="#para<0">wrong age</s:if>
	<s:elseif test="#parameters.age[0]<150">too young</s:elseif>
	<s:else>age=<s:property value="#parameters.age[0]"></s:property></s:else>
	<s:iterator value="{'adf','fd','f','wer','dsd'}" var="y"><s:property value="#y.toUpperCase()"/>|<s:property/> \</s:iterator>
</body>
</html>