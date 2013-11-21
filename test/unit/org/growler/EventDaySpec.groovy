package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EventDay)
class EventDaySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid EventDay"() {
        when: 'an EventDay is valid'
        def validateable = new EventDay(date: new Date())

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }
    
    void "test invalid EventDay"() {
        when: 'an EventDay is missing the date property'
        def validateable = new EventDay()

        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == 'date'
    }
}
