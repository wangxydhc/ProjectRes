<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>��֤����</title>
	</head>
	<body>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="struts2/validate.action" theme="simple">
			�������ݣ�
			<s:textfield name="msg" />
			<s:fielderror>
				<s:param>msg.hello</s:param>
			</s:fielderror>
			<br/>
			<s:submit value="�� ¼" />
			<s:reset value="����" />
		</s:form>
	</body>
</html>