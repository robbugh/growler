package org.growler



import grails.test.mixin.*
import spock.lang.*

@TestFor(PresentationController)
@Mock(Presentation)
class PresentationControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        params["title"] = 'title'
        params["abstractText"] = 'abstractText'
        params["summary"] = 'summary'
        params["type"] = 'WORKSHOP'
        params["targetAudiance"] = 'targetAudiance'
        params["lengthMinutes"] = 60
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.presentationInstanceList
            model.presentationInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.presentationInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def presentation = new Presentation()
            presentation.validate()
            controller.save(presentation)

        then:"The create view is rendered again with the correct model"
            model.presentationInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            presentation = new Presentation(params)

            controller.save(presentation)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/presentation/show/1'
            controller.flash.message != null
            Presentation.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def presentation = new Presentation(params)
            controller.show(presentation)

        then:"A model is populated containing the domain instance"
            model.presentationInstance == presentation
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def presentation = new Presentation(params)
            controller.edit(presentation)

        then:"A model is populated containing the domain instance"
            model.presentationInstance == presentation
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/presentation/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def presentation = new Presentation()
            presentation.validate()
            controller.update(presentation)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.presentationInstance == presentation

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            presentation = new Presentation(params).save(flush: true)
            controller.update(presentation)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/presentation/show/$presentation.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/presentation/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def presentation = new Presentation(params).save(flush: true)

        then:"It exists"
            Presentation.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(presentation)

        then:"The instance is deleted"
            Presentation.count() == 0
            response.redirectedUrl == '/presentation/index'
            flash.message != null
    }
}
