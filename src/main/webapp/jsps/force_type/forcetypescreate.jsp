<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Entity1 Create</title>
    
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
  <h1>Create Force</h1>
<form action="<c:url value='/ForceTypesServletCreate'/>" method="post">
	force_id   :<input type="text" name="id" value="${force.getForceID() }" />
	<span style="color: red; font-weight: 900">${errors.force_id }</span>
	<br/>
	force_used   :<input type="text" name="force_used" value="${force.getForceUsed()}" />
	<span style="color: red; font-weight: 900">${errors.force_used }</span>
	<br/>
	description   :<input type="text" name="desc" value="${force.getForceDesc() }" />
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Create Force_Type"/>
</form>
  </body>
</html>
