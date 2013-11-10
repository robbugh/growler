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
	
//	country blank: false
//	postalCode blank: false, maxSize: 10

    void "test valid Address"() {
        when: 'an Address is valid'
        def validateable = new Address(description: 'foo', line1: '123 foo st.', line2: 'bar', state: 'TX', country: 'USA', postalCode: '1234567890')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test invalid description"() {
        when: 'the description is too long'
		def description257Chars = """\
0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF\
0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF\
0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF\
0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF\
x\
"""
        def validateable = new Address(description: description257Chars, line1: '123 foo st.', state: 'TX', country: 'USA', postalCode: '1234567890')

        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
    }
	
	void "test valid line2"() {
		when: 'line2 is blank'
		def validateable = new Address(line1: '123 foo st.', line2: '', state: 'TX', country: 'USA', postalCode: '1234567890')

		then: 'validate() returns true and there is no error'
		validateable.validate()
		!validateable.hasErrors()
		validateable.errors.errorCount == 0
		
		when: 'line2 is null'
		validateable = new Address(line1: '123 foo st.', state: 'TX', country: 'USA', postalCode: '1234567890')

		then: 'validate() returns false and there is one error'
		validateable.validate()
		!validateable.hasErrors()
		validateable.errors.errorCount == 0
	}
	
	void "test invalid state"() {
		when: 'state is blank'
		def validateable = new Address(line1: '123 foo st.', state: '', country: 'USA', postalCode: '1234567890')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
		
		when: 'state is null'
		validateable = new Address(line1: '123 foo st.', country: 'USA', postalCode: '1234567890')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
	}

	void "test invalid country"() {
		when: 'country is blank'
		def validateable = new Address(line1: '123 foo st.', state: 'TX', country: '', postalCode: '1234567890')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
		
		when: 'country is null'
		validateable = new Address(line1: '123 foo st.', state: 'TX', postalCode: '1234567890')

		then: 'validate() returns false and there is one error'
		!validateable.validate()
		validateable.hasErrors()
		validateable.errors.errorCount == 1
	}
}
