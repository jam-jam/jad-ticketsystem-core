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

	<form:form commandName="ticketForm" action="sendToDb.htm">
	Title : <form:input path="title" />
		<br />
		Category : <form:select path="category">
			<form:option value="-">-- Make a selection --</form:option>
			<form:options items="${categoryList}" />
		</form:select>
		<br />
	Description : 	<form:textarea path="description" />
		<br />
		<input type="submit" value="Submit" />
		<br />
	</form:form>
</body>
</html>

