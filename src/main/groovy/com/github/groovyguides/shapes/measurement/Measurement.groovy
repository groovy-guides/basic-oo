package com.github.groovyguides.shapes.measurement

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 *
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode
@ToString(includeNames = true, includeFields = true)
class Measurement {
    private final BigDecimal value
    private final UnitOfMeasurement unit

    Measurement(BigDecimal value, UnitOfMeasurement unit) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(value)

        this.value = value
        this.unit = unit
    }

    public BigDecimal getValue() {
        this.value
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        this.unit
    }

    private static Boolean checkMeasurementValueIsPositive(BigDecimal v) throws IllegalArgumentException {
        if (v <= 0) {
            throw new IllegalArgumentException('The value must be greater than 0')
        }
        true
    }

    private
    static Boolean checkUnitsOfMeasurementAreTheSame(Measurement m1, Measurement m2) throws IllegalArgumentException {
        if (m1.unit != m2.unit) {
            throw new IllegalArgumentException('Can only use Measurements with the same unit of measurement')
        }
    }

    public Measurement plus(Measurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this + right.value
    }

    public Measurement plus(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(value)
        return new Measurement(this.value + right, this.unit)
    }

    public Measurement minus(Measurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this - right.value
    }

    public Measurement minus(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(value)
        Measurement result
        try{
            result = new Measurement(this.value - right, this.unit)
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException('The resulting measurement value is <=0 and a measurement cannot be negative',e)
        }
        return result
    }


    public Measurement div(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(right)
        return new Measurement(this.value / right, this.unit)
    }


    public Measurement multiply(Number right) {
        checkMeasurementValueIsPositive(right)
        return new Measurement(this.value * right, this.unit)
    }

    public Measurement power(Number exponent) {
        return new Measurement(this.value**exponent, this.unit)
    }

}
