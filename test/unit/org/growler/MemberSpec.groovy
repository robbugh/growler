package org.growler

import grails.test.mixin.TestFor
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Member)
class MemberSpec extends Specification {

    def setup() {
       // mock a Member object for testing unique constraint violation
       mockForConstraintsTests(Member, [new Member(email: 'unique@bar.com', firstName:'foo', lastName: 'bar')])
    }

    def cleanup() {
    }

    void "test valid Member"() {
        when: 'a Member is valid'
        def validateable = new Member(email: 'foo@bar.com', firstName:'foo', lastName: 'bar')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test invalid email violation on Member"() {
        when: 'a Member is invalid'
        def validateable = new Member(email: 'bad', firstName:'foo', lastName: 'bar')

        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
		validateable.errors.fieldError.field == "email"
    }

    void "test unique constraint violation on Member"() {
        when: 'a Member is valid'
        def validateable = new Member(email: 'unique@bar.com', firstName:'foo', lastName: 'bar')

        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
    }
}
