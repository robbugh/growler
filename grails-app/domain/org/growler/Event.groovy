package org.growler

class Event {

    String name
    Address location
    int status
    String url
    String twitterId

    static hasMany = [eventDays: EventDay, hashTags: String]
    
    static mappings = {
    }

    static constraints = {
    }
}
