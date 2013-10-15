package org.growler

class EventDay {

    Date date

    static hasMany = [sessions: EventSession]    

    static mappings = {
    }

    static constraints = {
        date()
        sessions()
    }
}
