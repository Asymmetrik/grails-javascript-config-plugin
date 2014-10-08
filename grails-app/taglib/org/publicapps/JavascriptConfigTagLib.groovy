package org.publicapps

import grails.converters.JSON

class JavascriptConfigTagLib {
	
	static namespace = "jc"
	
	def javascriptConfig = { attrs, body ->
		
		out << '<script class="javascript-config" type="text/javascript">\r\n'
		out << '//<![CDATA[\r\n'
		out << 'Config = {};\r\n'
		grailsApplication.config.javascript.each { k,v ->
			if ( v instanceof String || v instanceof GString ) {
				def jsIfied = [v] as JSON
				def matcher = ( jsIfied =~ /^\[(.+)\]$/ )
				if ( matcher[0] && matcher[0].size() > 1 ) {
					out << "Config.${K}=${matcher[0][1]};\r\n"	
				} else {
					out << "Config.${k} = \"${v}\";\r\n"
				}
			} else if ( v instanceof List || v instanceof Map ) {
				out << "Config.${k} = ${v as JSON};\r\n"
			} else {
				out << "Config.${k} = ${v};\r\n"
			}
		}
		
		// NOTE: We don't include every session value because there might be
		// large objects stored in the session, which we wouldn't want to output
		// to the browser. Feel free to modify this to add other session values.
		out << "Config.session = {};\r\n"
		if ( session?.dn ) {
			out << " Config.session.dn=\"${escapeJavascriptString(session.dn)}\";\r\n"
		}
		if ( session?.sid ) {
			out << " Config.session.sid=\"${escapeJavascriptString(session.sid)}\";\r\n"
		}
		out << '//]]>\n'
		out << '</script>\n'
	}
	
	private String escapeJavascriptString(String value) {
		// Double quote and reverse solidus (aka forward slash) must be escaped
		// in a Javascript property. See http://www.json.org.
		//List itemsToEscape = ["\"", "/"]
		List itemsToEscape = ["\""]
		
		StringBuilder builder = new StringBuilder(value)
		
		itemsToEscape.each { def item ->
			def replacement = "\\${item}"
			
			Integer index = builder.indexOf(item)
			while ( index != -1 ) {
				builder.replace(index, index + item.size(), replacement)
				index = index + replacement.size()
				index = builder.indexOf(item, index)
			}
		}
		
		return builder.toString()
	}

}
