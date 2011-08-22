<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <h:head>
        <title>Main menu</title>
    </h:head>
    <h:body>
<!--     	<h:graphicImage id="header" value="/resources/images/jad_banner.png"></h:graphicImage> -->
    	<img src="resources/images/jad_banner.png" alt="JAD WS header" width="100%"/>
    	<ul>
  			<li><a href="newTicket.htm">new Ticket</a><br/></li>
  			<li><a href="<spring:url value="/accounts/account/add.htm" htmlEscape="true" />">Add new user</a></li>
  			<li><a href="<spring:url value="/accounts/account/list.htm" htmlEscape="true" />">Accounts List</a></li>
		</ul>
    </h:body>
</html>

