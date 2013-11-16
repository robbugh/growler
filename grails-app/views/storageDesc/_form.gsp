<%@ page import="org.growler.StorageDesc" %>



<div class="fieldcontain ${hasErrors(bean: storageDescInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="storageDesc.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="name" cols="40" rows="5" maxlength="256" required="" value="${storageDescInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storageDescInstance, field: 'path', 'error')} required">
	<label for="path">
		<g:message code="storageDesc.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="path" cols="40" rows="5" maxlength="1024" required="" value="${storageDescInstance?.path}"/>
</div>

