<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Details</h1>
	<h1>${ person.firstName } ${ person.lastName }</h1>
	<p><strong>License Number</strong> ${ person.license.getNumberAsString() }</p>
	<p><strong>Expiration Date</strong> ${ person.license.getExpirationDateFormatted() }</p>
</div>
</body>
</html>