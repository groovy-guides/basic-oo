package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement

/**
 * @author Duncan Dickinson
 */
class Square extends Rectangle {

    /**
     * Not useful
     */
    Square() {

    }

    Square(LengthMeasurement length) {
        super(length, length)
    }
}
