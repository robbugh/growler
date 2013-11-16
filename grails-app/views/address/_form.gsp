<%@ page import="org.growler.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="address.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="256" value="${addressInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'line1', 'error')} required">
	<label for="line1">
		<g:message code="address.line1.label" default="Line1" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="line1" cols="40" rows="5" maxlength="256" required="" value="${addressInstance?.line1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'line2', 'error')} ">
	<label for="line2">
		<g:message code="address.line2.label" default="Line2" />
		
	</label>
	<g:textArea name="line2" cols="40" rows="5" maxlength="256" value="${addressInstance?.line2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="address.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" maxlength="64" required="" value="${addressInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="address.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" maxlength="128" required="" value="${addressInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'postalCode', 'error')} required">
	<label for="postalCode">
		<g:message code="address.postalCode.label" default="Postal Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="postalCode" maxlength="16" required="" value="${addressInstance?.postalCode}"/>
</div>

