package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import groovy.transform.ToString

/**
 * Base class for 2D shapes
 * @author Duncan Dickinson
 */
@ToString(includeNames=true,includeFields=true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    protected LengthMeasurement perimeter

    protected LengthMeasurement area

    /**
     * Not used
     */
    protected BasicTwoDimensionalShape() {

    }

    protected void setPerimeter(LengthMeasurement perimeter) {
        this.perimeter = perimeter
    }

    protected void setArea(LengthMeasurement area) {
        this.area = area
    }

    /**
     *
     * @return the perimeter of the shape
     */
    public LengthMeasurement getPerimeter() {
        perimeter
    }

    /**
     *
     * @return the area of the shape
     */
    public LengthMeasurement getArea() {
        area
    }

}