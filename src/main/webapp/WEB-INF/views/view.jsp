<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Records</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><%=session.getAttribute("userInfo")%></a>
		</div>
		<a href="logout" class="navbar-brand" style="float: right;">
			Logout </a>
	</nav>

	<h4>Employee Management Tool</h4>
	<a href="addNewEmployee">Add new Details</a>
	<a href="downloadData">Download Details</a>
	<table style="width: 100%">

		<tr>
			<th>Employee Code</th>
			<th>Employee Name</th>
			<th>Employee Location</th>
			<th>Employee Email</th>
			<th>Employee dob</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${employees}" var="emp">
			<tr>
				<td>${emp.employeeCode}</td>
				<td>${emp.firstName} ${emp.lastName}</td>
				<td>${emp.location}</td>
				<td>${emp.email}</td>
				<td>${emp.dob}</td>
				<%-- <td><c:out value="${emp.employeeCode}" /></td>
				<td><c:out value="${emp.firstName} ${emp.lastName}" /></td>
				<td><c:out value="${emp.location}" /></td>
				<td><c:out value="${emp.email}" /></td>
				<td><c:out value="${emp.dob}" /></td> --%>
				<td>
					<form action="editDetails" method="get">
						<input type="hidden" id="empId" name="empId"
							value=<c:out value="${emp.employeeCode}" />> <input
							type="submit" value="Edit Details">
					</form>
				</td>
				<td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>