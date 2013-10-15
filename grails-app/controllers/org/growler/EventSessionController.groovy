package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class EventSessionController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', EventSession.count())
		render EventSession.list(params) as JSON
    }

    def save() {
        def eventSessionInstance = new EventSession(request.JSON)
        def responseJson = [:]
        if (eventSessionInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = eventSessionInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'eventSession.label', default: 'EventSession'), eventSessionInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = eventSessionInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def eventSessionInstance = EventSession.get(params.id)
        if (eventSessionInstance) {
			render eventSessionInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def eventSessionInstance = EventSession.get(params.id)
        if (!eventSessionInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (eventSessionInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'eventSession.label', default: 'EventSession')],
						default: 'Another user has updated this EventSession while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        eventSessionInstance.properties = request.JSON

        if (eventSessionInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = eventSessionInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'eventSession.label', default: 'EventSession'), eventSessionInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = eventSessionInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def eventSessionInstance = EventSession.get(params.id)
        if (!eventSessionInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            eventSessionInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'eventSession.label', default: 'EventSession'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'eventSession.label', default: 'EventSession'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'eventSession.label', default: 'EventSession'), params.id])]
        render responseJson as JSON
    }
}
