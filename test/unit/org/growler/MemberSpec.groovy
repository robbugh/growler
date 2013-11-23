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
    
    void "test firstName property violations on Member"() {
        when: 'a Member is missing a firstName property'
        def validateable = new Member(lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
        
        when: 'an Member has a firstName that is too long'
        def firstName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Member(firstName:firstName65Chars, lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
    }

    void "test lastName property violations on Member"() {
        when: 'a Member is missing a lastName property'
        def validateable = new Member(firstName:'firstName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
        
        when: 'an Member has a lastName that is too long'
        def lastName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Member(firstName:'firstName', lastName:lastName65Chars, email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
    }
    
    void "test middleName property violations on Member"() {
        when: 'an Member has a middleName that is too long'
        def middleName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Member(firstName:'firstName', lastName:'lastName', middleName:middleName65Chars, email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "middleName"
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
