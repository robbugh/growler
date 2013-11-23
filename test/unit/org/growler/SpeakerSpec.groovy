package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Speaker)
class SpeakerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid Speaker"() {
        when: 'a Speaker is valid'
        def validateable = new Speaker(firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test firstName property violations on Speaker"() {
        when: 'a Speaker is missing a firstName property'
        def validateable = new Speaker(lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
        
        when: 'an Speaker has a firstName that is too long'
        def firstName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(firstName:firstName65Chars, lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "firstName"
    }
    
    void "test lastName property violations on Speaker"() {
        when: 'a Speaker is missing a lastName property'
        def validateable = new Speaker(firstName:'firstName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
        
        when: 'a Speaker has a lastName that is too long'
        def lastName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(firstName:'firstName', lastName:lastName65Chars, email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lastName"
    }
    
    void "test middleName property violations on Speaker"() {
        when: 'a Speaker has a middleName that is too long'
        def middleName65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Speaker(firstName:'firstName', lastName:'lastName', middleName:middleName65Chars, email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "middleName"
    }
    
    void "test phone property violations on Speaker"() {
        when: 'a Speaker has a phone that is too long'
        def phone33Chars = """\
1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Speaker(phone: phone33Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "phone"
    }
    
    void "test title property violations on Speaker"() {
        when: 'a Speaker has a title that is too long'
        def title257Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Speaker(title: title257Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
    }

    void "test twitterId property violations on Speaker"() {
        when: 'a Speaker has a twitterId that is too long'
        def twitterId65Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        def validateable = new Speaker(twitterId: twitterId65Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "twitterId"
    }

    void "test linkedInUrl property violations on Speaker"() {
        when: 'a Speaker has a linkedInUrl that is invalid'
        def linkedInUrl = "//linkedin.com/foo"
        def validateable = new Speaker(linkedInUrl: linkedInUrl, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "linkedInUrl"
        
        when: 'a Speaker has a linkedInUrl that is valid'
        validateable = new Speaker(linkedInUrl: "http://linkedin.com/foo", firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
        
        when: 'a Speaker has a linkedInUrl that is too long'
        def linkedInUrl257Chars = """\
http://linkedIn.com/1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890AB\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(linkedInUrl: linkedInUrl257Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "linkedInUrl"
    }
    
    void "test webUrl property violations on Speaker"() {
        when: 'a Speaker has a webUrl that is invalid'
        def webUrl = "//linkedin.com/foo"
        def validateable = new Speaker(webUrl: webUrl, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "webUrl"
        
        when: 'a Speaker has a webUrl that is valid'
        validateable = new Speaker(webUrl: "http://linkedin.com/foo", firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
        
        when: 'a Speaker has a webUrl that is too long'
        def webUrl257Chars = """\
http://linkedin.com/567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(webUrl: webUrl257Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "webUrl"
    }

    void "test company property violations on Speaker"() {
        when: 'a Speaker has a company that is valid'
        def validateable = new Speaker(company: "company", firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
        
        when: 'a Speaker has a company that is too long'
        def company257Chars = """\
http://linkedin.com/567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(company: company257Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "company"
    }
    
    void "test address property violations on Speaker"() {
        when: 'a Speaker has a company that is valid'
        def validateable = new Speaker(address: new Address(), firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }
    
    void "test gravatarUrl property violations on Speaker"() {
        when: 'a Speaker has a gravatarUrl that is invalid'
        def gravatarUrl = "//gravatar.com/foo"
        def validateable = new Speaker(gravatarUrl: gravatarUrl, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "gravatarUrl"
        
        when: 'a Speaker has a gravatarUrl that is valid'
        validateable = new Speaker(gravatarUrl: "http://gravatarUrl.com/foo", firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
        
        when: 'a Speaker has a gravatarUrl that is too long'
        def gravatarUrl257Chars = """\
http://linkedIn.com/1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890AB\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Speaker(gravatarUrl: gravatarUrl257Chars, firstName:'firstName', lastName:'lastName', email: 'foo@bar.com')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "gravatarUrl"
    }
}
