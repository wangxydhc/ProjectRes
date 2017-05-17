<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>验证数据</title>
	</head>
	<body>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="struts2/validate.action" theme="simple">
			输入内容：
			<s:textfield name="msg" />
			<s:fielderror>
				<s:param>msg.hello</s:param>
			</s:fielderror>
			<br/>
			<s:submit value="登 录" />
			<s:reset value="重填" />
		</s:form>
	</body>
</html>