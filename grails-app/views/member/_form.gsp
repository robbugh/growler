<%@ page import="org.growler.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="member.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${memberInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="member.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${memberInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="member.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${memberInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="member.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${memberInstance?.email}"/>
</div>

