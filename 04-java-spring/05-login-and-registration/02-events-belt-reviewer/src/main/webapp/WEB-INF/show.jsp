<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Event</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="card">
		<h1>Show Event</h1>
		<nav>
			<h3><a href="/dashboard">Home</a></h3>
			<h3><a href="/link2">Link2</a></h3>
		</nav>
	</div>
	<div class="card">
		<h1>${event.name}</h1>
		<p>Hosted By: ${event.planner.firstName}</p>
		<p>Date: <fmt:formatDate type="date" value="${event.eventDate}"/></p>
		<p>Location: ${event.city} ${event.state}</p>
		<p>People attending this event: ${event.attendees.size()}</p>
	</div>
	<div class="card">
		<table class = "table table-dark table-hover event-table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${event.attendees}" var="attendee" varStatus="loop">
					<td>${attendee.firstName} ${attendee.lastName}</td>
					<td>${attendee.city} ${attendee.state}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<h2>Message Wall</h2>
		<c:choose>
			<c:when test="${event.messages.size() == 0 }">
				<p>Be the first to make a comment!</p>
			</c:when>
			<c:otherwise>
				<c:forEach items="${event.messages}" var="message" varStatus="loop">
				<p>
					<span>
						${message.author.firstName} ${message.author.lastName}:
					</span>
					${message.comment}
				</p>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
		<form action="/events/${event.id}/comment" method="post">
			<div class="form-group">
				<label for="comment">Add Comment</label>
				<span>${error}</span>
				<textarea name="comment" class="form-control"></textarea>
				<button class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>