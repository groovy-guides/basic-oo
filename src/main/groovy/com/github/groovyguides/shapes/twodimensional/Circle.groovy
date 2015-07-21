package com.github.groovyguides.shapes.twodimensional

import static java.lang.Math.PI
import com.github.groovyguides.shapes.measurement.LengthMeasurement
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includeFields = true)
@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Circle extends BasicTwoDimensionalShape {

    private final LengthMeasurement radius
    private final LengthMeasurement diameter

    private Circle() {}

    Circle(LengthMeasurement radius) {
        this.radius = radius
        this.diameter = this.radius * 2
    }

    @Override
    protected void calculatePerimeter() {
        this.perimeter = this.diameter * PI
    }

    @Override
    protected void calculateArea() {
        this.area = this.radius**2 * PI
    }

    LengthMeasurement getRadius() {
        radius
    }

    LengthMeasurement getDiameter() {
        diameter
    }

    LengthMeasurement getCircumference() {
        super.perimeter
    }
}
