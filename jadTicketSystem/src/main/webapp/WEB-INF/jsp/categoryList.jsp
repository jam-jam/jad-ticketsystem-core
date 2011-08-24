<?xml version='1.0' encoding='UTF-8' ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">
<head>
<title>Ticket List</title>
<c:url var="addUrl" value="ticketlist.html" />
</head>
<body>
<table style="border: 1px solid; width: 500px; text-align: center">

	<thead style="background: #fcf">
		<tr>
			<th>Title</th>
			<th>Submit Date</th>

			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categoryList}" var="cat">

			<tr>
				<td><c:out value="${cat.name}" />
				</td>
				<td><c:out value="${cat.description}" />
				</td>

				<td><a href="edit.htm?aidi=${cat.id}">Edit</a>
				</td>
				<td><a href="delete.htm?aidi=${cat.id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
				</td>
				<td><a href="add.htm">Add</a>
				</td>
			</tr>
		</c:forEach>
</tbody>
</table>
<c:url var="homeUrl" value="/home.htm" />
<a href="${homeUrl}">Go Home</a>
<c:if test="${empty categoryList}">
	There are currently no accounts in the list. <a href="add.htm">Add</a> a category.
</c:if>

</body>
</html>

