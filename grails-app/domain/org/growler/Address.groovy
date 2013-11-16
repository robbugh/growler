package org.growler

import java.util.Date;

class Address {

    String description
    String line1
    String line2
    String state // or province
    String country
    String postalCode
    Date dateCreated
    Date lastUpdate
    String lastUpdatedBy

    static mappings = {
    }

    static constraints = {
        description nullable: true, maxSize: 256
        line1 blank: false, maxSize: 256
        line2 nullable: true, maxSize: 256
        state blank: false, maxSize: 64
        country blank: false, maxSize: 128
        postalCode blank: false, maxSize: 16
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
