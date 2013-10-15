package org.growler

class Presentation {

    enum Format {
        WORKSHOP,
        PANEL_DISCUSSION,
        LECTURE
    }

    String title
    String summary
    String abstractText
    int format
    String materialsNeeded
    String targetAudiance
    int lengthMinutes

    static hasMany = [videos: String, files: String]
    
    static mappings = {
    }

    static constraints = {
    }
}
