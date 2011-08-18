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
	<form:form commandName="ticketToEdit" action="saveEditTicket.htm?aido=${ticketToEdit.id}"> 
	Title : <form:input path="title" />
		<br />
<!-- 	Category : <select> -->
			<option value="-">-- Make a selection --</option>
			<options items="${categoryList}" />
<!-- 		</select> -->
<!-- 		<br /> -->
	Description : 	
	<form:textarea path="description" cols="20" rows="5"	/>
	
	<input type="submit" value="submit"/>


	</form:form>
</body>
</html>
