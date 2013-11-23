package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Video)
class VideoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
   
    void "test valid Video"() {
        when: 'an Video is valid'
        def validateable = new Video(title: 'title', abstractText: 'abstract')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }
    
    void "test missing property violations on Video"() {
        when: 'an Video is missing a title property'
        def validateable = new Video(abstractText: 'abstract')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
        
        when: 'an Video is missing a abstractText property'
        validateable = new Video(title: 'title')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "abstractText"
    }
}
