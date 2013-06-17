<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%
	Exception ex=(Exception)request.getAttribute("exception");
	StackTraceElement element=ex.getStackTrace()[0];
	ex.printStackTrace();
%>
<html>
<head>
<title>港澳</title>
</head>
<body>
<center>数据库异常！</center>
</body>
</html>