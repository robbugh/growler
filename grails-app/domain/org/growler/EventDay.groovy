package org.growler

import java.util.Date;

class EventDay {

    Date date
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
    
    static hasMany = [sessions: EventSession]    

    static mappings = {
    }

    static constraints = {
        date()
        sessions()
        dateCreated nullable: true, display: false
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
