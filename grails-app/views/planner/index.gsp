
<%@ page import="org.growler.Planner" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planner.label', default: 'Planner')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-planner" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-planner" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'planner.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="middleName" title="${message(code: 'planner.middleName.label', default: 'Middle Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'planner.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'planner.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'planner.lastUpdate.label', default: 'Last Update')}" />
					
						<g:sortableColumn property="lastUpdatedBy" title="${message(code: 'planner.lastUpdatedBy.label', default: 'Last Updated By')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${plannerInstanceList}" status="i" var="plannerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${plannerInstance.id}">${fieldValue(bean: plannerInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: plannerInstance, field: "middleName")}</td>
					
						<td>${fieldValue(bean: plannerInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: plannerInstance, field: "email")}</td>
					
						<td><g:formatDate date="${plannerInstance.lastUpdate}" /></td>
					
						<td>${fieldValue(bean: plannerInstance, field: "lastUpdatedBy")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${plannerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
