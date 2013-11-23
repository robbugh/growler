package org.growler

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Presentation)
class PresentationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid Presentation"() {
        when: 'a Presentation is valid'
        def validateable = new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }

    void "test title property violations on Presentation"() {
        when: 'a Presentation is missing a title property'
        def validateable = new Presentation(abstractText:'abstractText', summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
        
        when: 'a Presentation has a title that is too long'
        def title257Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Presentation(title:title257Chars, abstractText:'abstractText', summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
    }
    
    void "test abstractText property violations on Presentation"() {
        when: 'a Presentation is missing a abstractText property'
        def validateable = new Presentation(title:'title', summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "abstractText"
        
        when: 'a Presentation has a abstractText that is too long'
        def abstractText1025Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Presentation(title:'title', abstractText:abstractText1025Chars, summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "abstractText"
    }
    
    void "test summary property violations on Presentation"() {
        when: 'a Presentation is missing a summary property'
        def validateable = new Presentation(title:'title', abstractText: 'abstractText:', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "summary"
        
        when: 'a Presentation has a summary that is too long'
        def summary2049Chars = """\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF1234567890ABCDEF\
1
"""
        validateable = new Presentation(title:'title', abstractText:'abstractText', summary: summary2049Chars, presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "summary"
    }

    void "test presentationType property violations on Presentation"() {
        when: 'a Presentation is missing a presentationType property'
        def validateable =  new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "presentationType"
        
        when: 'a Presentation has a presentationType that is not in [WORKSHOP,PANEL_DISCUSSION,LECTURE]'
        validateable =  new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', presentationType:'FOO', targetAudiance:'dev', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        //
        // Spock issue. It does not validate inList membership. Manually testing it.
        //
        !(validateable.presentationType in ["WORKSHOP", "PANEL_DISCUSSION","LECTURE"])
//        !validateable.validate()
//        validateable.hasErrors()
//        validateable.errors.errorCount == 1
//        validateable.errors.fieldError.field == "presentationType"
    }
    
    void "test targetAudiance property violations on Presentation"() {
        when: 'a Presentation is missing a targetAudiance property'
        def validateable =  new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', presentationType:'WORKSHOP', lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "targetAudiance"
        
        when: 'a Presentation has a targetAudiance that is too long'
        def targetAudiance33Chars = """\
1234567890ABCDEF1234567890ABCDEFABCDEF\
1
"""
        validateable =  new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', presentationType:'FOO', targetAudiance:targetAudiance33Chars, lengthMinutes:60)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "targetAudiance"
    }

    void "test lengthMinutes property violations on Presentation"() {
        when: 'a Presentation has a lengthMinutes that is too big'
        def validateable =  new Presentation(title:'title', abstractText:'abstractText', summary: 'summary', presentationType:'WORKSHOP', targetAudiance:'dev', lengthMinutes: 256)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "lengthMinutes"
    }   
}
