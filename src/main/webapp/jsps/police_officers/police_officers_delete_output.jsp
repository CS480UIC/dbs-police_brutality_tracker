<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete police_officers</title>
    
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
  <h1>Delete police_officers</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PoliceOfficersServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id" value="${police_officers.getOfficerID() }"/>
	officer_name    :<input type="text" name="name" value="${police_officers.getOfficerName() }" disabled/>
	<br/>
	
	officer_id：<input type="text" name="id" value="${police_officers.getOfficerID() }" disabled/>
	<br/>
	department	：<input type="text" name="department" value="${police_officers.getOfficerDepartment() }" disabled/>
	<br/>
	rank	：<input type="text" name="rank" value="${police_officers.getOfficerRank() }" disabled/>
	<br/>
	<input type="submit" value="Delete police_officers"/>
</form>

</body>
</html>
