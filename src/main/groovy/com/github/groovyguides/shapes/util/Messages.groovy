package com.github.groovyguides.shapes.util

/**
 *
 *
 * @author Duncan Dickinson
 */
class Messages {

    public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle('Messages', Locale.default)

    static String getString(String key) {
        RESOURCE_BUNDLE.getString(key)
    }
}
