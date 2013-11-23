package org.growler

import java.util.Date;

class EventSession {

    String title
    Date date
    Presentation presentation
    String location // i.e., room where presentation will be held
    String language
    Date dateCreated
    Date lastUpdate
    String lastUpdatedBy

    static hasMany = [presenters: Speaker]

    static mappings = {
    }

    static constraints = {
        title blank:false, maxSize:256
        date()
        presenters()
        presentation()
        location blank:false, maxSize:128
        language blank:false, maxSize:64
        dateCreated nullable: true, display: false
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
