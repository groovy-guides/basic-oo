package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.util.Messages

/**
 *
 *
 * @author Duncan Dickinson
 */
class LengthNotPositiveException extends IllegalArgumentException {
    public static final String LENGTH_GREATER_THAN_0 = Messages.getString('LengthNotPositiveException.message')

    LengthNotPositiveException() {
        super(LENGTH_GREATER_THAN_0)
    }

    LengthNotPositiveException(String message) {
        super(message)
    }

    LengthNotPositiveException(String message, Throwable cause) {
        super(message, cause)
    }

    LengthNotPositiveException(Throwable cause) {
        super(LENGTH_GREATER_THAN_0, cause)
    }
}
