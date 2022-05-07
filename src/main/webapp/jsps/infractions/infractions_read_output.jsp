<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Entity Output</title>
    
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
  <h1>Read Entity Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	infraction_id   :<input type="text" name="id" value="${infractions.getInfractionID()}" disabled/>
	<br/>
	date   :<input type="text" name="date" value="${infractions.getInfractionDate() }" disabled/>
	<br/>
	officer_involved   :<input type="text" name="officer" value="${infractions.getInfractionOfficer() }" disabled/>
	<br/>
	force_type   :<input type="text" name="force" value="${infractions.getInfractionForce() }" disabled/>
	<br/>
	victim   :<input type="text" name="victim" value="${infractions.getInfractionVictim() }" disabled/>
	<br/>
	reported_by   :<input type="text" name="reporter" value="${infractions.getInfractionReporter() }" disabled/>
	<br/>
	location   :<input type="text" name="location" value="${infractions.getInfractionLocation() }" disabled/>
	<br/>
	description   :<input type="text" name="desc" value="${infractions.getInfractionDesc() }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
