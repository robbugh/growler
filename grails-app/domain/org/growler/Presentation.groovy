package org.growler

class Presentation {

    String title
    String abstractText
    String summary
    String type
    String targetAudiance
    int lengthMinutes
	Date dateCreated
	Date lastUpdate
    String lastUpdatedBy
    

    static hasMany = [videos: Video, files: StorageDesc, materialsNeeded: Item]
    
    static mappings = {
    }

    static constraints = {
		title blank:false, maxSize:256
		abstractText blank: false, maxSize: 1024
		summary blank: false, maxSize: 2048
		type inlist: ["WORKSHOP", "PANEL_DISCUSSION", "LECTURE"]
		targetAudiance blank: false, maxSize: 32
		lengthMinutes range: 0..240
        dateCreated nullable: true, display: false
		lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
