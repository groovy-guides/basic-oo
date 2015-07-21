package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includeFields = true, cache = true)
@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Rectangle extends BasicTwoDimensionalShape {

    private final LengthMeasurement length

    private final LengthMeasurement width

    /**
     * Not useful
     */
    Rectangle(){}

    /**
     * A rectangular shape
     * @param length
     * @param width
     * @throws IllegalArgumentException if the length and width are of different units of measurement
     */
    Rectangle(LengthMeasurement length, LengthMeasurement width) throws IllegalArgumentException {
        if (!LengthMeasurement.checkUnitsOfMeasurementAreTheSame(length, width)) {
            throw new SameUoLRequiredException()
        }
        this.length = length
        this.width = width
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter(this.length * 2 + this.width * 2)
    }

    @Override
    protected void calculateArea() {
        this.area = this.length * this.width
    }

    LengthMeasurement getLength() {
        length
    }

    LengthMeasurement getWidth() {
        width
    }
}
