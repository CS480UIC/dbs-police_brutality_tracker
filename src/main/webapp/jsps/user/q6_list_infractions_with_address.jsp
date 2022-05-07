<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> User Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Infraction ID</th>
		<th>Date</th>
		<th>Officer Involved ID</th>
		<th>Force Type ID</th>
		<th>Victim ID</th>
		<th>Reported By User ID</th>
		<th>Location</th>
		<th>Description</th>
	</tr>
<c:forEach items="${UserList}" var="user">
	<tr>
		<td>${user.getInfractionID()}</td>
		<td>${user.getInfractionDate()}</td>
		<td>${user.getInfractionOfficer()}</td>
		<td>${user.getInfractionForce()}</td>
		<td>${user.getInfractionVictim()}</td>
		<td>${user.getInfractionReporter()}</td>
		<td>${user.getInfractionLocation()}</td>
		<td>${user.getInfractionDesc()}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
