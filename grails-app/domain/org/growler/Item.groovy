package org.growler

import java.util.Collection;
import java.util.Date;

class Item {

    String name
    String description
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
    
    static mappings = {
    }

    static constraints = {
		name blank:false, maxSize:256
		description blank: false, maxSize: 1024
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
