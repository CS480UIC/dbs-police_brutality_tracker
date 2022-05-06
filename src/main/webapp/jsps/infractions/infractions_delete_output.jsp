<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Infraction</title>
    
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
  <h1>Delete Infraction</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/InfractionsServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id" value="${infractions.username }"/>
	infraction_id   :<input type="text" name="id" value="${infractions.infraction_id }" disabled/>
	<br/>
	date   :<input type="text" name="date" value="${infractions.date }" disabled/>
	<br/>
	officer_involved   :<input type="text" name="officer" value="${infractions.officer_involved }" disabled/>
	<br/>
	force_type   :<input type="text" name="force" value="${infractions.force_type }" disabled/>
	<br/>
	victim   :<input type="text" name="victim" value="${infractions.victim }" disabled/>
	<br/>
	reported_by   :<input type="text" name="reporter" value="${infractions.reported_by }" disabled/>
	<br/>
	location   :<input type="text" name="location" value="${infractions.location }" disabled/>
	<br/>
	description   :<input type="text" name="desc" value="${infractions.description }" disabled/>
	<br/>
	<br/>
	<input type="submit" value="Delete Infraction"/>
</form>

</body>
</html>
