package com.github.groovyguides.shapes.measurement

/**
 *
 *
 * @author Duncan Dickinson
 */
class SameUoLRequiredException extends IllegalArgumentException {
    public static final String SAME_UOL_REQUIRED = 'Can only use Measurements with the same UnitOfLength'

    SameUoLRequiredException() {
        super(SAME_UOL_REQUIRED)
    }

    SameUoLRequiredException(String message) {
        super(message)
    }

    SameUoLRequiredException(String message, Throwable cause) {
        super(message, cause)
    }

    SameUoLRequiredException(Throwable cause) {
        super(cause)
    }
}
