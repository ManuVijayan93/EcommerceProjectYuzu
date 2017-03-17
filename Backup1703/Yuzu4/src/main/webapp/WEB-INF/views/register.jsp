<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This is Registration page


	<form:form action="" method="" commandName="">

		<table>
			<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" /></td>

			</tr>
			<tr>
				<td><form:label path="name">User Name</form:label></td>
				<td><form:input path="name" /></td>

			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>

			</tr>
			<tr>
				<td><form:label path="mail">Email</form:label></td>
				<td><form:input path="mail" /></td>

			</tr>
			<tr>
				<td><form:label path="contact">Phone</form:label></td>
				<td><form:input path="contact" /></td>

			</tr>
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:input path="role" /></td>

			</tr>



		</table>




	</form:form>
</body>
</html>