package org.growler

class EventSession {

    String title
    Date date
    Presentation presentation
    List<Speaker> presenters
    String location // i.e., room where presentation will be held

    static mappings = {
    }

    static constraints = {
    }
}
