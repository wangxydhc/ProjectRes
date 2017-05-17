<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  
  
  
  <s:iterator value="res" id="list">
 <td> 	
 <s:form action="ConfirmWord" method="post">
 		<input type="hidden" name="wordId" value="<s:property value='#list.getId()'/>"/>
 		  单词：<s:property value="#list.getWord()" />
 		  <br/>
  	                释义：<s:property value="#list.getParaphrase()"/>
  	    <s:radio name="handle" list="{'完全不会','有点儿印象','基本掌握','太简单了'}" value="{}"/>
  	<!-- <s:checkboxlist name="list" list="{'完全不会','有点儿印象','基本掌握','太简单了'}" value="{}"></s:checkboxlist> -->
  <!--  <s:select name="user.sex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select>-->	
  	<br/>
  	<br/>
  	<s:submit value="提  交"/>
  	</s:form>
  	</td>
  	<td/>
  </s:iterator>
  
  
<!--<s:property value="res.{word}"/>   -->
<s:debug></s:debug>
  </body>
</html>
