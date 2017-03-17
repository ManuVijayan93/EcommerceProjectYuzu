<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>
		<center>Manage Category</center>
	</h2>
	<!-- <form action="manage_category_create" method="post">
		<input type="text" name="id"> <input type="text" name="name">
		<input type="text" name="description"> <input type="submit"
			value="Create">
	</form>
	-->
	<a href="manage_category_create" class="btn btn-primary" role="button">Add
		Category</a>



	<hr>

	<table border="2">

		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Description</td>
				<td>Action</td>
			</tr>
		</thead>
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>

				<td><a
					href="<c:url value="manage_categories_edit/${category.id}"/>">Edit
						<span class="glyphicon glyphicon-edit"></span>
				</a>| <a href="<c:url value="manage_categories_delete/${category.id}"/>">
						<span class="glyphicon glyphicon-trash"></span>delete
				</a></td>

			</tr>
		</c:forEach>

	</table>

	<br>
	<br>
	<%-- ${category.id} &nbsp;&nbsp; ${category.name}&nbsp;&nbsp;
	${category.description}&nbsp;&nbsp; --%>


</body>
</html>