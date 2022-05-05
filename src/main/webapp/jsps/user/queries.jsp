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
    <h1>Welcome to the Demo</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the chicago police officers in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list all the male victims in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list all the addresses in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list how many infractions occured today in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list all the force types involved in 3 or more infractions in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list all the infractions with an address tied to them in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list all the infractions with a known victim in the table</a>&nbsp;&nbsp;
 	<br/>
 	<a href="<c:url value='/findAll'/>" target="body">Please list the amount of force types that appear twice or more in the table</a>&nbsp;&nbsp;
 	
    
  </body>
</html>
