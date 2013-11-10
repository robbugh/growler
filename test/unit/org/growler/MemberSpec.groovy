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
        def validateable = new Member(email: 'foo@bar.com', firstName:'foo', middleName: 'bar', lastName: 'baz')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test unique constraint violation on Email"() {
        when: 'a email is not unique'
        def validateable = new Member(email: 'unique@bar.com', firstName:'foo', lastName: 'bar')

        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
    }
	
	void "test invalid email"() {
		when: 'a email is invalid'
		def validateable = new Member(email: 'foo', firstName:'foo', lastName: 'bar')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
	}
	
	void "test invalid firstName"() {
		when: 'a firstName is invalid'
		def validateable = new Member(email: 'foo@bar.com', firstName:'', lastName: 'bar')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
	}
	
	void "test invalid lastName"() {
		when: 'a lastName is invalid'
		def validateable = new Member(email: 'foo@bar.com', firstName:'foo', lastName: '')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
	}
	
	void "test null middleName"() {
		when: 'a middleName is invalid'
		def validateable = new Member(email: 'foo@bar.com', firstName:'foo', middleName: '', lastName: 'bar')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
	}
}
