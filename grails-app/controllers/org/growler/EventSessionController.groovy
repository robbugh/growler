package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventSessionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventSession.list(params), model:[eventSessionInstanceCount: EventSession.count()]
    }

    def show(EventSession eventSessionInstance) {
        respond eventSessionInstance
    }

    def create() {
        respond new EventSession(params)
    }

    @Transactional
    def save(EventSession eventSessionInstance) {
        if (eventSessionInstance == null) {
            notFound()
            return
        }

        if (eventSessionInstance.hasErrors()) {
            respond eventSessionInstance.errors, view:'create'
            return
        }

        eventSessionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventSessionInstance.label', default: 'EventSession'), eventSessionInstance.id])
                redirect eventSessionInstance
            }
            '*' { respond eventSessionInstance, [status: CREATED] }
        }
    }

    def edit(EventSession eventSessionInstance) {
        respond eventSessionInstance
    }

    @Transactional
    def update(EventSession eventSessionInstance) {
        if (eventSessionInstance == null) {
            notFound()
            return
        }

        if (eventSessionInstance.hasErrors()) {
            respond eventSessionInstance.errors, view:'edit'
            return
        }

        eventSessionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventSession.label', default: 'EventSession'), eventSessionInstance.id])
                redirect eventSessionInstance
            }
            '*'{ respond eventSessionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventSession eventSessionInstance) {

        if (eventSessionInstance == null) {
            notFound()
            return
        }

        eventSessionInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventSession.label', default: 'EventSession'), eventSessionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventSessionInstance.label', default: 'EventSession'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
