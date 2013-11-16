
<%@ page import="org.growler.StorageDesc" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'storageDesc.label', default: 'StorageDesc')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-storageDesc" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-storageDesc" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'storageDesc.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="path" title="${message(code: 'storageDesc.path.label', default: 'Path')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'storageDesc.lastUpdate.label', default: 'Last Update')}" />
					
						<g:sortableColumn property="lastUpdatedBy" title="${message(code: 'storageDesc.lastUpdatedBy.label', default: 'Last Updated By')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'storageDesc.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${storageDescInstanceList}" status="i" var="storageDescInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${storageDescInstance.id}">${fieldValue(bean: storageDescInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: storageDescInstance, field: "path")}</td>
					
						<td><g:formatDate date="${storageDescInstance.lastUpdate}" /></td>
					
						<td>${fieldValue(bean: storageDescInstance, field: "lastUpdatedBy")}</td>
					
						<td><g:formatDate date="${storageDescInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${storageDescInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
