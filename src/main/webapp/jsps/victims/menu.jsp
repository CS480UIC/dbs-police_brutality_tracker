<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>CRUD operations for Entity1 </h1>
    <br>
	<a href="<c:url value='/jsps/victims/victimscreate.jsp'/>" target="_parent">Create victims</a> |&nbsp; 
	<a href="<c:url value='/jsps/victims/victimsread.jsp'/>" target="_parent">Read victims</a> |&nbsp;
	<a href="<c:url value='/jsps/victims/victimsupdate.jsp'/>" target="_parent">Update victims</a> |&nbsp;	 
	<a href="<c:url value='/jsps/victims/victimsdelete.jsp'/>" target="_parent">Delete victims</a>	
	    
  </body>
</html>
