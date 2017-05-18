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
  
  <script>
var xmlhttp;
function loadXMLDoc(url,cfunc)
{
if (window.XMLHttpRequest)
  {// IE7+, Firefox, Chrome, Opera, Safari 代码
  xmlhttp=new XMLHttpRequest();
  }
else
  {// IE6, IE5 代码
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=cfunc;
xmlhttp.open("GET",url,true);
xmlhttp.send();
}
function myFunction()
{
	loadXMLDoc("index.jsp",function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
		}
	});
}
</script>


<div id="myDiv"><h2>使用 AJAX 修改文本内容</h2></div>
<button type="button" onclick="myFunction()">修改内容</button>

  <form action="">  
    <h1>下面显示的是自定义标签中的内容</h1>  
    <br><br>      
    <br>  
    <span style="background-color: rgb(255, 255, 255);"><!-- 第二种：jsp include指令 --></span>  
    <div>  
    	first
        <%@ include file="index.jsp" %>  
    </div>  
    
    
    <span style="background-color: rgb(255, 255, 255);"><!-- 第三种：jsp include动作 --></span>  
    
    second
    <div>  
        <jsp:include   page="index.jsp" flush="true"/>  
    </div>  
  
    </form>  


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
