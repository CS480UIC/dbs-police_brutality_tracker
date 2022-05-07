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
	victim_name   :<input type="text" name="name" value="${victims.getVictimName() }" disabled/>
	<br/>
	
	victim_id：<input type="text" name="id" value="${victims.getVictimID() }" disabled/>
	<br/>
	ethnicity	：<input type="text" name="ethnicity" value="${victims.getVictimEthnicity() }" disabled/>
	<br/>
	gender	：<input type="text" name="gender" value="${victims.getVictimGender() }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${victims.getVictimAddress() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/VictimsServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${victims.getVictimName()}"/>
	victim_name   :<input type="text" name="name" value="${victims.getVictimName() }" />
	<span style="color: red; font-weight: 900">${errors.victim_name }</span>
	<br/>
	
	victim_id：<input type="text" name="id" value="${victims.getVictimID() }" />
	<span style="color: red; font-weight: 900">${errors.victim_id }</span>
	<br/>
	ethnicity	：<input type="text" name="ethnicity" value="${victims.getVictimEthnicity() }" />
	<span style="color: red; font-weight: 900">${errors.ethnicity }</span>
	<br/>
	gender	：<input type="text" name="gender" value="${victims.getVictimGender() }" />
	<span style="color: red; font-weight: 900">${errors.gender }</span>
	<br/>
	address	：<input type="text" name="address" value="${victims.getVictimAddress() }" />
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
