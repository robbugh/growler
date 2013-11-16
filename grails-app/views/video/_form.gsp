<%@ page import="org.growler.Video" %>



<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="video.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="title" cols="40" rows="5" maxlength="256" required="" value="${videoInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'abstractText', 'error')} required">
	<label for="abstractText">
		<g:message code="video.abstractText.label" default="Abstract Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="abstractText" cols="40" rows="5" maxlength="1024" required="" value="${videoInstance?.abstractText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'lengthMinutes', 'error')} required">
	<label for="lengthMinutes">
		<g:message code="video.lengthMinutes.label" default="Length Minutes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lengthMinutes" type="number" value="${videoInstance.lengthMinutes}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'videoFile', 'error')} ">
	<label for="videoFile">
		<g:message code="video.videoFile.label" default="Video File" />
		
	</label>
	<g:select id="videoFile" name="videoFile.id" from="${org.growler.StorageDesc.list()}" optionKey="id" value="${videoInstance?.videoFile?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="video.url.label" default="Url" />
		
	</label>
	<g:textField name="url" value="${videoInstance?.url}"/>
</div>

