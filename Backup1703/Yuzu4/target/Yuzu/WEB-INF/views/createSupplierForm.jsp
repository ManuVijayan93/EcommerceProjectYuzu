<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:url value="/manage_supplier_create" var="url"></c:url>

	<form:form method="post" action="${url}" commandName="createSupplierObj" >
		<table>
			<tr>
				<td><form:label path="id">Supplier Id</form:label></td>
				<td><form:input path="id" disabled="false" /> <form:hidden
						path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Supplier Name</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="address">Supplier Address</form:label></td>
				<td><form:input path="address"></form:input></td>
			</tr>
			
			
			<tr>
				<td colspan="2"><input type="submit" value="Add Supplier"></td>
			</tr>
		</table>
	</form:form>
	
	<%@include file="footer.jsp"%>

</body>
</html>