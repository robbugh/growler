
<%@ page import="org.growler.Presentation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'presentation.label', default: 'Presentation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-presentation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-presentation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'presentation.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="abstractText" title="${message(code: 'presentation.abstractText.label', default: 'Abstract Text')}" />
					
						<g:sortableColumn property="summary" title="${message(code: 'presentation.summary.label', default: 'Summary')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'presentation.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="targetAudiance" title="${message(code: 'presentation.targetAudiance.label', default: 'Target Audiance')}" />
					
						<g:sortableColumn property="lengthMinutes" title="${message(code: 'presentation.lengthMinutes.label', default: 'Length Minutes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${presentationInstanceList}" status="i" var="presentationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${presentationInstance.id}">${fieldValue(bean: presentationInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: presentationInstance, field: "abstractText")}</td>
					
						<td>${fieldValue(bean: presentationInstance, field: "summary")}</td>
					
						<td>${fieldValue(bean: presentationInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: presentationInstance, field: "targetAudiance")}</td>
					
						<td>${fieldValue(bean: presentationInstance, field: "lengthMinutes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${presentationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
