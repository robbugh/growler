package org.growler

import java.util.Date;

class Event {

    String name
    Address location
    int status
    String url
    String twitterId
    Date dateCreated
    Date lastUpdate
    String lastUpdatedBy

    static hasMany = [eventDays: EventDay, hashTags: String]

    static mappings = {
    }

    static constraints = {
        name blank:false, maxSize:256
        location()
        status()
        url url:true, nullable:true
        eventDays nullable:true
        hashTags nullable:true
        twitterId nullable:true, maxSize:64
        dateCreated nullable: true, display: false
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
