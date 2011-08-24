<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>New Ticket</title>
</head>
<body>
	<!--title, category, omschrijving,  submit button -->
	<table>
		<form:form commandName="ticketForm" action="add.htm" method="POST">
		<tr>
		<td>
	Title : </td><td> <form:input path="title" />
			
			</td>
			</tr>
			<tr>
			<td>
		Category :</td><td> <form:select path="category.name">
				<form:option value="-">-- Make a selection --</form:option>
				<form:options items="${categoryList}" />

			</form:select>
			</td>
			</tr>
			<tr>
			<td>
	Description :</td><td><form:textarea path="description" />
			</td>
			</tr>
			<tr>
			<td>
			<input type="submit" value="Submit" />
			</td>
			</tr>
		</form:form>
	</table>
</body>
</html>

