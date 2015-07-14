package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Measurement
import groovy.transform.ToString

/**
 *
 * @author Duncan Dickinson
 */
@ToString(includeNames=true,includeFields=true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    /** */
    final protected Measurement perimeter

    /** */
    final protected Measurement area

    /**
     *
     */
    protected BasicTwoDimensionalShape() {

    }


    /**
     *
     * @return
     */
    public Measurement getPerimeter() {perimeter}

    /**
     *
     * @return
     */
    public Measurement getArea() {area}

}