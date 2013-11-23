package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Planner)
class PlannerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid Planner"() {
        when: 'an Planner is valid'
        def validateable = new Planner(phone: '123-123-1234', firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test firstName property violations on Planner"() {
        when: 'an Planner is missing a firstName property'
        def validateable = new Planner(phone:'123-123-1234', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
        
        when: 'an Planner has a firstName that is too long'
        def firstName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Planner(firstName:firstName65Chars, lastName:'lastName', phone:'123-123-1234', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
    }
    
    void "test lastName property violations on Planner"() {
        when: 'a Planner is missing a lastName property'
        def validateable = new Planner(firstName:'firstName', phone:'123-123-1234', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
        
        when: 'an Planner has a lastName that is too long'
        def lastName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Planner(firstName:'firstName', lastName:lastName65Chars, phone:'123-123-1234', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
    }
    
    void "test middleName property violations on Planner"() {
        when: 'an Planner has a middleName that is too long'
        def middleName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Planner(firstName:'firstName', lastName:'lastName', middleName:middleName65Chars, phone:'123-123-1234', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "middleName"
    }
    
    void "test phone property violations on Planner"() {
        when: 'an Planner is missing a phone property'
        def validateable = new Planner(firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "phone"
        
        when: 'an Planner has a phone that is too long'
        def phone33Chars = """\
1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Planner(phone: phone33Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "phone"
    }
}
