package org.growler

class Address {

    String title
    String line1
    String line2
    String state // or province
    String country
    String postalCode

    static mappings = {
    }

    static constraints = {
        title()
        line1()
        line2()
        state()
        country()
        postalCode()   
    }
}
