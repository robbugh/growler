package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlannerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Planner.list(params), model:[plannerInstanceCount: Planner.count()]
    }

    def show(Planner plannerInstance) {
        respond plannerInstance
    }

    def create() {
        respond new Planner(params)
    }

    @Transactional
    def save(Planner plannerInstance) {
        if (plannerInstance == null) {
            notFound()
            return
        }

        if (plannerInstance.hasErrors()) {
            respond plannerInstance.errors, view:'create'
            return
        }

        plannerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'plannerInstance.label', default: 'Planner'), plannerInstance.id])
                redirect plannerInstance
            }
            '*' { respond plannerInstance, [status: CREATED] }
        }
    }

    def edit(Planner plannerInstance) {
        respond plannerInstance
    }

    @Transactional
    def update(Planner plannerInstance) {
        if (plannerInstance == null) {
            notFound()
            return
        }

        if (plannerInstance.hasErrors()) {
            respond plannerInstance.errors, view:'edit'
            return
        }

        plannerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Planner.label', default: 'Planner'), plannerInstance.id])
                redirect plannerInstance
            }
            '*'{ respond plannerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Planner plannerInstance) {

        if (plannerInstance == null) {
            notFound()
            return
        }

        plannerInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Planner.label', default: 'Planner'), plannerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'plannerInstance.label', default: 'Planner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
