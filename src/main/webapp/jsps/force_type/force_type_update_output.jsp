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
	force_id   :<input type="text" name="id" value="${force_type.getForceID() }" disabled/>
	<br/>
	force_used   :<input type="text" name="force_used" value="${force_type.getForceUsed()}" disabled/>
	<br/>
	description   :<input type="text" name="desc" value="${force_type.getForceDesc() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/ForceTypesServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${force_type.getForceID() }"/>
	force_id   :<input type="text" name="id" value="${force_type.getForceID() }" />
	<span style="color: red; font-weight: 900">${errors.force_id }</span>
	<br/>
	force_used   :<input type="text" name="force_used" value="${force_type.getForceUsed()}" />
	<span style="color: red; font-weight: 900">${errors.force_used }</span>
	<br/>
	description   :<input type="text" name="desc" value="${force_type.getForceDesc() }" />
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
