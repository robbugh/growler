package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class BiographyController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Biography.count())
		render Biography.list(params) as JSON
    }

    def save() {
        def biographyInstance = new Biography(request.JSON)
        def responseJson = [:]
        if (biographyInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = biographyInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'biography.label', default: 'Biography'), biographyInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = biographyInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def biographyInstance = Biography.get(params.id)
        if (biographyInstance) {
			render biographyInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def biographyInstance = Biography.get(params.id)
        if (!biographyInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (biographyInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'biography.label', default: 'Biography')],
						default: 'Another user has updated this Biography while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        biographyInstance.properties = request.JSON

        if (biographyInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = biographyInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'biography.label', default: 'Biography'), biographyInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = biographyInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def biographyInstance = Biography.get(params.id)
        if (!biographyInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            biographyInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'biography.label', default: 'Biography'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'biography.label', default: 'Biography'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'biography.label', default: 'Biography'), params.id])]
        render responseJson as JSON
    }
}
