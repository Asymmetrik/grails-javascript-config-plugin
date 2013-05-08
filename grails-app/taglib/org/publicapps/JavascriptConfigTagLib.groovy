package org.publicapps

import grails.converters.JSON

class JavascriptConfigTagLib {
	
	static namespace = "jc"
	
	def javascriptConfig = { attrs, body ->
		
		out << '<script type="text/javascript">\n'
		out << '//<![CDATA[\n'
		out << 'Config = {};\n'
		grailsApplication.config.javascript.each { k,v ->
			if ( v instanceof String ) {
				out << "Config.${k} = \"${v}\";\n"
			} else if ( v instanceof List || v instanceof Map ) {
				out << "Config.${k} = ${v as JSON};\n"
			} else {
				out << "Config.${k} = ${v};\n"
			}
		}
		out << '//]]>\n'
		out << '</script>\n'
	}

}
