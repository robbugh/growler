package org.growler

import java.util.Date;

class Speaker extends Member {

    String title
    String phone
    String twitterId
    String linkedInUrl
    String webUrl
    String company
    Address address
    StorageDesc photo
	String gravatarUrl
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
    
    
    static hasMany = [bios: Biography, presentations: Presentation, videos: Video]

    static mappings = {
    }

    static constraints = {
        title maxSize: 256, nullable:true
        phone maxSize: 32, nullable:true
        twitterId maxSize: 64, nullable:true
        linkedInUrl url: true, maxSize: 256, nullable:true
        webUrl url: true, maxSize: 256, nullable:true
        company maxSize: 256, nullable:true
        address nullable:true
		photo nullable:true
		gravatarUrl nullable:true, url:true
		bios nullable:true
		presentations nullable:true
		videos nullable:true
        dateCreated nullable: true, display: false
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
