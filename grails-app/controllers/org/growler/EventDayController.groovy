package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventDayController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventDay.list(params), model:[eventDayInstanceCount: EventDay.count()]
    }

    def show(EventDay eventDayInstance) {
        respond eventDayInstance
    }

    def create() {
        respond new EventDay(params)
    }

    @Transactional
    def save(EventDay eventDayInstance) {
        if (eventDayInstance == null) {
            notFound()
            return
        }

        if (eventDayInstance.hasErrors()) {
            respond eventDayInstance.errors, view:'create'
            return
        }

        eventDayInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventDayInstance.label', default: 'EventDay'), eventDayInstance.id])
                redirect eventDayInstance
            }
            '*' { respond eventDayInstance, [status: CREATED] }
        }
    }

    def edit(EventDay eventDayInstance) {
        respond eventDayInstance
    }

    @Transactional
    def update(EventDay eventDayInstance) {
        if (eventDayInstance == null) {
            notFound()
            return
        }

        if (eventDayInstance.hasErrors()) {
            respond eventDayInstance.errors, view:'edit'
            return
        }

        eventDayInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventDay.label', default: 'EventDay'), eventDayInstance.id])
                redirect eventDayInstance
            }
            '*'{ respond eventDayInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventDay eventDayInstance) {

        if (eventDayInstance == null) {
            notFound()
            return
        }

        eventDayInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventDay.label', default: 'EventDay'), eventDayInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventDayInstance.label', default: 'EventDay'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
