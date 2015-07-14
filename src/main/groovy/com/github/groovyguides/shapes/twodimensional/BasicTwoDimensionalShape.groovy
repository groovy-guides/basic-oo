package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

/**
 *
 * @author Duncan Dickinson
 */
@ToString(includeNames=true,includeFields=true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    /** */
    final protected Number perimeter

    /** */
    final protected Number area

    /**
     *
     */
    protected BasicTwoDimensionalShape() {

    }


    /**
     *
     * @return
     */
    public Number getPerimeter() {perimeter}

    /**
     *
     * @return
     */
    public Number getArea() {area}

}