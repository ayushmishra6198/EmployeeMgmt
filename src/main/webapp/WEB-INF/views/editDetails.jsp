<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Edit Employee Details Form</a>
			</div>
		</div>
	</nav>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<br>
				<h4>
					<a href="" class="fadeIn fourth">Cancel</a>
				</h4>
			</div>

			<form action="updateDetails" method="post">
				<label>Employee Id&nbsp;&nbsp;</label><input type="number"
					name="empId" id="login" class="fadeIn second"
					value="${employee.employeeCode}" /> <label>First
					Name&nbsp;&nbsp;</label><input type="text" name="firstName" id="login"
					class="fadeIn second" value="${employee.firstName}"
					pattern=".{1,50}" required title="min 1 max 50 characters" /> <label>Last
					Name&nbsp;&nbsp;</label><input type="text" name="lastName" id="login"
					class="fadeIn second" value="${employee.lastName}"
					pattern=".{1,50}" required title="min 1 max 50 characters" /> <label>Employee
					Location&nbsp;&nbsp;</label><input type="text" name="empLocation"
					id="login" class="fadeIn second" value="${employee.location}"
					pattern=".{5,500}" required title="min 5 max 500 characters" /> <label>Employee
					email&nbsp;&nbsp;</label><input type="email" name="empEmail" id="login"
					class="fadeIn second" value="${employee.email}" pattern=".{10,100}"
					required title="min 10 max 100 characters" /> <label>Employee
					Date(dd-mm-yyyy)&nbsp;&nbsp;</label><input type="text" name="empDOB" id="login"
					class="fadeIn second" value="${employee.dob}" /> <br> <br>
				<input type="submit" class="fadeIn fourth" value="Update Details" />
				<a href="delete?id=${employee.employeeCode}" id="asc"
					class="fadeIn fourth">Delete Record</a> <br>
			</form>

		</div>
	</div>

</body>
</html>