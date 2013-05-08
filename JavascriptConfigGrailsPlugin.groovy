class JavascriptConfigGrailsPlugin {

    def version = "0.1"

    def grailsVersion = "2.1 > *"

    def dependsOn = [:]

    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Javascript Config Plugin"
    def author = "Eric Turner"
    def authorEmail = "erturne@gmail.com"
    def description = '''\
Provides a GSP tag to expose values from Config.groovy in a Javascript Config object.
'''
    def documentation = "http://grails.org/plugin/javascript-config"

    def license = "APACHE"
	def issueManagement = [ system: "GitHub", url: "https://github.com/erturne/grails-javascript-config-plugin" ]
	def scm = [ url: "https://github.com/erturne/grails-javascript-config-plugin" ]

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }

    def onShutdown = { event ->
    }
}
