grails-javascript-config-plugin
===============================

Grails plugin that exposes values from Config.groovy in Javascript via a GSP tag.

Usage
=====
Add the plugin to your application's dependencies in BuildConfig.groovy

    runtime ':javascript-config:0.1'

Add a javascript section to your Config.groovy:

    javascript {
       foo = 1
       bar = "abc"
       baz = ['a','b','c']
       buz = ['a': 1, 'b': 2, 'c': 3]
    }

Use the tag in your GSP:

    <jc:javascriptConfig />
