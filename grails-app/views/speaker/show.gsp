
<%@ page import="org.growler.Speaker" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'speaker.label', default: 'Speaker')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-speaker" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-speaker" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list speaker">
			
				<g:if test="${speakerInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="speaker.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${speakerInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="speaker.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${speakerInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="speaker.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${speakerInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="speaker.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${speakerInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.lastUpdate}">
				<li class="fieldcontain">
					<span id="lastUpdate-label" class="property-label"><g:message code="speaker.lastUpdate.label" default="Last Update" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdate-label"><g:formatDate date="${speakerInstance?.lastUpdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="speaker.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:fieldValue bean="${speakerInstance}" field="lastUpdatedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="speaker.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${speakerInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="speaker.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${speakerInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.twitterId}">
				<li class="fieldcontain">
					<span id="twitterId-label" class="property-label"><g:message code="speaker.twitterId.label" default="Twitter Id" /></span>
					
						<span class="property-value" aria-labelledby="twitterId-label"><g:fieldValue bean="${speakerInstance}" field="twitterId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.linkedInUrl}">
				<li class="fieldcontain">
					<span id="linkedInUrl-label" class="property-label"><g:message code="speaker.linkedInUrl.label" default="Linked In Url" /></span>
					
						<span class="property-value" aria-labelledby="linkedInUrl-label"><g:fieldValue bean="${speakerInstance}" field="linkedInUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.webUrl}">
				<li class="fieldcontain">
					<span id="webUrl-label" class="property-label"><g:message code="speaker.webUrl.label" default="Web Url" /></span>
					
						<span class="property-value" aria-labelledby="webUrl-label"><g:fieldValue bean="${speakerInstance}" field="webUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="property-label"><g:message code="speaker.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:fieldValue bean="${speakerInstance}" field="company"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="speaker.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${speakerInstance?.address?.id}">${speakerInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.photo}">
				<li class="fieldcontain">
					<span id="photo-label" class="property-label"><g:message code="speaker.photo.label" default="Photo" /></span>
					
						<span class="property-value" aria-labelledby="photo-label"><g:link controller="storageDesc" action="show" id="${speakerInstance?.photo?.id}">${speakerInstance?.photo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.gravatarUrl}">
				<li class="fieldcontain">
					<span id="gravatarUrl-label" class="property-label"><g:message code="speaker.gravatarUrl.label" default="Gravatar Url" /></span>
					
						<span class="property-value" aria-labelledby="gravatarUrl-label"><g:fieldValue bean="${speakerInstance}" field="gravatarUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.bios}">
				<li class="fieldcontain">
					<span id="bios-label" class="property-label"><g:message code="speaker.bios.label" default="Bios" /></span>
					
						<g:each in="${speakerInstance.bios}" var="b">
						<span class="property-value" aria-labelledby="bios-label"><g:link controller="biography" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.presentations}">
				<li class="fieldcontain">
					<span id="presentations-label" class="property-label"><g:message code="speaker.presentations.label" default="Presentations" /></span>
					
						<g:each in="${speakerInstance.presentations}" var="p">
						<span class="property-value" aria-labelledby="presentations-label"><g:link controller="presentation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.videos}">
				<li class="fieldcontain">
					<span id="videos-label" class="property-label"><g:message code="speaker.videos.label" default="Videos" /></span>
					
						<g:each in="${speakerInstance.videos}" var="v">
						<span class="property-value" aria-labelledby="videos-label"><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${speakerInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="speaker.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${speakerInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:speakerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${speakerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
