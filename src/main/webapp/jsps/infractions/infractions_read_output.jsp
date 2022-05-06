<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Infractions Output</title>
    
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
  <h1>Read Infractions Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	infractions_id    :<input type="text" name="infractions_id" value="${infractions.infractions_id }" disabled/>
	<br/>
	date ：<input type="text" name="password" value="${infractions.date }" disabled/>
	<br/>
	officer_involved	：<input type="text" name="officer_involved" value="${infractions.officer_involved }" disabled/>
	<br/>
	force_type	：<input type="text" name="force_type" value="${infractions.force_type }" disabled/>
	<br/>
	victim	：<input type="text" name="victim" value="${infractions.victim }" disabled/>
	<br/>
	reported_by	：<input type="text" name="reported_by" value="${infractions.reported_by }" disabled/>
	<br/>
	location	：<input type="text" name="location" value="${infractions.location }" disabled/>
	<br/>
	description	：<input type="text" name="descrition" value="${infractions.description }" disabled/>
	<br/>
	count	：<input type="text" name="count" value="${infractions.count }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
