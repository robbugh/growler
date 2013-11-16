package org.growler

import java.util.Date;

class StorageDesc {

    String name
    String path
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
    
   
    static mappings = {
    }

    static constraints = {
		name blank:false, maxSize:256
		path blank: false, maxSize: 1024
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
