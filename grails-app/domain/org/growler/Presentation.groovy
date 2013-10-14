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
    Set<URL> videos
    
    //Set<File> files

    static mappings = {
    }

    static constraints = {
    }
}
