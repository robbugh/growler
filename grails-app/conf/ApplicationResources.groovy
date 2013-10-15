modules = {
    application {
        resource url:'js/application.js'
    }
    'angular-scaffolding' {
        dependsOn 'jquery', 'angular-resource'
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'scaffolding.js']
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'grails-default.js']
        resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'css', file: 'scaffolding.css']
    }
}