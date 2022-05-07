<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	officer_name    :<input type="text" name="name" value="${police_officers.getOfficerName() }" disabled/>
	<br/>
	
	officer_id：<input type="text" name="id" value="${police_officers.getOfficerID() }" disabled/>
	<br/>
	department	：<input type="text" name="department" value="${police_officers.getOfficerDepartment() }" disabled/>
	<br/>
	rank	：<input type="text" name="rank" value="${police_officers.getOfficerRank() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/PoliceOfficersServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${police_officers.getOfficerID() }"/>
	officer_name    :<input type="text" name="name" value="${police_officers.getOfficerName() }" />
	<span style="color: red; font-weight: 900">${errors.officer_name }</span>
	<br/>
	
	officer_id：<input type="text" name="id" value="${police_officers.getOfficerID() }" />
	<span style="color: red; font-weight: 900">${errors.officer_id }</span>
	<br/>
	department	：<input type="text" name="department" value="${police_officers.getOfficerDepartment() }" />
	<span style="color: red; font-weight: 900">${errors.department }</span>
	<br/>
	rank	：<input type="text" name="rank" value="${police_officers.getOfficerRank() }" />
	<span style="color: red; font-weight: 900">${errors.rank }</span>
	<br/>
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
