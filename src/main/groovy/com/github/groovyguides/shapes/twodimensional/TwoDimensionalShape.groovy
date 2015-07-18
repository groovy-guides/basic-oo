package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement

/**
 *
 */
interface TwoDimensionalShape {

    /**
     *
     * @return the perimeter of the shape
     */
    public LengthMeasurement getPerimeter()

    /**
     *
     * @return the area of the shape
     */
    public LengthMeasurement getArea()
}