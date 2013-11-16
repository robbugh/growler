
<%@ page import="org.growler.EventSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventSession.label', default: 'EventSession')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventSession" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'eventSession.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'eventSession.date.label', default: 'Date')}" />
					
						<th><g:message code="eventSession.presentation.label" default="Presentation" /></th>
					
						<g:sortableColumn property="location" title="${message(code: 'eventSession.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="language" title="${message(code: 'eventSession.language.label', default: 'Language')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'eventSession.lastUpdate.label', default: 'Last Update')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventSessionInstanceList}" status="i" var="eventSessionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventSessionInstance.id}">${fieldValue(bean: eventSessionInstance, field: "title")}</g:link></td>
					
						<td><g:formatDate date="${eventSessionInstance.date}" /></td>
					
						<td>${fieldValue(bean: eventSessionInstance, field: "presentation")}</td>
					
						<td>${fieldValue(bean: eventSessionInstance, field: "location")}</td>
					
						<td>${fieldValue(bean: eventSessionInstance, field: "language")}</td>
					
						<td><g:formatDate date="${eventSessionInstance.lastUpdate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventSessionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
