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

    Measurement(BigDecimal value, UnitOfMeasurement unit) {
        if (value <= 0) {
            throw new IllegalArgumentException('The value must be greater than 0')
        }

        this.value = value
        this.unit = unit
    }

    public Measurement plus(Measurement right) {
        if (this.unit == right.unit) {
            return new Measurement(this.value + right.value, this.unit)
        }
    }

    public Measurement minus(Measurement right) {
        if (this.unit == right.unit) {
            return new Measurement(this.value - right.value, this.unit)
        }
    }

    public Measurement div(Measurement right) {
        if (this.unit == right.unit) {
            return new Measurement(this.value / right.value, this.unit)
        }
    }

    public Measurement multiply(Measurement right) {
        if (this.unit == right.unit) {
            return new Measurement(this.value * right.value, this.unit)
        }
    }

    public Measurement multiply(Number right) {
        return new Measurement(this.value * right, this.unit)
    }

    public Measurement power(Number exponent) {
        return new Measurement(this.value**exponent, this.unit)
    }

}
