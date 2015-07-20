package com.github.groovyguides.shapes.util

/**
 *
 *
 * @author Duncan Dickinson
 */
class Messages {

    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", Locale.getDefault())

    public static String getString(String key) {
        return resourceBundle.getString(key)
    }
}
