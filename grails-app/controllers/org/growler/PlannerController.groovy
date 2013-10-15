package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class PlannerController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Planner.count())
		render Planner.list(params) as JSON
    }

    def save() {
        def plannerInstance = new Planner(request.JSON)
        def responseJson = [:]
        if (plannerInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = plannerInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'planner.label', default: 'Planner'), plannerInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = plannerInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def plannerInstance = Planner.get(params.id)
        if (plannerInstance) {
			render plannerInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def plannerInstance = Planner.get(params.id)
        if (!plannerInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (plannerInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'planner.label', default: 'Planner')],
						default: 'Another user has updated this Planner while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        plannerInstance.properties = request.JSON

        if (plannerInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = plannerInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'planner.label', default: 'Planner'), plannerInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = plannerInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def plannerInstance = Planner.get(params.id)
        if (!plannerInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            plannerInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'planner.label', default: 'Planner'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'planner.label', default: 'Planner'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'planner.label', default: 'Planner'), params.id])]
        render responseJson as JSON
    }
}
