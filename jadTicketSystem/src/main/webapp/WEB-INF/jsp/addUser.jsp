<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
</head>
<body>

<h1>Create New User</h1>

<form:form commandName="userAttribute" method="POST" action="add.htm">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input path="firstName"/></td>
		</tr>

		<tr>
			<td><form:label path="lastName">Last Name:</form:label></td>
			<td><form:input path="lastName"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userName">User Name:</form:label></td>
			<td><form:input path="userName"/></td>
		</tr>
		
		<tr>
			<td><form:label path="password">Password:</form:label></td>
			<td><form:password path="password"/></td>
		</tr>
		
<!-- 		<tr> -->
<%-- 			<td><form:label path="confirm">Confirm Password:</form:label></td> --%>
<%-- 			<td><form:password path="confirm"/></td> --%>
<!-- 		</tr> -->
		
		<tr>
			<td><form:label path="email">Email:</form:label></td>
			<td><form:input path="email"/></td>
		</tr>
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>