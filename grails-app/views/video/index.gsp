
<%@ page import="org.growler.Video" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-video" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'video.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="abstractText" title="${message(code: 'video.abstractText.label', default: 'Abstract Text')}" />
					
						<g:sortableColumn property="lengthMinutes" title="${message(code: 'video.lengthMinutes.label', default: 'Length Minutes')}" />
					
						<th><g:message code="video.videoFile.label" default="Video File" /></th>
					
						<g:sortableColumn property="url" title="${message(code: 'video.url.label', default: 'Url')}" />
					
						<g:sortableColumn property="lastUpdate" title="${message(code: 'video.lastUpdate.label', default: 'Last Update')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${videoInstanceList}" status="i" var="videoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${videoInstance.id}">${fieldValue(bean: videoInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: videoInstance, field: "abstractText")}</td>
					
						<td>${fieldValue(bean: videoInstance, field: "lengthMinutes")}</td>
					
						<td>${fieldValue(bean: videoInstance, field: "videoFile")}</td>
					
						<td>${fieldValue(bean: videoInstance, field: "url")}</td>
					
						<td><g:formatDate date="${videoInstance.lastUpdate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${videoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
