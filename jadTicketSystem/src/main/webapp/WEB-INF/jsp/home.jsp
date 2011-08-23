<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%-- <img src="<spring:url value="resources/images/jad_banner.png" htmlEscape="true" />" align="right" style="position:relative;right:30px;"> --%>
<img src="resources/images/jad_banner.png" alt="JAD WS header"
	width="100%" />
	<div id="pageHeader">
<h2>
	<fmt:message key="welcome">
		<fmt:param value="jad Scrum Master"/>
	 </fmt:message>
</h2>
</div>

<div id="linkList">
	<div id="linkList2">
		<div id="lselect">
			<h3 class="select"><fmt:message key="menuTitle"/></h3>
				<ul>
					<li><a href="<spring:url value="/tickets/ticket/add.htm" htmlEscape="true" />"><fmt:message key="newTicket"/></a></li>
					<li><a href="<spring:url value="/accounts/account/add.htm" htmlEscape="true" />"><fmt:message key="newAccount"/></a></li>
					<li><a href="<spring:url value="/accounts/account/list.htm" htmlEscape="true" />"><fmt:message key="listAccount"/></a></li>
					<li><a href="<spring:url value="/categories/category/add.htm" htmlEscape="true" />"><fmt:message key="newCategory"/></a></li>
                </ul>
		</div>
	</div>
</div>
  <div id="supportingText">
  	<h3>Description : </h3>
  	<p>Web Application allowing customer's problems registering, solving assignment  and solution view.</p> 

	<h3>Goal :</h3> 
		<p>Pair programming / Agile philosophy through Scrum.</p>

	<h3>Technical Environment  :</h3> 
	<ul>
		<li>J2EE / AOP / Spring MVC 3.01 (Front Controller - Annotations - Validation) / (JPA) 	Hibernate 2.0 - Criteria Queries / Spring Security / I18N</li>
		<li>JSP - JSTL / HTML 5 / JSON</li>
		<li>Tomcat 6.0</li>
		<li>MySql 5.1  / Derby Db / HSQLDB 2.2</li>
		<li>STS 2.71</li>
		<li>Linux Mint 9.1</li>
  	</ul>
  </div>
<p>&nbsp;</p>
<p>&nbsp;</p>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>
