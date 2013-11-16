package org.growler



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StorageDescController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond StorageDesc.list(params), model:[storageDescInstanceCount: StorageDesc.count()]
    }

    def show(StorageDesc storageDescInstance) {
        respond storageDescInstance
    }

    def create() {
        respond new StorageDesc(params)
    }

    @Transactional
    def save(StorageDesc storageDescInstance) {
        if (storageDescInstance == null) {
            notFound()
            return
        }

        if (storageDescInstance.hasErrors()) {
            respond storageDescInstance.errors, view:'create'
            return
        }

        storageDescInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'storageDescInstance.label', default: 'StorageDesc'), storageDescInstance.id])
                redirect storageDescInstance
            }
            '*' { respond storageDescInstance, [status: CREATED] }
        }
    }

    def edit(StorageDesc storageDescInstance) {
        respond storageDescInstance
    }

    @Transactional
    def update(StorageDesc storageDescInstance) {
        if (storageDescInstance == null) {
            notFound()
            return
        }

        if (storageDescInstance.hasErrors()) {
            respond storageDescInstance.errors, view:'edit'
            return
        }

        storageDescInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'StorageDesc.label', default: 'StorageDesc'), storageDescInstance.id])
                redirect storageDescInstance
            }
            '*'{ respond storageDescInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(StorageDesc storageDescInstance) {

        if (storageDescInstance == null) {
            notFound()
            return
        }

        storageDescInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'StorageDesc.label', default: 'StorageDesc'), storageDescInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'storageDescInstance.label', default: 'StorageDesc'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
