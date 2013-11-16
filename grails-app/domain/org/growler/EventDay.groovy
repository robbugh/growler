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
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
