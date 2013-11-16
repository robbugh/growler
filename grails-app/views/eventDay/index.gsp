
<%@ page import="org.growler.EventDay" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventDay.label', default: 'EventDay')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventDay" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventDay" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="date" title="${message(code: 'eventDay.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'eventDay.lastUpdate.label', default: 'Last Update')}" />
					
						<g:sortableColumn property="lastUpdatedBy" title="${message(code: 'eventDay.lastUpdatedBy.label', default: 'Last Updated By')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'eventDay.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventDayInstanceList}" status="i" var="eventDayInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventDayInstance.id}">${fieldValue(bean: eventDayInstance, field: "date")}</g:link></td>
					
						<td><g:formatDate date="${eventDayInstance.lastUpdate}" /></td>
					
						<td>${fieldValue(bean: eventDayInstance, field: "lastUpdatedBy")}</td>
					
						<td><g:formatDate date="${eventDayInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventDayInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
