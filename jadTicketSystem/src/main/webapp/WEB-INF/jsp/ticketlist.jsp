<?xml version='1.0' encoding='UTF-8' ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <title>Ticket List</title>
   <c:url var="addUrl" value="ticketlist.html" />
   </head>
<table style="border: 1px solid; width: 500px; text-align:center">

<thead style="background:#fcf">
<tr>
<th>Title</th>
<th>Submit Date</th>

<th colspan="3"></th>
</tr>
</thead>
<tbody>
<c:forEach items="${tickets}" var="ticket">
<%-- <c:url var="editUrl" value="/accounts/account/edit.htm?id=${tickets.id}" /> --%>
<%-- <c:url var="deleteUrl" value="/accounts/account/delete.htm?id=${tickets.id}" /> --%>
<tr>
<td><c:out value="${ticket.title}" /></td>
<td><c:out value="${ticket.submitDate}" /></td>

<%-- <td><a href="${editUrl}">Edit</a></td> --%>
<%-- <td><a href="${deleteUrl}">Delete</a></td> --%>
<%-- <td><a href="${addUrl}">Add</a></td> --%>
<td><a href="edit.htm?aidi=${ticket.id}">Edit</a></td>
<td><a href="delete.htm?aidi=${ticket.id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
<td><a href="add.htm">Add</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<c:if test="${empty tickets}">
	There are currently no accounts in the list. <a href="add.htm">Add</a> a ticket.
</c:if> 
    </body>
</html>

