package org.growler

class Speaker extends Member {

    String title
    String phone
    String twitterId
    String linkedInUrl
    String webUrl
    String company
    Address address
    //File photo -- Use Gravatar instead?
    
    static hasMany = [bios: Biography, presentations: Presentation, videos: String]

    static mappings = {
    }

    static constraints = {
        title()
        phone()
        twitterId()
        linkedInUrl()
        webUrl()
        company()
        address()
        bios()        
    }
}
