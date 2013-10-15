package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class PresentationController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Presentation.count())
		render Presentation.list(params) as JSON
    }

    def save() {
        def presentationInstance = new Presentation(request.JSON)
        def responseJson = [:]
        if (presentationInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = presentationInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'presentation.label', default: 'Presentation'), presentationInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = presentationInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def presentationInstance = Presentation.get(params.id)
        if (presentationInstance) {
			render presentationInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def presentationInstance = Presentation.get(params.id)
        if (!presentationInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (presentationInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'presentation.label', default: 'Presentation')],
						default: 'Another user has updated this Presentation while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        presentationInstance.properties = request.JSON

        if (presentationInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = presentationInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'presentation.label', default: 'Presentation'), presentationInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = presentationInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def presentationInstance = Presentation.get(params.id)
        if (!presentationInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            presentationInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'presentation.label', default: 'Presentation'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'presentation.label', default: 'Presentation'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'presentation.label', default: 'Presentation'), params.id])]
        render responseJson as JSON
    }
}
