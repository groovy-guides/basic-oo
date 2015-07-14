package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Measurement

/**
 *
 */
interface TwoDimensionalShape {

    /**
     *
     * @return the perimeter of the shape
     */
    public Measurement getPerimeter()

    /**
     *
     * @return the area of the shape
     */
    public Measurement getArea()
}