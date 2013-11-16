
<%@ page import="org.growler.Speaker" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'speaker.label', default: 'Speaker')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-speaker" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-speaker" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'speaker.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="middleName" title="${message(code: 'speaker.middleName.label', default: 'Middle Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'speaker.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'speaker.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'speaker.lastUpdate.label', default: 'Last Update')}" />
					
						<g:sortableColumn property="lastUpdatedBy" title="${message(code: 'speaker.lastUpdatedBy.label', default: 'Last Updated By')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${speakerInstanceList}" status="i" var="speakerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${speakerInstance.id}">${fieldValue(bean: speakerInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: speakerInstance, field: "middleName")}</td>
					
						<td>${fieldValue(bean: speakerInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: speakerInstance, field: "email")}</td>
					
						<td><g:formatDate date="${speakerInstance.lastUpdate}" /></td>
					
						<td>${fieldValue(bean: speakerInstance, field: "lastUpdatedBy")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${speakerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
