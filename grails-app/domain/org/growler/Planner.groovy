package org.growler

import java.util.Date;

class Planner extends Member {

    String phone
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy

    static mappings = {
    }

    static constraints = {
		phone blank:false, maxSize: 32
        dateCreated nullable: true, display: false
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
