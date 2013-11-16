package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PresentationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Presentation.list(params), model:[presentationInstanceCount: Presentation.count()]
    }

    def show(Presentation presentationInstance) {
        respond presentationInstance
    }

    def create() {
        respond new Presentation(params)
    }

    @Transactional
    def save(Presentation presentationInstance) {
        if (presentationInstance == null) {
            notFound()
            return
        }

        if (presentationInstance.hasErrors()) {
            respond presentationInstance.errors, view:'create'
            return
        }

        presentationInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'presentationInstance.label', default: 'Presentation'), presentationInstance.id])
                redirect presentationInstance
            }
            '*' { respond presentationInstance, [status: CREATED] }
        }
    }

    def edit(Presentation presentationInstance) {
        respond presentationInstance
    }

    @Transactional
    def update(Presentation presentationInstance) {
        if (presentationInstance == null) {
            notFound()
            return
        }

        if (presentationInstance.hasErrors()) {
            respond presentationInstance.errors, view:'edit'
            return
        }

        presentationInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Presentation.label', default: 'Presentation'), presentationInstance.id])
                redirect presentationInstance
            }
            '*'{ respond presentationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Presentation presentationInstance) {

        if (presentationInstance == null) {
            notFound()
            return
        }

        presentationInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Presentation.label', default: 'Presentation'), presentationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'presentationInstance.label', default: 'Presentation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
