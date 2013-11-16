<%@ page import="org.growler.Presentation" %>



<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="presentation.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="title" cols="40" rows="5" maxlength="256" required="" value="${presentationInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'abstractText', 'error')} required">
	<label for="abstractText">
		<g:message code="presentation.abstractText.label" default="Abstract Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="abstractText" cols="40" rows="5" maxlength="1024" required="" value="${presentationInstance?.abstractText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'summary', 'error')} required">
	<label for="summary">
		<g:message code="presentation.summary.label" default="Summary" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="2048" required="" value="${presentationInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="presentation.type.label" default="Type" />
		
	</label>
	<g:textField name="type" value="${presentationInstance?.type}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'targetAudiance', 'error')} required">
	<label for="targetAudiance">
		<g:message code="presentation.targetAudiance.label" default="Target Audiance" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="targetAudiance" maxlength="32" required="" value="${presentationInstance?.targetAudiance}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'lengthMinutes', 'error')} required">
	<label for="lengthMinutes">
		<g:message code="presentation.lengthMinutes.label" default="Length Minutes" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="lengthMinutes" from="${0..240}" class="range" required="" value="${fieldValue(bean: presentationInstance, field: 'lengthMinutes')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'files', 'error')} ">
	<label for="files">
		<g:message code="presentation.files.label" default="Files" />
		
	</label>
	<g:select name="files" from="${org.growler.StorageDesc.list()}" multiple="multiple" optionKey="id" size="5" value="${presentationInstance?.files*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'materialsNeeded', 'error')} ">
	<label for="materialsNeeded">
		<g:message code="presentation.materialsNeeded.label" default="Materials Needed" />
		
	</label>
	<g:select name="materialsNeeded" from="${org.growler.Item.list()}" multiple="multiple" optionKey="id" size="5" value="${presentationInstance?.materialsNeeded*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: presentationInstance, field: 'videos', 'error')} ">
	<label for="videos">
		<g:message code="presentation.videos.label" default="Videos" />
		
	</label>
	<g:select name="videos" from="${org.growler.Video.list()}" multiple="multiple" optionKey="id" size="5" value="${presentationInstance?.videos*.id}" class="many-to-many"/>
</div>

