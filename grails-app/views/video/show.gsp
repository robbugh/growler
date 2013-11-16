
<%@ page import="org.growler.Video" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-video" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list video">
			
				<g:if test="${videoInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="video.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${videoInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.abstractText}">
				<li class="fieldcontain">
					<span id="abstractText-label" class="property-label"><g:message code="video.abstractText.label" default="Abstract Text" /></span>
					
						<span class="property-value" aria-labelledby="abstractText-label"><g:fieldValue bean="${videoInstance}" field="abstractText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.lengthMinutes}">
				<li class="fieldcontain">
					<span id="lengthMinutes-label" class="property-label"><g:message code="video.lengthMinutes.label" default="Length Minutes" /></span>
					
						<span class="property-value" aria-labelledby="lengthMinutes-label"><g:fieldValue bean="${videoInstance}" field="lengthMinutes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.videoFile}">
				<li class="fieldcontain">
					<span id="videoFile-label" class="property-label"><g:message code="video.videoFile.label" default="Video File" /></span>
					
						<span class="property-value" aria-labelledby="videoFile-label"><g:link controller="storageDesc" action="show" id="${videoInstance?.videoFile?.id}">${videoInstance?.videoFile?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="video.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${videoInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.lastUpdate}">
				<li class="fieldcontain">
					<span id="lastUpdate-label" class="property-label"><g:message code="video.lastUpdate.label" default="Last Update" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdate-label"><g:formatDate date="${videoInstance?.lastUpdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="video.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${videoInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="video.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${videoInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:videoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${videoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
