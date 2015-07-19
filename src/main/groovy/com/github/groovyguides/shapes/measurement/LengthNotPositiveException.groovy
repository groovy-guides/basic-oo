package com.github.groovyguides.shapes.measurement

/**
 *
 *
 * @author Duncan Dickinson
 */
class LengthNotPositiveException extends IllegalArgumentException {
    public static final String LENGTH_GREATER_THAN_0 = 'The length must be greater than 0'

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
        super(cause)
    }
}
