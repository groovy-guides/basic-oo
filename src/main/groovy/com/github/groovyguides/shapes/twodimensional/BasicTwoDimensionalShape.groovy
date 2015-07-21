package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import groovy.transform.ToString

/**
 * Base class for 2D shapes
 * @author Duncan Dickinson
 */
@ToString(includeNames=true,includeFields=true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    private LengthMeasurement perimeter = null

    private LengthMeasurement area = null

    abstract protected void calculatePerimeter()

    abstract protected void calculateArea()

    /**
     *
     * @return the perimeter of the shape
     */
    LengthMeasurement getPerimeter() {
        if (!this.perimeter) {
            calculatePerimeter()
        }
        this.perimeter
    }

    /**
     *
     * @return the area of the shape
     */
    LengthMeasurement getArea() {
        if (!this.area) {
            calculateArea()
        }
        this.area
    }

    protected void setPerimeter(LengthMeasurement perimeter) {
        this.perimeter = perimeter
    }

    protected void setArea(LengthMeasurement area) {
        this.area = area
    }
}
