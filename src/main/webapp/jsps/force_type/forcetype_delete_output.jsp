<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Force</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Force</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ForceServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id" value="${force.id }"/>
	force_id   :<input type="text" name="id" value="${force.id }" disabled/>
	<br/>
	force_used   :<input type="text" name="type" value="${force.used }" disabled/>
	<br/>
	description   :<input type="text" name="desc" value="${force.description }" disabled/>
	<br/>
	<br/>
	<input type="submit" value="Delete Entity1"/>
</form>

</body>
</html>
