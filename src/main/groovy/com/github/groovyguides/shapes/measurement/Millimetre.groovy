package com.github.groovyguides.shapes.measurement

/**
 * A helper subclass of LengthMeasurement
 *
 * @author Duncan Dickinson
 */
class Millimetre extends LengthMeasurement {

    Millimetre(Integer value) {
        super(value, UnitOfLength.Millimetre)
    }
}
