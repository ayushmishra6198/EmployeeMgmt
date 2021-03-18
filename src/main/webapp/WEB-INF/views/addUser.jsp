<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee detail</title>
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
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><%=session.getAttribute("userinfo")%></a>
		</div>
		<a href="logout" class="navbar-brand" style="float: right;">
			Logout </a>
	</nav>

	<h4>Add Employee Details Form</h4>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<br>
				<h4>
					<a href="" class="fadeIn fourth">Cancel</a>
				</h4>
				<h5>${userinform}</h5>
			</div>

			<form action="addEmployee" method="post">
				<input type="text" name="empId" id="login" class="fadeIn second"
					placeholder="Employee ID" />
					 <input type="text" name="firstName"
					id="login" class="fadeIn second" placeholder="Employee Name"
					pattern=".{1,100}" required title="min 1 max 100 characters" /> 
					<input type="text" name="lastName"
					id="login" class="fadeIn second" placeholder="Employee Name"
					pattern=".{1,100}" required title="min 1 max 100 characters" /> 
					<input
					type="text" name="empLocation" id="login" class="fadeIn second"
					placeholder="Employee Location" pattern=".{5,500}" required
					title="min 5 max 500 characters" /> 
					<input type="email"
					name="empEmail" id="login" class="fadeIn second"
					placeholder="Employee Email" pattern=".{10,100}" required
					title="min 10 max 100 characters" />
					 <input type="text"
					name="empDOB" id="login" class="fadeIn second"
					placeholder="Employee DOB(dd-mm-yyyy)" /> <br>
					 <input type="submit"
					class="fadeIn fourth" value="Add Details" /> <br>
			</form>
		</div>
	</div>


</body>
</html>