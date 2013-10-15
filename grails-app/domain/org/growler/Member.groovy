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
    }
}
