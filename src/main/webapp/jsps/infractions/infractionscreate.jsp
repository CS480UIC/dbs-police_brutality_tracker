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
<form action="<c:url value='/InfractionsServletCreate'/>" method="post">
	infraction_id    :<input type="text" name="infraction_id" value="${form.infraction_id }"/>
	<span style="color: red; font-weight: 900">${errors.infraction_id }</span>
	<br/>
	date：<input type="text" name="date" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	officer_involved：<input type="text" name="officer_involved" value="${form.officer_involved }"/>
	<span style="color: red; font-weight: 900">${errors.officer_involved }</span>
	<br/>
	force_type：<input type="text" name="force_type" value="${form.force_type }"/>
	<span style="color: red; font-weight: 900">${errors.force_type }</span>
	<br/>
	victim：<input type="text" name="victim" value="${form.victim }"/>
	<span style="color: red; font-weight: 900">${errors.victim }</span>
	<br/>
	reported_by：<input type="text" name="reported_by" value="${form.reported_by }"/>
	<span style="color: red; font-weight: 900">${errors.reported_by }</span>
	<br/>
	location：<input type="text" name="location" value="${form.location }"/>
	<span style="color: red; font-weight: 900">${errors.location }</span>
	<br/>
	description：<input type="text" name="description" value="${form.description }"/>
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Create Force_Type"/>
</form>
  </body>
</html>
