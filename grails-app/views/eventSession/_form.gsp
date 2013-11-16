<%@ page import="org.growler.EventSession" %>



<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="eventSession.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="title" cols="40" rows="5" maxlength="256" required="" value="${eventSessionInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="eventSession.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${eventSessionInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'presenters', 'error')} required">
	<label for="presenters">
		<g:message code="eventSession.presenters.label" default="Presenters" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="presenters" from="${org.growler.Speaker.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${eventSessionInstance?.presenters*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'presentation', 'error')} required">
	<label for="presentation">
		<g:message code="eventSession.presentation.label" default="Presentation" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="presentation" name="presentation.id" from="${org.growler.Presentation.list()}" optionKey="id" required="" value="${eventSessionInstance?.presentation?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="eventSession.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="location" maxlength="128" required="" value="${eventSessionInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventSessionInstance, field: 'language', 'error')} required">
	<label for="language">
		<g:message code="eventSession.language.label" default="Language" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="language" maxlength="64" required="" value="${eventSessionInstance?.language}"/>
</div>

