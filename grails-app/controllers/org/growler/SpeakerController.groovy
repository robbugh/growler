package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class SpeakerController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Speaker.count())
		render Speaker.list(params) as JSON
    }

    def save() {
        def speakerInstance = new Speaker(request.JSON)
        def responseJson = [:]
        if (speakerInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = speakerInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'speaker.label', default: 'Speaker'), speakerInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = speakerInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def speakerInstance = Speaker.get(params.id)
        if (speakerInstance) {
			render speakerInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def speakerInstance = Speaker.get(params.id)
        if (!speakerInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (speakerInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'speaker.label', default: 'Speaker')],
						default: 'Another user has updated this Speaker while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        speakerInstance.properties = request.JSON

        if (speakerInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = speakerInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'speaker.label', default: 'Speaker'), speakerInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = speakerInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def speakerInstance = Speaker.get(params.id)
        if (!speakerInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            speakerInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'speaker.label', default: 'Speaker'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'speaker.label', default: 'Speaker'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'speaker.label', default: 'Speaker'), params.id])]
        render responseJson as JSON
    }
}
