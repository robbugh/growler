package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    
    void "test valid Address"() {
        when: 'an Address is valid'
        def validateable = new Address(line1: '123 st', state:'TX', country: 'USA', postalCode: '78729')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test missing property violations on Address"() {
        when: 'an Address is missing a line1 property'
        def validateable = new Address(state:'TX', country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "line1"
        
        when: 'an Address is missing a state property'
        validateable = new Address(line1: '123 st', country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "state"

        when: 'an Address is missing a country property'
        validateable = new Address(line1: '123 st', state:'TX', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "country"

        when: 'an Address is missing a postalCode property'
        validateable = new Address(line1: '123 st', state:'TX', country: 'USA')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "postalCode"
    }
    
    void "test invalid size violations on Address"() {
        when: 'an Address has a description too big'
        
        def text257Chars="""\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1
"""
        def validateable = new Address(description: text257Chars, line1:'123 st', state:'TX', country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "description"
        
        when: 'an Address has a line1 too big'
        
        validateable = new Address(line1:text257Chars, state:'TX', country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "line1"
        
        when: 'an Address has a line2 too big'
        
        validateable = new Address(line1: '123 St', line2:text257Chars, state:'TX', country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "line2"

        when: 'an Address has a state too big'
        
        validateable = new Address(line1: '123 St', state:text257Chars, country: 'USA', postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "state"
        
        when: 'an Address has a country too big'
        
        validateable = new Address(line1: '123 St', state:'TX', country: text257Chars, postalCode: '78729')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "country"
        
        when: 'an Address has a postalCode too big'
        
        validateable = new Address(line1: '123 St', state:'TX', country: 'USA', postalCode: text257Chars)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "postalCode"
    }
}
