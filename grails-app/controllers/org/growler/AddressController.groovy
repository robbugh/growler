package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class AddressController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Address.count())
		render Address.list(params) as JSON
    }

    def save() {
        def addressInstance = new Address(request.JSON)
        def responseJson = [:]
        if (addressInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = addressInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'address.label', default: 'Address'), addressInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = addressInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def addressInstance = Address.get(params.id)
        if (addressInstance) {
			render addressInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def addressInstance = Address.get(params.id)
        if (!addressInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (addressInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'address.label', default: 'Address')],
						default: 'Another user has updated this Address while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        addressInstance.properties = request.JSON

        if (addressInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = addressInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'address.label', default: 'Address'), addressInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = addressInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def addressInstance = Address.get(params.id)
        if (!addressInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            addressInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'address.label', default: 'Address'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'address.label', default: 'Address'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'address.label', default: 'Address'), params.id])]
        render responseJson as JSON
    }
}
