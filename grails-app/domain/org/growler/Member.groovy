package org.growler

class Member {

    String email
    String firstName
    String middleName
    String lastName

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        email email: true, unique: true
        firstName blank: false
        middleName nullable: true
        lastName blank: false
    }
}
