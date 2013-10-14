package org.growler

class Speaker extends Member {

    String title
    String phone
    String twitterId
    String linkedInUrl
    String webUrl
    String Address
    String company
    String bio
    //File photo -- Use Gravatar instead?
    
    Set<Presentation> presentations
    Set<URL> presentationsVideoUrls

    static mappings = {
    }

    static constraints = {
    }
}
