package org.growler

class EventSession {

    String title
    Date date
    Presentation presentation
    String location // i.e., room where presentation will be held
    String language

    static hasMany = [presenters: Speaker]

    static mappings = {
    }

    static constraints = {
    }
}
