package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EventSession)
class EventSessionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    
    void "test valid EventSession"() {
        when: 'an EventSession is valid'
        def validateable = new EventSession(title: 'title', date: new Date(), presentation: new Presentation(), location: 'rm 123', language: 'En')

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test title property violations on EventSession"() {
        when: 'an EventSession is missing a date property'
        def validateable = new EventSession(date: new Date(), presentation: new Presentation(), location: 'rm 123', language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
        
        when: 'an EventSession has a title that is too long'
        def title257Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new EventSession(title: title257Chars, date: new Date(), presentation: new Presentation(), location: 'rm 123', language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
    }
    
    void "test date property violations on EventSession"() {
        when: 'an EventSession is missing a date property'
        def validateable = new EventSession(title: 'title', presentation: new Presentation(), location: 'rm 123', language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "date"
    }

    void "test presentation property violations on EventSession"() {
        when: 'an EventSession is missing a presentation property'
        def validateable = new EventSession(title: 'title', date: new Date(), location: 'rm 123', language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "presentation"
    }
    
    void "test location property violations on EventSession"() {
        when: 'an EventSession is missing a location property'
        def validateable = new EventSession(title: 'title', date: new Date(), presentation: new Presentation(), language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "location"
        
        when: 'an EventSession has a location that is too long'
        def location129Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new EventSession(title: 'title', date: new Date(), presentation: new Presentation(), location: location129Chars, language: 'En')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "location"
    }
    
    void "test language property violations on EventSession"() {
        when: 'an EventSession is missing a language property'
        def validateable = new EventSession(title: 'title', date: new Date(), presentation: new Presentation(), location: 'rm 123')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "language"
        
        when: 'an EventSession has a language that is too long'
        def language65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new EventSession(title: 'title', date: new Date(), presentation: new Presentation(), location: 'rm 123', language: language65Chars)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "language"
    }
}
