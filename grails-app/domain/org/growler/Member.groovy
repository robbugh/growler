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

    static mapping = { tablePerHierarchy false }

    static constraints = {
        firstName blank: false, maxSize: 64
        middleName nullable: true, maxSize: 64
        lastName blank: false, maxSize: 64
        email email: true, blank:false, unique: true
        dateCreated nullable: true, display: false
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
