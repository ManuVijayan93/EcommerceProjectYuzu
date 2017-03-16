<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<nav class="navbar navbar-default">

		<div class="container-fluid">

			<ul class="nav navbar-nav ">

				<li><a href="<c:url value="home"/>">Home</a></li>

				<li><a href="<c:url value="aboutUs"/>">About us</a></li>

				<li><a href="<c:url value="Login"/>">Login</a></li>
				<li><a href="<c:url value="register"/>">Register</a></li>

			</ul>

		</div>





	</nav>





</body>
</html>