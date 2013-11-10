package org.growler

class Address {

    String description
    String line1
    String line2
    String state // or province
    String country
    String postalCode

    static mappings = {
    }

    static constraints = {
        description nullable: true, maxSize: 256
        line1 blank: false
        line2 nullable: true
        state blank: false
        country blank: false
        postalCode blank: false, maxSize: 10    
    }
}
