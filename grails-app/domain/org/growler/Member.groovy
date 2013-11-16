package org.growler

import java.util.Date;

class Member {

    String firstName
    String middleName
    String lastName
    String email
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        firstName blank: false
        middleName nullable: true
        lastName blank: false
        email email: true, blank:false, unique: true
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
