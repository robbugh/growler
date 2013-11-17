package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Event)
class EventSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid Event"() {
        when: "a valid Event"
        def event = createValidEvent()

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }

    private def createValidEvent() {
        new Event(name: "event", location:new Address(), status:0)
    }

    void "test blank name"() {
        when: "blank name"
        def event = createValidEvent()
        event.name = ""

        then: "validate() is false w/1 error"
        !event.validate()
        event.hasErrors()
        event.errors.errorCount == 1
    }

    void "test null url"() {
        when: "null url"
        def event = createValidEvent()
        event.url = null

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }

    void "test valid url"() {
        when: "valid url"
        def event = createValidEvent()
        event.url = "http://www.github.com"

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }

    void "test invalid url"() {
        when: "invalid url"
        def event = createValidEvent()
        event.url = "invalidUrl"

        then: "validate() is false w/1 error"
        !event.validate()
        event.hasErrors()
        event.errors.errorCount == 1
    }

    void "test null twitterId"() {
        when: "null twitterId"
        def event = createValidEvent()
        event.twitterId = null

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }

    void "test null eventDays"() {
        when: "null eventDays"
        def event = createValidEvent()
        event.eventDays = null

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }

    void "test null hashTags"() {
        when: "null hashTags"
        def event = createValidEvent()
        event.hashTags = null

        then: "validate() is true w/no errors"
        event.validate()
        !event.hasErrors()
        event.errors.errorCount == 0
    }
}
