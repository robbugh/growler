<%@ page import="org.growler.Planner" %>



<div class="fieldcontain ${hasErrors(bean: plannerInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="planner.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${plannerInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plannerInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="planner.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${plannerInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plannerInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="planner.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${plannerInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plannerInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="planner.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${plannerInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plannerInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="planner.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" maxlength="32" required="" value="${plannerInstance?.phone}"/>
</div>

