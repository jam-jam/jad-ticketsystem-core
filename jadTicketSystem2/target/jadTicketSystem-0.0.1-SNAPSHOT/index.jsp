<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <h:head>
        <title>Application index paging</title>
    </h:head>
    <h:body>
       Ticket index
        <h:form>
            <h:commandLink id="user" value="User" action="user"/><br/><br/>
            <h:commandLink id="employee" value="Employee" action="#{ticketManagementBean.genList}"/><br/><br/>
            <h:commandLink id="dashboard" value="Dashboard" action="dashboard"/><br/><br/>
            <h:commandLink id="category" value="Category" action="category"/><br/><br/>
            <h:commandLink id="adminUser" action="userList" value="User List"/><br/><br/>
        </h:form>
    </h:body>
</html>

