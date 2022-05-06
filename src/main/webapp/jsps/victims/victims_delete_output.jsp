<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Victim</title>
    
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
  <h1>Delete Victim</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/VictimServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id" value="${victim.victim_id }"/>
	victim_name   :<input type="text" name="name" value="${victim.victim_name }" disabled/>
	<br/>
	
	victim_id：<input type="text" name="id" value="${victim.victim_id }" disabled/>
	<br/>
	ethnicity	：<input type="text" name="ethnicity" value="${victim.ethnicity }" disabled/>
	<br/>
	gender	：<input type="text" name="gender" value="${victim.gender }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${victim.address }" disabled/>
	<br/>
	<input type="submit" value="Delete Victim"/>
</form>

</body>
</html>
