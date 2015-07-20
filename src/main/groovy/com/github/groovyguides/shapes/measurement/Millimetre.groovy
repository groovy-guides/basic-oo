package com.github.groovyguides.shapes.measurement

/**
 * A helper subclass of LengthMeasurement
 *
 * @author Duncan Dickinson
 */
class Millimetre extends LengthMeasurement {

    Millimetre(Number value) {
        super(value, UnitOfLength.MILLIMETRE)
    }
}
