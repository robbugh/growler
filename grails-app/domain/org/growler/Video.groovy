package org.growler

import java.util.Date;

class Video {

    String title
    String abstractText
    int lengthMinutes
	String url
	StorageDesc videoFile
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
   
    static mappings = {
    }

    static constraints = {
		title blank:false, maxSize:256
		abstractText blank: false, maxSize: 1024
		lengthMinutes()
		videoFile nullable:true
		url nullable:true
        dateCreated nullable: true, display: false
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
