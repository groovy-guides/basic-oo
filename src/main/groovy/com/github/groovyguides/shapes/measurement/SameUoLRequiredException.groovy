package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.util.Messages

/**
 *
 *
 * @author Duncan Dickinson
 */
class SameUoLRequiredException extends IllegalArgumentException {
    public static final String SAME_UOL_REQUIRED = Messages.getString('SameUoLRequiredException.message')

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
        super(SAME_UOL_REQUIRED, cause)
    }
}
