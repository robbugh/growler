package org.growler

class Event {

    String name
    Address location
    List<EventDay> eventDays
    int status
    String url
    String twitterId
    List<String> twitterHashTags
    
    static mappings = {
    }

    static constraints = {
    }
}
