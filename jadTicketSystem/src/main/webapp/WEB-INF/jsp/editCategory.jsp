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
	<form:form commandName="catToEdit"  action="edit.htm?aido=${catToEdit.id}"> 
	<table>
	<tr>
	<td>
	Name : </td><td><form:input path="name" /></td>
	</tr>

<tr>
<td>
	Description : </td>	
	<td>
	<form:textarea path="description" cols="20" rows="5"	/>
	</td>
	</tr>
	<tr>
	<td>
	
	
	
	<input type="submit" value="Save changes"/>
	</td>
	</tr>
	</table>
	


	</form:form>
</body>
</html>
