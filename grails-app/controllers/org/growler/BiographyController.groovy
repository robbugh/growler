package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BiographyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Biography.list(params), model:[biographyInstanceCount: Biography.count()]
    }

    def show(Biography biographyInstance) {
        respond biographyInstance
    }

    def create() {
        respond new Biography(params)
    }

    @Transactional
    def save(Biography biographyInstance) {
        if (biographyInstance == null) {
            notFound()
            return
        }

        if (biographyInstance.hasErrors()) {
            respond biographyInstance.errors, view:'create'
            return
        }

        biographyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'biographyInstance.label', default: 'Biography'), biographyInstance.id])
                redirect biographyInstance
            }
            '*' { respond biographyInstance, [status: CREATED] }
        }
    }

    def edit(Biography biographyInstance) {
        respond biographyInstance
    }

    @Transactional
    def update(Biography biographyInstance) {
        if (biographyInstance == null) {
            notFound()
            return
        }

        if (biographyInstance.hasErrors()) {
            respond biographyInstance.errors, view:'edit'
            return
        }

        biographyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Biography.label', default: 'Biography'), biographyInstance.id])
                redirect biographyInstance
            }
            '*'{ respond biographyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Biography biographyInstance) {

        if (biographyInstance == null) {
            notFound()
            return
        }

        biographyInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Biography.label', default: 'Biography'), biographyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'biographyInstance.label', default: 'Biography'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
