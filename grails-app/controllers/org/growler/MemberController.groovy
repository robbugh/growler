package org.growler

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class MemberController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Member.count())
		render Member.list(params) as JSON
    }

    def save() {
        def memberInstance = new Member(request.JSON)
        def responseJson = [:]
        if (memberInstance.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = memberInstance.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'member.label', default: 'Member'), memberInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = memberInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def memberInstance = Member.get(params.id)
        if (memberInstance) {
			render memberInstance as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def memberInstance = Member.get(params.id)
        if (!memberInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (memberInstance.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'member.label', default: 'Member')],
						default: 'Another user has updated this Member while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        memberInstance.properties = request.JSON

        if (memberInstance.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = memberInstance.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'member.label', default: 'Member'), memberInstance.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = memberInstance.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def memberInstance = Member.get(params.id)
        if (!memberInstance) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            memberInstance.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'member.label', default: 'Member'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'member.label', default: 'Member'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'member.label', default: 'Member'), params.id])]
        render responseJson as JSON
    }
}
