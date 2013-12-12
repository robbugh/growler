
<%@ page import="org.growler.Presentation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'presentation.label', default: 'Presentation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-presentation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-presentation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list presentation">
			
				<g:if test="${presentationInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="presentation.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${presentationInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.abstractText}">
				<li class="fieldcontain">
					<span id="abstractText-label" class="property-label"><g:message code="presentation.abstractText.label" default="Abstract Text" /></span>
					
						<span class="property-value" aria-labelledby="abstractText-label"><g:fieldValue bean="${presentationInstance}" field="abstractText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.summary}">
				<li class="fieldcontain">
					<span id="summary-label" class="property-label"><g:message code="presentation.summary.label" default="Summary" /></span>
					
						<span class="property-value" aria-labelledby="summary-label"><g:fieldValue bean="${presentationInstance}" field="summary"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.presentationType}">
				<li class="fieldcontain">
					<span id="presentationType-label" class="property-label"><g:message code="presentation.presentationType.label" default="Presentation Type" /></span>
					
						<span class="property-value" aria-labelledby="presentationType-label"><g:fieldValue bean="${presentationInstance}" field="presentationType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.targetAudiance}">
				<li class="fieldcontain">
					<span id="targetAudiance-label" class="property-label"><g:message code="presentation.targetAudiance.label" default="Target Audiance" /></span>
					
						<span class="property-value" aria-labelledby="targetAudiance-label"><g:fieldValue bean="${presentationInstance}" field="targetAudiance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.lengthMinutes}">
				<li class="fieldcontain">
					<span id="lengthMinutes-label" class="property-label"><g:message code="presentation.lengthMinutes.label" default="Length Minutes" /></span>
					
						<span class="property-value" aria-labelledby="lengthMinutes-label"><g:fieldValue bean="${presentationInstance}" field="lengthMinutes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="presentation.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${presentationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.lastUpdate}">
				<li class="fieldcontain">
					<span id="lastUpdate-label" class="property-label"><g:message code="presentation.lastUpdate.label" default="Last Update" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdate-label"><g:formatDate date="${presentationInstance?.lastUpdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="presentation.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${presentationInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.files}">
				<li class="fieldcontain">
					<span id="files-label" class="property-label"><g:message code="presentation.files.label" default="Files" /></span>
					
						<g:each in="${presentationInstance.files}" var="f">
						<span class="property-value" aria-labelledby="files-label"><g:link controller="storageDesc" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.materialsNeeded}">
				<li class="fieldcontain">
					<span id="materialsNeeded-label" class="property-label"><g:message code="presentation.materialsNeeded.label" default="Materials Needed" /></span>
					
						<g:each in="${presentationInstance.materialsNeeded}" var="m">
						<span class="property-value" aria-labelledby="materialsNeeded-label"><g:link controller="item" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${presentationInstance?.videos}">
				<li class="fieldcontain">
					<span id="videos-label" class="property-label"><g:message code="presentation.videos.label" default="Videos" /></span>
					
						<g:each in="${presentationInstance.videos}" var="v">
						<span class="property-value" aria-labelledby="videos-label"><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:presentationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${presentationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
