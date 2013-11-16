<%@ page import="org.growler.Biography" %>



<div class="fieldcontain ${hasErrors(bean: biographyInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="biography.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="title" cols="40" rows="5" maxlength="256" required="" value="${biographyInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: biographyInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="biography.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1024" required="" value="${biographyInstance?.description}"/>
</div>

