<%@ page import="org.growler.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="event.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="name" cols="40" rows="5" maxlength="256" required="" value="${eventInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="event.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="location" name="location.id" from="${org.growler.Address.list()}" optionKey="id" required="" value="${eventInstance?.location?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="event.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="status" type="number" value="${eventInstance.status}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="event.url.label" default="Url" />
		
	</label>
	<g:field type="url" name="url" value="${eventInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'eventDays', 'error')} ">
	<label for="eventDays">
		<g:message code="event.eventDays.label" default="Event Days" />
		
	</label>
	<g:select name="eventDays" from="${org.growler.EventDay.list()}" multiple="multiple" optionKey="id" size="5" value="${eventInstance?.eventDays*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'hashTags', 'error')} ">
	<label for="hashTags">
		<g:message code="event.hashTags.label" default="Hash Tags" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'twitterId', 'error')} ">
	<label for="twitterId">
		<g:message code="event.twitterId.label" default="Twitter Id" />
		
	</label>
	<g:textField name="twitterId" maxlength="64" value="${eventInstance?.twitterId}"/>
</div>

