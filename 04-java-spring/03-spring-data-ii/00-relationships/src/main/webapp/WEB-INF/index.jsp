<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMV</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Welcome to the DMV</h1>
	<hr>
	<table class="table table-dark">
	<thead>
	<td>ID</td>
	<td>First Name</td>
	<td>Last Name</td>
	<td>License</td>
	</thead>
	<tbody>
	<c:forEach items="${persons}" var="person">
	<tr>
	<td>${person.id}</td>
	<td><a href="/${person.id}/">{person.id}</a></td>
	<td>${person.firstName}</td>
	<td>${person.lastName}</td>
	</c:forEach>
	</tbody>
	</table>
</div>
</body>
</html>