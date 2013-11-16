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
        title maxSize: 256
        phone maxSize: 32
        twitterId maxSize: 64
        linkedInUrl url: true, maxSize: 256
        webUrl url: true, maxSize: 256
        company maxSize: 256
        address nullable:true
		photo nullable:true
		gravatarUrl nullable:true, url:true
		bios nullable:true
		presentations nullable:true
		videos nullable:true
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
