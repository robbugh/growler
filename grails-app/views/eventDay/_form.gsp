<%@ page import="org.growler.EventDay" %>



<div class="fieldcontain ${hasErrors(bean: eventDayInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="eventDay.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${eventDayInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventDayInstance, field: 'sessions', 'error')} ">
	<label for="sessions">
		<g:message code="eventDay.sessions.label" default="Sessions" />
		
	</label>
	<g:select name="sessions" from="${org.growler.EventSession.list()}" multiple="multiple" optionKey="id" size="5" value="${eventDayInstance?.sessions*.id}" class="many-to-many"/>
</div>

