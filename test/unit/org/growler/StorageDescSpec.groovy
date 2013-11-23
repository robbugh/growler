package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(StorageDesc)
class StorageDescSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

//    name blank:false, maxSize:256
//    path blank: false, maxSize: 1024
    
    void "test valid StorageDesc"() {
        when: 'an StorageDesc is valid'
        def validateable = new StorageDesc(name: 'file.txt', path: '/a/b/c')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test missing property violations on StorageDesc"() {
        when: 'an StorageDesc is missing a name property'
        def validateable = new StorageDesc(path: '/a/b/c')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "name"
        
        when: 'an StorageDesc is missing a path property'
        validateable = new StorageDesc(name: 'file.txt')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "path"
    }
    
    void "test invalid size violations on StorageDesc"() {
        when: 'an StorageDesc has a name too big'
        
        def name257Chars="""\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1\
"""
        def validateable = new StorageDesc(name: name257Chars, path: '/a/b/c')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "name"
        
        when: 'an StorageDesc has a path too big'

        def path1025Chars="""\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef\
1\
"""
        validateable = new StorageDesc(name: 'file.txt', path: path1025Chars)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "path"        
    }
}
