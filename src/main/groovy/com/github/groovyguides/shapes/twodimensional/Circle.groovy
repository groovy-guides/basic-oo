package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import static java.lang.Math.PI

@EqualsAndHashCode(includeFields=true)
@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Circle extends BasicTwoDimensionalShape {
    
    private final LengthMeasurement radius
    private final LengthMeasurement diameter
    
    private Circle() {}
    
    public Circle(LengthMeasurement radius) {
        this.radius = radius
        this.diameter = this.radius * 2
        this.perimeter = this.diameter * PI
        this.area = this.radius**2 * PI
    }

    LengthMeasurement getRadius() {
        return radius
    }

    LengthMeasurement getDiameter() {
        return diameter
    }

    LengthMeasurement getCircumference() {
        return perimeter
    }
}