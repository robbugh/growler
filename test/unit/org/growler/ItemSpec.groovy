package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    
//    name blank:false, maxSize:256
//    description blank: false, maxSize: 1024

    void "test valid Item"() {
        when: 'an Item is valid'
        def validateable = new Item(name:'name', description: 'description')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test name property violations on Item"() {
        when: 'an Item is missing a name property'
        def validateable = new Item(description: 'description')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "name"
        
        when: 'an Item has a name that is too long'
        def name257Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Item(name:name257Chars, description: 'description')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "name"
    }
    
    void "test description property violations on Item"() {
        when: 'an Item is missing a description property'
        def validateable = new Item(name: 'name')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "description"
        
        when: 'an Item has a description that is too long'
        def description1025Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Item(name:'name', description: description1025Chars)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "description"
    }

}
