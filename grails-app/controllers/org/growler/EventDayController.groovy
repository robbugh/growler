package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class EventDayController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', EventDay.count())
		render EventDay.list(params) as JSON
    }

    def save() {
        def eventDayInstance = new EventDay(request.JSON)
        def responseJson = [:]
        if (eventDayInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = eventDayInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'eventDay.label', default: 'EventDay'), eventDayInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = eventDayInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def eventDayInstance = EventDay.get(params.id)
        if (eventDayInstance) {
			render eventDayInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def eventDayInstance = EventDay.get(params.id)
        if (!eventDayInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (eventDayInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'eventDay.label', default: 'EventDay')],
						default: 'Another user has updated this EventDay while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        eventDayInstance.properties = request.JSON

        if (eventDayInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = eventDayInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'eventDay.label', default: 'EventDay'), eventDayInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = eventDayInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def eventDayInstance = EventDay.get(params.id)
        if (!eventDayInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            eventDayInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'eventDay.label', default: 'EventDay'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'eventDay.label', default: 'EventDay'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'eventDay.label', default: 'EventDay'), params.id])]
        render responseJson as JSON
    }
}
