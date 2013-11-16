
<%@ page import="org.growler.EventSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventSession.label', default: 'EventSession')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-eventSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-eventSession" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list eventSession">
			
				<g:if test="${eventSessionInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="eventSession.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${eventSessionInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="eventSession.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${eventSessionInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.presenters}">
				<li class="fieldcontain">
					<span id="presenters-label" class="property-label"><g:message code="eventSession.presenters.label" default="Presenters" /></span>
					
						<g:each in="${eventSessionInstance.presenters}" var="p">
						<span class="property-value" aria-labelledby="presenters-label"><g:link controller="speaker" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.presentation}">
				<li class="fieldcontain">
					<span id="presentation-label" class="property-label"><g:message code="eventSession.presentation.label" default="Presentation" /></span>
					
						<span class="property-value" aria-labelledby="presentation-label"><g:link controller="presentation" action="show" id="${eventSessionInstance?.presentation?.id}">${eventSessionInstance?.presentation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="eventSession.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${eventSessionInstance}" field="location"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.language}">
				<li class="fieldcontain">
					<span id="language-label" class="property-label"><g:message code="eventSession.language.label" default="Language" /></span>
					
						<span class="property-value" aria-labelledby="language-label"><g:fieldValue bean="${eventSessionInstance}" field="language"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.lastUpdate}">
				<li class="fieldcontain">
					<span id="lastUpdate-label" class="property-label"><g:message code="eventSession.lastUpdate.label" default="Last Update" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdate-label"><g:formatDate date="${eventSessionInstance?.lastUpdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="eventSession.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${eventSessionInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventSessionInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="eventSession.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${eventSessionInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventSessionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventSessionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
