<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>

</head>
<body>
	<!--title, category, omschrijving,  submit button -->
	<form:form commandName="ticketToEdit"  action="edit.htm?aido=${ticketToEdit.id}"> 
	Title : <form:input path="title" />
		<br />
		Category : <form:select path="category.name">
			<form:option value="-">-- Make a selection --</form:option>
			<form:options items="${categoryList}"  />
			
		</form:select>
	Description : 	
	<form:textarea path="description" cols="20" rows="5"	/>
	
	<input type="submit" value="Save changes"/>
	


	</form:form>
</body>
</html>
