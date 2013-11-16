
<%@ page import="org.growler.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list event">
			
				<g:if test="${eventInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="event.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${eventInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="event.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:link controller="address" action="show" id="${eventInstance?.location?.id}">${eventInstance?.location?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="event.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${eventInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="event.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${eventInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.eventDays}">
				<li class="fieldcontain">
					<span id="eventDays-label" class="property-label"><g:message code="event.eventDays.label" default="Event Days" /></span>
					
						<g:each in="${eventInstance.eventDays}" var="e">
						<span class="property-value" aria-labelledby="eventDays-label"><g:link controller="eventDay" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.hashTags}">
				<li class="fieldcontain">
					<span id="hashTags-label" class="property-label"><g:message code="event.hashTags.label" default="Hash Tags" /></span>
					
						<span class="property-value" aria-labelledby="hashTags-label"><g:fieldValue bean="${eventInstance}" field="hashTags"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.twitterId}">
				<li class="fieldcontain">
					<span id="twitterId-label" class="property-label"><g:message code="event.twitterId.label" default="Twitter Id" /></span>
					
						<span class="property-value" aria-labelledby="twitterId-label"><g:fieldValue bean="${eventInstance}" field="twitterId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.lastUpdate}">
				<li class="fieldcontain">
					<span id="lastUpdate-label" class="property-label"><g:message code="event.lastUpdate.label" default="Last Update" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdate-label"><g:formatDate date="${eventInstance?.lastUpdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="event.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${eventInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="event.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${eventInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
