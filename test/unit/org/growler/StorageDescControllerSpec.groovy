package org.growler



import grails.test.mixin.*
import spock.lang.*

@TestFor(StorageDescController)
@Mock(StorageDesc)
class StorageDescControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.storageDescInstanceList
            model.storageDescInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.storageDescInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def storageDesc = new StorageDesc()
            storageDesc.validate()
            controller.save(storageDesc)

        then:"The create view is rendered again with the correct model"
            model.storageDescInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            storageDesc = new StorageDesc(params)

            controller.save(storageDesc)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/storageDesc/show/1'
            controller.flash.message != null
            StorageDesc.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def storageDesc = new StorageDesc(params)
            controller.show(storageDesc)

        then:"A model is populated containing the domain instance"
            model.storageDescInstance == storageDesc
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def storageDesc = new StorageDesc(params)
            controller.edit(storageDesc)

        then:"A model is populated containing the domain instance"
            model.storageDescInstance == storageDesc
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/storageDesc/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def storageDesc = new StorageDesc()
            storageDesc.validate()
            controller.update(storageDesc)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.storageDescInstance == storageDesc

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            storageDesc = new StorageDesc(params).save(flush: true)
            controller.update(storageDesc)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/storageDesc/show/$storageDesc.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/storageDesc/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def storageDesc = new StorageDesc(params).save(flush: true)

        then:"It exists"
            StorageDesc.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(storageDesc)

        then:"The instance is deleted"
            StorageDesc.count() == 0
            response.redirectedUrl == '/storageDesc/index'
            flash.message != null
    }
}
