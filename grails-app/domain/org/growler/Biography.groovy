package org.growler

import java.util.Date;

class Biography {

    String title
    String description
    Date dateCreated
    Date lastUpdate
    String lastUpdatedBy

    static mappings = {
    }

    static constraints = {
        title blank:false, maxSize:256
        description blank:false, maxSize: 1024
        dateCreated nullable: true, display: false
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
